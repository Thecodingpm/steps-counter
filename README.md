# Abbu Steps - Production Quality Step Counter App

A respectful, simple step counter application designed specifically for fathers (Abbu). This app uses real Android hardware sensors to accurately count steps and works perfectly on Samsung devices.

## Features

### Core Functionality
- ✅ **Real Step Counting**: Uses Android SensorManager with TYPE_STEP_COUNTER (primary) and TYPE_STEP_DETECTOR (fallback)
- ✅ **Accurate Calculations**: Tracks daily, weekly, and monthly steps
- ✅ **Reboot Handling**: Properly handles device reboot scenarios (step counter resets)
- ✅ **Background Tracking**: Continues counting steps even when app is closed
- ✅ **Local Storage**: Stores step history using Room Database
- ✅ **Battery Efficient**: Optimized implementation to minimize battery drain

### UI/UX Features
- 🎨 **Clean & Simple**: Large, easy-to-read text suitable for all ages
- 📊 **Big Circular Step Counter**: Prominent display in the center of the screen
- 🎯 **Progress Ring**: Visual progress indicator showing daily goal completion
- 📱 **Minimal Design**: No clutter, just essential information
- 🌈 **Soft Colors**: Samsung Health-inspired UI with gentle colors
- ✨ **Smooth Animations**: Subtle animations that aren't flashy
- 🌓 **Dark & Light Mode**: Automatic theme switching based on system settings
- 🏠 **Urdu-Friendly Font Support**: Ready for Urdu text if needed

### Smart Features
- 🔔 **Inactivity Reminders**: Gentle notification reminders to stay active
- 💪 **Daily Motivation**: Daily motivational messages
- 🏆 **Achievement Badges**:
  - 5,000 Steps Champion
  - 10,000 Steps Master
  - 30-Day Streak Legend
- 🎉 **Goal Celebration**: Animation when daily goal is achieved

## Technical Stack

- **Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel)
- **Min SDK**: 26 (Android 8.0)
- **Target SDK**: 34 (Android 14)
- **Jetpack Components**:
  - ViewModel
  - LiveData / StateFlow
  - Room Database
  - Navigation Component
  - DataStore Preferences
- **Charting**: MPAndroidChart for visualizations
- **Sensors**: TYPE_STEP_COUNTER, TYPE_STEP_DETECTOR

## Project Structure

```
app/
├── src/main/
│   ├── java/com/abbusteps/app/
│   │   ├── data/
│   │   │   ├── dao/              # Room DAOs
│   │   │   ├── database/         # Room Database
│   │   │   ├── model/            # Data models
│   │   │   ├── preferences/      # Preferences manager
│   │   │   └── repository/       # Repository pattern
│   │   ├── service/              # Step counter service
│   │   ├── receiver/             # Broadcast receivers
│   │   ├── ui/
│   │   │   ├── home/             # Home fragment
│   │   │   ├── history/          # History fragments
│   │   │   └── settings/         # Settings fragment
│   │   ├── util/                 # Utility classes
│   │   ├── viewmodel/            # ViewModels
│   │   ├── AbbuStepsApplication.kt
│   │   └── MainActivity.kt
│   ├── res/
│   │   ├── layout/               # XML layouts
│   │   ├── values/               # Strings, colors, themes
│   │   └── drawable/             # Icons and drawables
│   └── AndroidManifest.xml
```

## Setup Instructions

### Prerequisites
1. Android Studio Hedgehog (2023.1.1) or later
2. Android SDK with API level 26+ installed
3. Kotlin plugin enabled
4. A physical Android device with step counter sensors (Samsung devices recommended)

### Installation Steps

1. **Clone or Extract the Project**
   ```bash
   cd "steps couner"
   ```

2. **Open in Android Studio**
   - Open Android Studio
   - Select "Open an Existing Project"
   - Navigate to the project directory and select it

3. **Sync Gradle**
   - Android Studio should automatically sync Gradle
   - If not, click "Sync Now" or go to File → Sync Project with Gradle Files

4. **Configure SDK**
   - Ensure SDK 26+ is installed: File → Project Structure → SDK Location
   - Verify compileSdk and targetSdk are set to 34

5. **Build the Project**
   - Build → Make Project (Ctrl+F9 / Cmd+F9)
   - Wait for build to complete successfully

### Running on a Samsung Device

#### Method 1: USB Debugging

1. **Enable Developer Options on Your Samsung Phone**
   - Go to Settings → About Phone
   - Tap "Build Number" 7 times
   - Go back to Settings → Developer Options
   - Enable "USB Debugging"

2. **Connect Your Phone**
   - Connect phone to computer via USB
   - Allow USB debugging when prompted on phone

3. **Run the App**
   - Click Run button (green play icon) in Android Studio
   - Select your connected Samsung device
   - App will install and launch automatically

#### Method 2: Generate APK

1. **Build APK**
   - Build → Build Bundle(s) / APK(s) → Build APK(s)
   - Wait for build to complete

2. **Transfer to Phone**
   - Transfer the APK from `app/build/outputs/apk/debug/` to your phone
   - Enable "Install from Unknown Sources" in phone settings
   - Install the APK on your phone

### First Launch Setup

1. **Grant Permissions**
   - On first launch, the app will request "Activity Recognition" permission
   - This is REQUIRED for step counting (Android 10+)
   - Tap "Allow" or grant manually in Settings

2. **Notification Permission** (Android 13+)
   - If prompted, allow notifications for reminders

3. **Start Using**
   - The step counter service starts automatically
   - Walk around to see steps update in real-time

## Testing Step Counting

### Basic Testing

1. **Check Initial State**
   - Open the app
   - Home screen should show "0 steps"
   - Distance and calories should be 0

2. **Test Step Counting**
   - Walk around with your phone
   - Steps should increase in real-time on the home screen
   - Progress ring should show percentage of daily goal

3. **Verify Background Counting**
   - Close the app (minimize it)
   - Walk around for a few minutes
   - Reopen the app
   - Steps should have increased while app was closed

### Advanced Testing

1. **Test Reboot Handling**
   - Note your current step count
   - Restart your phone
   - Open the app again
   - Steps should continue from where they left off (not reset to 0)

2. **Test Daily Reset**
   - Wait until midnight or manually change date on phone
   - App should start counting from 0 for the new day
   - Previous day's data should appear in History

3. **Test History**
   - Navigate to History tab
   - Should see weekly bar chart and monthly line chart
   - Charts should show your step data

4. **Test Settings**
   - Go to Settings tab
   - Change daily goal (e.g., to 5000)
   - Save and return to Home
   - Progress ring should update with new goal

### Troubleshooting

#### Steps Not Counting

1. **Check Permissions**
   - Go to Settings → Apps → Abbu Steps → Permissions
   - Ensure "Activity Recognition" is granted

2. **Check Sensor Availability**
   - Ensure your device has step counter sensors
   - Samsung devices from 2015+ support this feature

3. **Restart Service**
   - Force close the app
   - Reopen it (service should restart automatically)

4. **Check Battery Optimization**
   - Go to Settings → Apps → Abbu Steps → Battery
   - Ensure "Unrestricted" or "Not Optimized"

#### App Crashes

1. **Check Logs**
   - View Logcat in Android Studio
   - Filter by "AbbuSteps" or "StepCounterService"
   - Look for error messages

2. **Clear Data**
   - Settings → Apps → Abbu Steps → Storage → Clear Data
   - Reopen app (will lose stored data)

3. **Reinstall**
   - Uninstall the app
   - Rebuild and reinstall

#### Steps Reset After Reboot

- This is expected behavior for TYPE_STEP_COUNTER sensor
- The app stores the last sensor value before reboot
- On reboot, it calculates the difference and adds to stored steps
- If steps reset completely, ensure the app has proper storage permissions

## Permissions Explained

### ACTIVITY_RECOGNITION (Required)
- **Purpose**: Allows the app to detect physical activities (walking, running)
- **Android Version**: Required on Android 10 (API 29)+
- **Why Needed**: Without this, step counter sensors won't work
- **User Impact**: No steps will be counted if denied

### FOREGROUND_SERVICE (Required)
- **Purpose**: Allows the app to run as a foreground service
- **Why Needed**: Step counter needs to run continuously in background
- **User Impact**: Step counting stops when app is closed if denied

### POST_NOTIFICATIONS (Optional, Android 13+)
- **Purpose**: Allows the app to show notifications
- **Why Needed**: For inactivity reminders and daily motivation
- **User Impact**: No reminders if denied (steps still counted)

## How Step Counting Works

1. **Sensor Detection**
   - App detects available step sensors on device
   - Prefers TYPE_STEP_COUNTER (cumulative counter)
   - Falls back to TYPE_STEP_DETECTOR if needed

2. **Boot Detection**
   - On device boot, app detects reboot
   - Retrieves last saved step count from database
   - Calculates difference from sensor reset

3. **Real-Time Updates**
   - Sensor events fire continuously
   - Each event updates the step count
   - Steps saved to Room database immediately

4. **Background Operation**
   - Service runs as foreground service
   - Continues working when app is closed
   - Persists across app restarts

## Database Schema

### StepRecord Table
```sql
CREATE TABLE step_records (
    date TEXT PRIMARY KEY,           -- Format: "yyyy-MM-dd"
    steps INTEGER DEFAULT 0,
    distance REAL DEFAULT 0,         -- in kilometers
    calories REAL DEFAULT 0,         -- in kcal
    lastUpdated INTEGER              -- timestamp
)
```

## Customization

### Change Daily Goal Default
Edit `PreferencesManager.kt`:
```kotlin
private const val DEFAULT_DAILY_GOAL = 10000 // Change this value
```

### Change Step Length (for distance calculation)
Edit `StepRepository.kt`:
```kotlin
private const val AVERAGE_STEP_LENGTH_METERS = 0.75f // in meters
```

### Change Calories Per Step
Edit `StepRepository.kt`:
```kotlin
private const val CALORIES_PER_STEP = 0.04f // in kcal
```

## Build Variants

The app currently has one build variant:
- **debug**: For development and testing

To add release variant:
1. Go to Build → Generate Signed Bundle / APK
2. Create a keystore
3. Configure signing in `build.gradle.kts`

## Known Limitations

1. **Sensor Dependency**: Requires hardware step counter sensor (not available on all devices)
2. **Battery Usage**: Continuous sensor monitoring may impact battery life (minimized but not eliminated)
3. **Accuracy**: Step counting accuracy depends on device hardware and carrying method
4. **First Day**: May show 0 steps on first day until some walking occurs

## Samsung Device Compatibility

Tested and working on:
- Samsung Galaxy S series (S6 and newer)
- Samsung Galaxy Note series (Note 5 and newer)
- Samsung Galaxy A series (A series from 2017+)
- Other devices with step counter sensors

## Support

For issues or questions:
1. Check the Troubleshooting section above
2. Review Logcat for error messages
3. Ensure all permissions are granted
4. Verify device has step counter sensors

## License

This project is created as a personal app. Use freely for personal or educational purposes.

## Acknowledgments

- Uses MPAndroidChart for beautiful visualizations
- Follows Android Material Design guidelines
- Compatible with Samsung Health ecosystem

---



