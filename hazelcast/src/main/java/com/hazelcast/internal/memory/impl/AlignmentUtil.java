/*
 * Copyright (c) 2008-2016, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.internal.memory.impl;

import java.nio.ByteOrder;

public final class AlignmentUtil {
    public static final int OBJECT_REFERENCE_ALIGN = UnsafeUtil.UNSAFE.arrayIndexScale(Object[].class);
    public static final int OBJECT_REFERENCE_MASK = OBJECT_REFERENCE_ALIGN - 1;
    public static final boolean IS_PLATFORM_BIG_ENDIAN = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;

    private AlignmentUtil() {

    }

    public static boolean is2BytesAligned(long value) {
        return (value & 0x01) == 0;
    }

    public static boolean is4BytesAligned(long value) {
        return (value & 0x03) == 0;
    }

    public static boolean is8BytesAligned(long value) {
        return (value & 0x07) == 0;
    }

    public static boolean isReferenceAligned(long offset) {
        return (offset & OBJECT_REFERENCE_MASK) == 0;
    }

    public static void checkReferenceAligned(long offset) {
        if (!isReferenceAligned(offset)) {
            throw new IllegalArgumentException("Memory accesses to references must be "
                    + OBJECT_REFERENCE_ALIGN + "-bytes aligned, but it is " + offset);
        }
    }

    public static boolean isUnalignedAccessAllowed() {
        // we can't use Unsafe to access memory on platforms where unaligned access is not allowed
        // see https://github.com/hazelcast/hazelcast/issues/5518 for details.
        String arch = System.getProperty("os.arch");
        // list of architectures copied from OpenJDK - java.nio.Bits::unaligned
        return arch.equals("i386") || arch.equals("x86") || arch.equals("amd64") || arch.equals("x86_64");
    }
}
