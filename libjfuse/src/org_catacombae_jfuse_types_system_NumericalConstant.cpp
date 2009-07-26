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

#define LOG_ENABLE_TRACE 0

#include "org_catacombae_jfuse_types_system_NumericalConstant.h"

#include "common.h"
#include "CSLog.h"
#include "JavaSignatures.h"

#include <string.h>
#define __STDC_FORMAT_MACROS
#include <inttypes.h>

#include <sys/fcntl.h>
#include <sys/xattr.h>

/*
 * Class:     org_catacombae_jfuse_types_system_NumericalConstant
 * Method:    getNativeValue
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_org_catacombae_jfuse_types_system_NumericalConstant_getNativeValue
  (JNIEnv *env, jclass cls, jstring constantName) {
#define _FNAME_ "Java_org_catacombae_jfuse_types_system_NumericalConstant_getNativeValue"

    CSLogTraceEnter("jint %s(%p, %p, %p)", _FNAME_, env, cls, constantName);
    jint result = -1;
    const char *constantNameChars = env->GetStringUTFChars(constantName, NULL);

    // One truth.
#define else_if_constant(a) \
    else if(strcmp(#a, constantNameChars) == 0) \
        result = (jint)a

    if(0);

    // Constants from sys/fcntl.h
    else_if_constant(O_ACCMODE);
    else_if_constant(O_RDONLY);
    else_if_constant(O_WRONLY);
    else_if_constant(O_RDWR);
    else_if_constant(O_NONBLOCK);
    else_if_constant(O_APPEND);
    else_if_constant(O_CREAT);
    else_if_constant(O_TRUNC);
    else_if_constant(O_EXCL);
    else_if_constant(O_SHLOCK);
    else_if_constant(O_EXLOCK);
    else_if_constant(O_NOFOLLOW);
    else_if_constant(O_SYMLINK);
    else_if_constant(O_SYNC);
    else_if_constant(O_ASYNC);
    else_if_constant(O_EVTONLY);
    else_if_constant(O_NOCTTY);
    else_if_constant(O_DIRECTORY);

    // Constants from sys/xattr.h
    else_if_constant(XATTR_CREATE);
    else_if_constant(XATTR_REPLACE);
    else_if_constant(XATTR_MAXNAMELEN);
    
    //else_if_constant();

    else {
        // If we got here, the constant is unrecognized.
        CSLogError("Could not find a matching constant value for \"%s\".", constantNameChars);
        throwByName(env, NOSUCHCONSTANTEXCEPTION_CLASS, "Unrecognized constant value!");
    }

#undef else_if_constant

    env->ReleaseStringUTFChars(constantName, constantNameChars);

    CSLogTraceLeave("jint %s(%p, %p, %p): %" PRId32, _FNAME_, env, cls,
            constantName, (int32_t)result);
    return result;
}
