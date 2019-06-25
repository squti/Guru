/*
 * MIT License
 *
 * Copyright (c) 2019 squti
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.squti.guru;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

import androidx.annotation.Nullable;

import java.util.Map;
import java.util.Set;


public class Guru {

    @SuppressLint("StaticFieldLeak")
    private static volatile Guru singleton = null;
    private SharedPreferences sharedPreferences;

    private Guru(Context context) {
        sharedPreferences = context.getSharedPreferences(
                GuruConfig.getInstance().getFileName()
                , GuruConfig.getInstance().getMode());

    }
    public static Guru getInstance() {
        if (singleton == null) {
            synchronized (Guru.class) {
                if (singleton == null) {
                    if (GuruProvider.context == null) {
                        throw new IllegalStateException("context can not be null");
                    }
                    singleton = new Guru(GuruProvider.context);
                }
            }
        }
        return singleton;
    }


    public static Map<String, ?> getAll() {
        return getInstance().sharedPreferences.getAll();
    }

    @Nullable
    public static String getString(String key, @Nullable String defValue) {
        return getInstance().sharedPreferences.getString(key, defValue);
    }

    @Nullable
    public static Set<String> getStringSet(String key, @Nullable Set<String> defValues) {
        return getInstance().sharedPreferences.getStringSet(key, defValues);
    }

    public static int getInt(String key, int defValue) {
        return getInstance().sharedPreferences.getInt(key, defValue);
    }

    public static long getLong(String key, long defValue) {
        return getInstance().sharedPreferences.getLong(key, defValue);
    }

    public static float getFloat(String key, float defValue) {
        return getInstance().sharedPreferences.getFloat(key, defValue);
    }

    public static boolean getBoolean(String key, boolean defValue) {
        return getInstance().sharedPreferences.getBoolean(key, defValue);
    }

    public static boolean contains(String key) {
        return getInstance().sharedPreferences.contains(key);
    }


    public static void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        getInstance().sharedPreferences.registerOnSharedPreferenceChangeListener(listener);
    }

    public static void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        getInstance().sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener);
    }

    public static void putString(String key, @Nullable String value) {
        getInstance().sharedPreferences.edit().putString(key, value).apply();
    }

    public static void putStringSet(String key, @Nullable Set<String> values) {
        getInstance().sharedPreferences.edit().putStringSet(key, values).apply();
    }

    public static void putInt(String key, int value) {
        getInstance().sharedPreferences.edit().putInt(key, value).apply();
    }

    public static void putLong(String key, long value) {
        getInstance().sharedPreferences.edit().putLong(key, value).apply();
    }

    public static void putFloat(String key, float value) {
        getInstance().sharedPreferences.edit().putFloat(key, value).apply();
    }

    public static void putBoolean(String key, boolean value) {
        getInstance().sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public static void remove(String key) {
        getInstance().sharedPreferences.edit().remove(key).apply();
    }

    public static void clear() {
        getInstance().sharedPreferences.edit().clear().apply();
    }

}
