# 🔍 Debug App Crash

## How to See Crash Logs

### Method 1: Android Studio Logcat (If Testing via USB)

1. **Connect phone via USB**
2. **Open Android Studio**
3. **Open Logcat tab** (bottom panel)
4. **Filter by "AbbuSteps" or "AndroidRuntime"**
5. **Run the app**
6. **Copy the red error logs** (they'll show exactly why it crashed)

### Method 2: On Phone (Get Crash Report)

1. **Open the app** (it will crash)
2. **Go to:** Settings → Apps → Abbu Steps → App Info
3. **Look for crash logs** or "Report" button

### Method 3: Check Logcat in Android Studio

1. **View → Tool Windows → Logcat**
2. **Filter:** Search for "FATAL EXCEPTION" or "AndroidRuntime"
3. **Look for stack trace** starting with `com.abbusteps.app`

---

## Common Crash Causes & Fixes

### Issue 1: Missing Fragment Import
**Symptom:** `ClassNotFoundException` or `NoClassDefFoundError`
**Fix:** Already checked - imports look correct

### Issue 2: ViewBinding Not Generated
**Symptom:** `ClassNotFoundException: FragmentHomeBinding`
**Fix:** Rebuild project

### Issue 3: Database Initialization
**Symptom:** `IllegalStateException` on database
**Fix:** Check Application class initialization

### Issue 4: Missing Resources
**Symptom:** `Resources$NotFoundException`
**Fix:** Check all string/color resources exist

---

## Quick Fixes to Try

### Fix 1: Clean and Rebuild
1. **Build → Clean Project**
2. **Build → Rebuild Project**
3. **Build APK again**
4. **Reinstall on phone**

### Fix 2: Check Phone Logs
- Open **Developer Options** on phone
- Enable **"USB Debugging"**
- Connect to computer
- Check **Logcat** in Android Studio

---

## What I Need to Help Fix

**Please share:**
1. **Crash logs** from Logcat (if possible)
2. **Android version** on your phone
3. **When does it crash?** (immediately on open? After permission? etc.)

This will help me fix it quickly! 🔧

