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

import android.content.Context;


public class GuruConfig {

    private static GuruConfig instance = null;
    private String fileName;
    private int mode;

    private GuruConfig(Builder builder) {
        fileName = builder.fileName;
        mode = builder.mode;
    }
    static GuruConfig getInstance() {
        if (instance == null) {
            instance = new GuruConfig(new Builder());
        }
        return instance;
    }

    public static void initDefault(GuruConfig guruConfig) {
        instance = guruConfig;
    }

    String getFileName() {
        return fileName;
    }

    int getMode() {
        return mode;
    }

    public static class Builder {
        private String fileName = BuildConfig.LIBRARY_PACKAGE_NAME + ".Default_App_Preference";
        private int mode = Context.MODE_PRIVATE;

        public Builder setFileName(String preferenceFileKey) {
            this.fileName = preferenceFileKey;
            return this;
        }

        public Builder setMode(int mode) {
            this.mode = mode;
            return this;
        }
        public GuruConfig build() {
            return new GuruConfig(this);
        }
    }
}
