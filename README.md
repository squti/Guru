# Guru

Guru is a handy and powerful library to work with key-value storages in Android <br/><br/><br/>
<p align="center">
  <img width="400" height="100" src="https://raw.githubusercontent.com/squti/Guru/master/static/guru_logo.png">
</p>
<br/><br/>

This library is an efficient and super easy way to use Android Shared Preferences without complexity and supports all of it functionalities.

### Download
Step 1. Add it in your root (Project) build.gradle at the end of repositories:
```groovy
allprojects {
        repositories {
            ...
            maven { url "https://jitpack.io" }
        }
    }
```
Step 2. Add the dependency
```groovy
	dependencies {
	        implementation 'com.github.squti:Guru:1.0.1'
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

This example shows how to put and get a string. You can use other methods to work with other data types.
### Configuration
The default Preferences file name is `APPLICATION_ID.Default_App_Preference` <br/>
(example: com.github.squti.guru.Default_App_Preference)<br/>
And the default Preferences mode is `MODE_PRIVATE`

But you can change them using `GuruConfig`, in your Application class in the `#onCreate()` method.
```java
    @Override
    public void onCreate() {
        super.onCreate();
        GuruConfig.initDefault(new GuruConfig.Builder()
                .setFileName("guru_preference")
                .setMode(Context.MODE_PRIVATE)
                .build());       
        //....
    }
```
_Note: You don't need to define `GuruConfig` and the library will apply
default configuration._
