# Guru
[![](https://jitpack.io/v/squti/Guru.svg)](https://jitpack.io/#squti/Guru)

Guru is a handy and powerful library to work with key-value storages in Android <br/><br/><br/>
<p align="center">
  <img width="400" height="100" src="https://raw.githubusercontent.com/squti/Guru/master/static/guru_logo.png">
</p>
<br/><br/>

This library is an efficient and super easy way to use Android Shared Preferences without complexity and supports all of it functionalities.

### Download
Step 1. If you are not using AndroidX go to **Android Studio > Refactor > Migrate to AndroidX**

Step 2. Add this in your root (Project) build.gradle at the end of repositories:
```gradle
allprojects {
        repositories {
            ...
            maven { url "https://jitpack.io" }
        }
    }
```
Step 3. Add the dependency
```gradle
dependencies{
    implementation'com.github.squti:Guru:1.0.1'
}
```

### Usage
There is no need to initialize or config Guru. Just call it methods directly anywhere.

```java
// To save String
Guru.putString("KEY", "value");

```

```java
// To get String
// default value returns if the key doesn't exist
Guru.getString("KEY", "default value");

```
That's it !

This example only shows how to put and get a string. You can use other methods to work with other data types.
### Configuration
Default Preferences file name is `com.github.squti.guru.Default_App_Preference` <br/>

And the default Preferences mode is `MODE_PRIVATE`

But you can change them using `GuruConfig`, in your Application class in the `#onCreate()` method.
```java
    @Override
    public void onCreate() {
        super.onCreate();
        GuruConfig.initDefault(new GuruConfig.Builder()
                .setFileName("app_preference")
                .setMode(Context.MODE_PRIVATE)
                .build());       
        //....
    }
```
_Note: You don't need to define `GuruConfig` and the library will apply
default configuration._


### License
```
MIT License

Copyright (c) 2019 squti

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
