android-demo-app [![Build Status](https://travis-ci.org/breskeby/android-demo-app.svg?branch=master)](https://travis-ci.org/breskeby/android-demo-app)
================

Android Application used for demoing Android Gradle Build and Android Studio

This application is based on https://github.com/kousen/ICNDB. but will continue do diverge from that base

to demo all kinds of feature of the new gradle based android build system. 

### PREPARATION

* clean wrapper directories
* clean local repositories
* import demo project in Android Studio
* start emulator

### DEMO

#### Command Line 
1. **./gradlew projects**

    
	:projects
    
	
    
	------------------------------------------------------------
    
	Root project
    
	------------------------------------------------------------
    
	
    
	Root project 'android-demo-app'
    
	\--- Project ':app'

2. **./gradlew :app:tasks**
	* Build tasks
	* Install tasks
	* Verification tasks
	* explain _up-to-date_
	* __TODO__ androidDependencies?
	
3. **./gradlew assemble**
	* runs multiple tasks
	* compiling, dexing, etc.
	* show different apks in _app/build/outputs/apk/_

4. **./gradlew build**
	* same as assemble
	* runs tests
	* runs lint checks
	
#### Android Studio

