# Guru

Guru is a handy and powerful library to work with key-value storages in Android
<p align="center">
  <img width="500" height="170" src="https://raw.githubusercontent.com/squti/Guru/master/static/guru_logo.png">
</p>


This library is an efficient and super easy way to use Android Shared Preferences without complexity and supports all of it functionalities.


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
