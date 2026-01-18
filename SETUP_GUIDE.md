# Quick Setup Guide - Abbu Steps

## Quick Start (5 minutes)

### 1. Open Project
- Open Android Studio
- File → Open → Select "steps couner" folder
- Wait for Gradle sync to complete

### 2. Connect Samsung Phone
- Enable USB Debugging: Settings → About Phone → Tap "Build Number" 7 times
- Settings → Developer Options → Enable "USB Debugging"
- Connect phone via USB
- Allow USB debugging when prompted

### 3. Run App
- Click the green "Run" button in Android Studio
- Select your Samsung device
- Click OK
- App installs and launches automatically

### 4. Grant Permissions
- When prompted, tap "Allow" for Activity Recognition
- This is REQUIRED for step counting

### 5. Test
- Walk around with your phone
- Steps should increase in real-time on the home screen!

## Important Notes

✅ **Requires Physical Device**: Step counter sensors only work on real phones, not emulators

✅ **Samsung Devices**: Best compatibility with Samsung Galaxy devices (S6 and newer)

✅ **Background Service**: The app runs a foreground service - this is normal and required for step counting

✅ **Battery Optimization**: If steps don't count when app is closed, go to Settings → Apps → Abbu Steps → Battery → Unrestricted

## Troubleshooting

### Steps Not Counting?
1. Check permissions: Settings → Apps → Abbu Steps → Permissions → Activity Recognition must be ON
2. Restart the app
3. Ensure battery optimization is disabled for the app

### App Won't Install?
- Make sure USB debugging is enabled
- Try "Install via USB" option if available
- Check if Developer Options is enabled

### Build Errors?
- File → Invalidate Caches → Invalidate and Restart
- Build → Clean Project
- Build → Rebuild Project

## Files Structure Quick Reference

```
app/src/main/
├── java/com/abbusteps/app/
│   ├── MainActivity.kt          # Main entry point
│   ├── service/                 # Step counter service
│   ├── ui/                      # All UI fragments
│   ├── viewmodel/               # ViewModels
│   └── data/                    # Database and repository
├── res/
│   ├── layout/                  # XML layouts
│   └── values/                  # Strings, colors, themes
└── AndroidManifest.xml          # App configuration
```

## Key Features to Test

1. **Real-time Counting**: Walk and watch steps increase
2. **Background Counting**: Close app, walk, reopen - steps should update
3. **History**: Check History tab for weekly/monthly charts
4. **Settings**: Change daily goal in Settings tab
5. **Reboot**: Restart phone, open app - steps should continue from previous value

## Next Steps

- Customize daily goal in Settings
- Check History tab to see your weekly/monthly progress
- Walk to achieve your daily goal and see celebration!

---

For detailed documentation, see README.md

