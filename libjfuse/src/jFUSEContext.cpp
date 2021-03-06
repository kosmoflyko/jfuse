/*-
 * jFUSE - FUSE bindings for Java
 * Copyright (C) 2008-2009  Erik Larsson <erik82@kth.se>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

#include "jFUSEContext.h"

#include "CSLog.h"
#include "common.h"

jFUSEContext::jFUSEContext(JNIEnv* env, jobject fsProvider) {
    if(env == NULL)
        throw "env == NULL";
    if(fsProvider == NULL)
        throw "fsProvider == NULL";
    
    this->env = env;
    this->fsProvider = fsProvider;
    this->privateData = NULL;
    this->initEnabled = false;
#if defined(__APPLE__) || defined(__DARWIN__)
#if __FreeBSD__ >= 10
    this->xtimesEnabled = false;
#endif /* __FreeBSD__ >= 10 */
#endif /* defined(__APPLE__) || defined(__DARWIN__) */
}

jFUSEContext::~jFUSEContext() {
    setPrivateData(NULL); // Cleans up global ref.
}

JNIEnv* jFUSEContext::getJNIEnv() {
    return env;
}

jobject jFUSEContext::getFSProvider() {
    return fsProvider;
}

jmethodID jFUSEContext::getFSProviderMethod(const char *name, const char *signature) {
    jmethodID result = NULL;
    jclass cls = NULL;
    
    do {
        cls = env->GetObjectClass(fsProvider);
        if(cls == NULL || env->ExceptionCheck() == JNI_TRUE) {
            CSLogError("Could not get class of fsProvider!");
            if(env->ExceptionCheck() == JNI_FALSE)
                throwByName(env, "java/lang/RuntimeException", "Could not get Class of fsProvider");
            break;
        }

        result = env->GetMethodID(cls, name, signature);
    } while(0);

    if(cls != NULL)
        env->DeleteLocalRef(cls);

    return result;
}

jobject jFUSEContext::getPrivateData() {
    return this->privateData;
}
void jFUSEContext::setPrivateData(jobject obj) {
    jobject globj = NULL;
    if(obj != NULL)
        globj = env->NewGlobalRef(obj);
    if(this->privateData != NULL)
        env->DeleteGlobalRef(this->privateData);

    this->privateData = globj;
}

bool jFUSEContext::getInitEnabled() {
    return this->initEnabled;
}

void jFUSEContext::setInitEnabled(bool b) {
    this->initEnabled = b;
}

#if defined(__APPLE__) || defined(__DARWIN__)
#if (__FreeBSD__ >= 10)
bool jFUSEContext::getXtimesEnabled() {
    return this->xtimesEnabled;
}

void jFUSEContext::setXtimesEnabled(bool b) {
    this->xtimesEnabled = b;
}
#endif /* __FreeBSD__ >= 10 */
#endif /* defined(__APPLE__) || defined(__DARWIN__) */
