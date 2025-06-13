
# Comzy Android Video Calling SDK

Welcome to the official Comzy SDK for Android – enabling real-time video communication in your app with minimal setup.

---

## 🚀 Features

- 🔁 Easy-to-integrate API
- 🎥 Local & remote video streaming
- 🎙️ Toggle audio mute/unmute
- 📷 Toggle camera on/off
- 📞 Start & end video calls
- ⚡ Lightweight and efficient

---

## 📦 Installation

### 1. Add Maven Repository

Add the following in your **`settings.gradle.kts`** file:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://sdk.comzy.io")
        }
    }
}
````

### 2. Add SDK Dependency

Include the library in your **`build.gradle.kts`** (app module):

```kotlin
dependencies {
    implementation("io.comzy:ComzyLib:1.2.0")
}
```

---

## 🛠️ Getting Started
# Android Permissions for Camera, Microphone, and Internet

To enable camera, microphone, and internet access in your Android application, you need to declare the required permissions in your `AndroidManifest.xml` file.

## 📋 Required Permissions

```xml
<uses-feature android:name="android.hardware.camera" android:required="false" />
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.RECORD_AUDIO" />
<uses-permission android:name="android.permission.INTERNET" />
```

### 1. Initialize Comzy Instance


```kotlin
val comzy = Comzy.getInstance(context)
```

> `context` should be the current `Activity` or `Application` context.

---

### 2. Start a Video Call

```kotlin
Comzy.start(
    context = this,
    activity = this,
    APT_KEY = "YOUR_API_KEY",
    userId = "yourUserId",
    remoteId = "remoteUserId"
)
```

---

### 3. Add Video Views to Your Layout

#### Local Video View

```kotlin
val localView = comzy.getLocalVideoView(this)
yourLocalViewContainer.addView(localView)
```

#### Remote Video View

```kotlin
val remoteView = comzy.getRemoteVideoView()
yourRemoteViewContainer.addView(remoteView)
```

---

### 4. Mute or Unmute Microphone

```kotlin
val isMuted = comzy.toggleMute()
```

Returns `true` if the microphone is muted.

---

### 5. Toggle Camera

```kotlin
val isCameraEnabled = comzy.toggleCamera()
```

Returns `true` if the camera is enabled.

---

### 6. End the Call

```kotlin
comzy.endCall()
```

---

## 📘 Full Example

```kotlin
val comzy = Comzy.getInstance(this)

Comzy.start(this, this, "YOUR_API_KEY", "user123", "user456")

val localView = comzy.getLocalVideoView(this)
localContainer.addView(localView)

val remoteView = comzy.getRemoteVideoView()
remoteContainer.addView(remoteView)

// Optional controls
muteButton.setOnClickListener {
    comzy.toggleMute()
}

cameraButton.setOnClickListener {
    comzy.toggleCamera()
}

endCallButton.setOnClickListener {
    comzy.endCall()
}
```

---


> **Note:** If you wish to use our API, please email us at [hello@comzy.io](mailto:hello@comzy.io) with the following details:
>
> * Your full name
> * Your app's name
> * The purpose of your app
>
> API access will be reviewed and granted based on your submission.(The purpose of the API key is solely to track user, it is not being sold its totally free)


---

## 📞 Support

Need help? Contact our support team at [hello@comzy.io](mailto:hello@comzy.io) 

---


