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

package org.catacombae.jfuse.types.system;

import org.catacombae.jfuse.JNILoader;

/**
 *
 * @author erik
 */
public enum Errno {
    /** Operation not permitted */
    EPERM,
    /** No such file or directory */
    ENOENT,
    /** No such process */
    ESRCH,
    /** Interrupted system call */
    EINTR,
    /** Input/output error */
    EIO,
    /** Device not configured */
    ENXIO,
    /** Argument list too long */
    E2BIG,
    /** Exec format error */
    ENOEXEC,
    /** Bad file descriptor */
    EBADF,
    /** No child processes */
    ECHILD,
    /** Resource deadlock avoided */
    EDEADLK,
    /** Cannot allocate memory */
    ENOMEM,
    /** Permission denied */
    EACCES,
    /** Bad address */
    EFAULT,
    /** Block device required */
    ENOTBLK,
    /** Device busy */
    EBUSY,
    /** File exists */
    EEXIST,
    /** Cross-device link */
    EXDEV,
    /** Operation not supported by device */
    ENODEV,
    /** Not a directory */
    ENOTDIR,
    /** Is a directory */
    EISDIR,
    /** Invalid argument */
    EINVAL,
    /** Too many open files in system */
    ENFILE,
    /** Too many open files */
    EMFILE,
    /** Inappropriate ioctl for device */
    ENOTTY,
    /** Text file busy */
    ETXTBSY,
    /** File too large */
    EFBIG,
    /** No space left on device */
    ENOSPC,
    /** Illegal seek */
    ESPIPE,
    /** Read-only file system */
    EROFS,
    /** Too many links */
    EMLINK,
    /** Broken pipe */
    EPIPE,
    /* math software */
    /** Numerical argument out of domain */
    EDOM,
    /** Result too large */
    ERANGE,
    /* non-blocking and interrupt i/o */
    /** Resource temporarily unavailable */
    EAGAIN,
    /** Operation would block */
    EWOULDBLOCK,
    /** Operation now in progress */
    EINPROGRESS,
    /** Operation already in progress */
    EALREADY,
    /* ipc/network software -- argument errors */
    /** Socket operation on non-socket */
    ENOTSOCK,
    /** Destination address required */
    EDESTADDRREQ,
    /** Message too long */
    EMSGSIZE,
    /** Protocol wrong type for socket */
    EPROTOTYPE,
    /** Protocol not available */
    ENOPROTOOPT,
    /** Protocol not supported */
    EPROTONOSUPPORT,
    /** Socket type not supported */
    ESOCKTNOSUPPORT,
    /** Operation not supported */
    ENOTSUP,
    /** Operation not supported on socket. */
    EOPNOTSUPP,
    /** Protocol family not supported */
    EPFNOSUPPORT,
    /** Address family not supported by protocol family */
    EAFNOSUPPORT,
    /** Address already in use */
    EADDRINUSE,
    /** Can't assign requested address */
    EADDRNOTAVAIL,
    /* ipc/network software -- operational errors */
    /** Network is down */
    ENETDOWN,
    /** Network is unreachable */
    ENETUNREACH,
    /** Network dropped connection on reset */
    ENETRESET,
    /** Software caused connection abort */
    ECONNABORTED,
    /** Connection reset by peer */
    ECONNRESET,
    /** No buffer space available */
    ENOBUFS,
    /** Socket is already connected */
    EISCONN,
    /** Socket is not connected */
    ENOTCONN,
    /** Can't send after socket shutdown */
    ESHUTDOWN,
    /** Too many references: can't splice */
    ETOOMANYREFS,
    /** Operation timed out */
    ETIMEDOUT,
    /** Connection refused */
    ECONNREFUSED,
    /** Too many levels of symbolic links */
    ELOOP,
    /** File name too long */
    ENAMETOOLONG,
    /* should be rearranged */
    /** Host is down */
    EHOSTDOWN,
    /** No route to host */
    EHOSTUNREACH,
    /** Directory not empty */
    ENOTEMPTY,
    /* quotas & mush */
    /** Too many processes */
    //EPROCLIM, // Does not exist in Linux.
    /** Too many users */
    EUSERS,
    /** Disc quota exceeded */
    EDQUOT,
    /* Network File System */
    /** Stale NFS file handle */
    ESTALE,
    /** Too many levels of remote in path */
    EREMOTE,
    /** RPC struct is bad */
    //EBADRPC, // Does not exist in Linux.
    /** RPC version wrong */
    //ERPCMISMATCH, // Does not exist in Linux.
    /** RPC prog. not avail */
    //EPROGUNAVAIL, // Does not exist in Linux.
    /** Program version wrong */
    //EPROGMISMATCH, // Does not exist in Linux.
    /** Bad procedure for program */
    //EPROCUNAVAIL, // Does not exist in Linux.
    /** No locks available */
    ENOLCK,
    /** Function not implemented */
    ENOSYS,
    /** Inappropriate file type or format */
    //EFTYPE, // Does not exist in Linux.
    /** Authentication error */
    //EAUTH, // Does not exist in Linux.
    /** Need authenticator */
    //ENEEDAUTH, // Does not exist in Linux.
    /* Intelligent device errors */
    /** Device power is off */
    //EPWROFF, // Does not exist in Linux.
    /** Device error, e.g. paper out */
    //EDEVERR, // Does not exist in Linux.
    /** Value too large to be stored in data type */
    EOVERFLOW,
    /* Program loading errors */
    /** Bad executable */
    //EBADEXEC, // Does not exist in Linux.
    /** Bad CPU type in executable */
    //EBADARCH, // Does not exist in Linux.
    /** Shared library version mismatch */
    //ESHLIBVERS, // Does not exist in Linux.
    /** Malformed Mach-O file */
    //EBADMACHO, // Does not exist in Linux.
    /** Operation canceled */
    ECANCELED,
    /** Identifier removed */
    EIDRM,
    /** No message of desired type */
    ENOMSG,
    /** Illegal byte sequence */
    EILSEQ,
    /** Attribute not found */
    ENOATTR, // Should exist in Linux. Check man removexattr(2) / <attr/xattr.h>
    /** Bad message */
    EBADMSG,
    /** Reserved */
    EMULTIHOP,
    /** No message available on STREAM */
    //ENODATA, // Does not exist in FreeBSD.
    /** Reserved */
    ENOLINK,
    /** No STREAM resources */
    //ENOSR, // Does not exist in FreeBSD.
    /** Not a STREAM */
    //ENOSTR, // Does not exist in FreeBSD.
    /** Protocol error */
    EPROTO,
    /** STREAM ioctl timeout */
    //ETIME, // Does not exist in FreeBSD.
    /** Must be equal largest errno */
    //ELAST, // Does not exist in Linux.
    ;

    private final int nativeErrnoValue;

    private Errno() {
        JNILoader.ensureLoaded();

        this.nativeErrnoValue = getNativeErrnoValue(name());
    }

    public int getNativeErrnoValue() {
        return nativeErrnoValue;
    }
    
    private static native int getNativeErrnoValue(String errnoName);

    public static void main(String[] args) {
        for(Errno e : Errno.values())
            System.out.println(e.name() + ": " + e.nativeErrnoValue);
    }
}
