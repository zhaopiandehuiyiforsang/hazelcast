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

import java.lang.reflect.Field;

/**
 * Standard {@link com.hazelcast.internal.memory.MemoryAccessor} implementations
 * that directly uses {@link sun.misc.Unsafe} for accessing to memory.
 */
public class StandardMemoryAccessor extends UnsafeBasedMemoryAccessor {

    public static final StandardMemoryAccessor INSTANCE = AVAILABLE ? new StandardMemoryAccessor() : null;

    StandardMemoryAccessor() {
        if (!AVAILABLE) {
            throw new IllegalStateException(getClass().getName() + " can only be used only when Unsafe is available!");
        }
    }


    // Address-based memory access

    @Override
    public Object getObject(long offset) {
        return UNSAFE.getObject(null, offset);
    }

    @Override
    public void putObject(long offset, Object x) {
        UNSAFE.putObject(null, offset, x);
    }

    @Override
    public boolean getBoolean(long address) {
        return UNSAFE.getBoolean(null, address);
    }

    @Override
    public void putBoolean(long address, boolean x) {
        UNSAFE.putBoolean(null, address, x);
    }

    @Override
    public byte getByte(long address) {
        return UNSAFE.getByte(address);
    }

    @Override
    public void putByte(long address, byte x) {
        UNSAFE.putByte(address, x);
    }

    @Override
    public char getChar(long address) {
        return UNSAFE.getChar(address);
    }

    @Override
    public void putChar(long address, char x) {
        UNSAFE.putChar(address, x);
    }

    @Override
    public short getShort(long address) {
        return UNSAFE.getShort(address);
    }

    @Override
    public void putShort(long address, short x) {
        UNSAFE.putShort(address, x);
    }

    @Override
    public int getInt(long address) {
        return UNSAFE.getInt(address);
    }

    @Override
    public void putInt(long address, int x) {
        UNSAFE.putInt(address, x);
    }

    @Override
    public float getFloat(long address) {
        return UNSAFE.getFloat(address);
    }

    @Override
    public void putFloat(long address, float x) {
        UNSAFE.putFloat(address, x);
    }

    @Override
    public long getLong(long address) {
        return UNSAFE.getLong(address);
    }

    @Override
    public void putLong(long address, long x) {
        UNSAFE.putLong(address, x);
    }

    @Override
    public double getDouble(long address) {
        return UNSAFE.getDouble(address);
    }

    @Override
    public void putDouble(long address, double x) {
        UNSAFE.putDouble(address, x);
    }

    @Override
    public void copyMemory(long srcAddress, long destAddress, long lengthBytes) {
        UNSAFE.copyMemory(srcAddress, destAddress, lengthBytes);
    }

    @Override
    public void setMemory(long address, long lengthBytes, byte value) {
        UNSAFE.setMemory(address, lengthBytes, value);
    }


    @Override
    public boolean getBooleanVolatile(long offset) {
        return UNSAFE.getBooleanVolatile(null, offset);
    }

    @Override
    public void putBooleanVolatile(long offset, boolean x) {
        UNSAFE.putBooleanVolatile(null, offset, x);
    }

    @Override
    public byte getByteVolatile(long offset) {
        return UNSAFE.getByteVolatile(null, offset);
    }

    @Override
    public void putByteVolatile(long offset, byte x) {
        UNSAFE.putByteVolatile(null, offset, x);
    }

    @Override
    public char getCharVolatile(long offset) {
        return UNSAFE.getCharVolatile(null, offset);
    }

    @Override
    public void putCharVolatile(long offset, char x) {
        UNSAFE.putCharVolatile(null, offset, x);
    }

    @Override
    public short getShortVolatile(long offset) {
        return UNSAFE.getShortVolatile(null, offset);
    }

    @Override
    public void putShortVolatile(long offset, short x) {
        UNSAFE.putShortVolatile(null, offset, x);
    }

    @Override
    public int getIntVolatile(long offset) {
        return UNSAFE.getIntVolatile(null, offset);
    }

    @Override
    public void putIntVolatile(long offset, int x) {
        UNSAFE.putIntVolatile(null, offset, x);
    }

    @Override
    public float getFloatVolatile(long offset) {
        return UNSAFE.getFloatVolatile(null, offset);
    }

    @Override
    public void putFloatVolatile(long offset, float x) {
        UNSAFE.putFloatVolatile(null, offset, x);
    }

    @Override
    public long getLongVolatile(long offset) {
        return UNSAFE.getLongVolatile(null, offset);
    }

    @Override
    public void putLongVolatile(long offset, long x) {
        UNSAFE.putLongVolatile(null, offset, x);
    }

    @Override
    public double getDoubleVolatile(long offset) {
        return UNSAFE.getDoubleVolatile(null, offset);
    }

    @Override
    public void putDoubleVolatile(long offset, double x) {
        UNSAFE.putDoubleVolatile(null, offset, x);
    }

    @Override
    public Object getObjectVolatile(long offset) {
        return UNSAFE.getObjectVolatile(null, offset);
    }

    @Override
    public void putObjectVolatile(long offset, Object x) {
        UNSAFE.putObjectVolatile(null, offset, x);
    }


    @Override
    public boolean compareAndSwapInt(long offset, int expected, int x) {
        return UNSAFE.compareAndSwapInt(null, offset, expected, x);
    }

    @Override
    public boolean compareAndSwapLong(long offset, long expected, long x) {
        return UNSAFE.compareAndSwapLong(null, offset, expected, x);
    }

    @Override
    public boolean compareAndSwapObject(long offset, Object expected, Object x) {
        return UNSAFE.compareAndSwapObject(null, offset, expected, x);
    }


    @Override
    public void putOrderedInt(long offset, int x) {
        UNSAFE.putOrderedInt(null, offset, x);
    }

    @Override
    public void putOrderedLong(long offset, long x) {
        UNSAFE.putOrderedLong(null, offset, x);
    }

    @Override
    public void putOrderedObject(long offset, Object x) {
        UNSAFE.putOrderedObject(null, offset, x);
    }



    // Object-based memory access

    @Override
    public long objectFieldOffset(Field field) {
        return UNSAFE.objectFieldOffset(field);
    }

    @Override
    public int arrayBaseOffset(Class<?> arrayClass) {
        return UNSAFE.arrayBaseOffset(arrayClass);
    }

    @Override
    public int arrayIndexScale(Class<?> arrayClass) {
        return UNSAFE.arrayIndexScale(arrayClass);
    }



    @Override
    public Object getObject(Object base, long offset) {
        return UNSAFE.getObject(base, offset);
    }

    @Override
    public void putObject(Object base, long offset, Object x) {
        UNSAFE.putObject(base, offset, x);
    }

    @Override
    public boolean getBoolean(Object base, long offset) {
        return UNSAFE.getBoolean(base, offset);
    }

    @Override
    public void putBoolean(Object base, long offset, boolean x) {
        UNSAFE.putBoolean(base, offset, x);
    }

    @Override
    public byte getByte(Object base, long offset) {
        return UNSAFE.getByte(base, offset);
    }

    @Override
    public void putByte(Object base, long offset, byte x) {
        UNSAFE.putByte(base, offset, x);
    }

    @Override
    public char getChar(Object base, long offset) {
        return UNSAFE.getChar(base, offset);
    }

    @Override
    public void putChar(Object base, long offset, char x) {
        UNSAFE.putChar(base, offset, x);
    }

    @Override
    public short getShort(Object base, long offset) {
        return UNSAFE.getShort(base, offset);
    }

    @Override
    public void putShort(Object base, long offset, short x) {
        UNSAFE.putShort(base, offset, x);
    }

    @Override
    public int getInt(Object base, long offset) {
        return UNSAFE.getInt(base, offset);
    }

    @Override
    public void putInt(Object base, long offset, int x) {
        UNSAFE.putInt(base, offset, x);
    }

    @Override
    public float getFloat(Object base, long offset) {
        return UNSAFE.getFloat(base, offset);
    }

    @Override
    public void putFloat(Object base, long offset, float x) {
        UNSAFE.putFloat(base, offset, x);
    }

    @Override
    public long getLong(Object base, long offset) {
        return UNSAFE.getLong(base, offset);
    }

    @Override
    public void putLong(Object base, long offset, long x) {
        UNSAFE.putLong(base, offset, x);
    }

    @Override
    public double getDouble(Object base, long offset) {
        return UNSAFE.getDouble(base, offset);
    }

    @Override
    public void putDouble(Object base, long offset, double x) {
        UNSAFE.putDouble(base, offset, x);
    }



    @Override
    public void copyMemory(Object srcObj, long srcOffset, Object destObj, long destOffset, long lengthBytes) {
        UNSAFE.copyMemory(srcObj, srcOffset, destObj, destOffset, lengthBytes);
    }



    @Override
    public Object getObjectVolatile(Object base, long offset) {
        return UNSAFE.getObjectVolatile(base, offset);
    }

    @Override
    public void putObjectVolatile(Object base, long offset, Object x) {
        UNSAFE.putObjectVolatile(base, offset, x);
    }

    @Override
    public boolean getBooleanVolatile(Object base, long offset) {
        return UNSAFE.getBooleanVolatile(base, offset);
    }

    @Override
    public void putBooleanVolatile(Object base, long offset, boolean x) {
        UNSAFE.putBooleanVolatile(base, offset, x);
    }

    @Override
    public byte getByteVolatile(Object base, long offset) {
        return UNSAFE.getByteVolatile(base, offset);
    }

    @Override
    public void putByteVolatile(Object base, long offset, byte x) {
        UNSAFE.putByteVolatile(base, offset, x);
    }

    @Override
    public char getCharVolatile(Object base, long offset) {
        return UNSAFE.getCharVolatile(base, offset);
    }

    @Override
    public void putCharVolatile(Object base, long offset, char x) {
        UNSAFE.putCharVolatile(base, offset, x);
    }

    @Override
    public short getShortVolatile(Object base, long offset) {
        return UNSAFE.getShortVolatile(base, offset);
    }

    @Override
    public void putShortVolatile(Object base, long offset, short x) {
        UNSAFE.putShortVolatile(base, offset, x);
    }

    @Override
    public int getIntVolatile(Object base, long offset) {
        return UNSAFE.getIntVolatile(base, offset);
    }

    @Override
    public void putIntVolatile(Object base, long offset, int x) {
        UNSAFE.putIntVolatile(base, offset, x);
    }

    @Override
    public float getFloatVolatile(Object base, long offset) {
        return UNSAFE.getFloatVolatile(base, offset);
    }

    @Override
    public void putFloatVolatile(Object base, long offset, float x) {
        UNSAFE.putFloatVolatile(base, offset, x);
    }

    @Override
    public long getLongVolatile(Object base, long offset) {
        return UNSAFE.getLongVolatile(base, offset);
    }

    @Override
    public void putLongVolatile(Object base, long offset, long x) {
        UNSAFE.putLongVolatile(base, offset, x);
    }

    @Override
    public double getDoubleVolatile(Object base, long offset) {
        return UNSAFE.getDoubleVolatile(base, offset);
    }

    @Override
    public void putDoubleVolatile(Object base, long offset, double x) {
        UNSAFE.putDoubleVolatile(base, offset, x);
    }



    @Override
    public void putOrderedInt(Object base, long offset, int x) {
        UNSAFE.putOrderedInt(base, offset, x);
    }

    @Override
    public void putOrderedLong(Object base, long offset, long x) {
        UNSAFE.putOrderedLong(base, offset, x);
    }

    @Override
    public void putOrderedObject(Object base, long offset, Object x) {
        UNSAFE.putOrderedObject(base, offset, x);
    }



    @Override
    public boolean compareAndSwapInt(Object base, long offset, int expected, int x) {
        return UNSAFE.compareAndSwapInt(base, offset, expected, x);
    }

    @Override
    public boolean compareAndSwapLong(Object base, long offset, long expected, long x) {
        return UNSAFE.compareAndSwapLong(base, offset, expected, x);
    }

    @Override
    public boolean compareAndSwapObject(Object base, long offset, Object expected, Object x) {
        return UNSAFE.compareAndSwapObject(base, offset, expected, x);
    }
}
