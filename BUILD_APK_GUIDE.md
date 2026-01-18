# Build APK - Step by Step Guide

## 🎯 Goal: Build APK and Install on Your Phone

## Step 1: Fix Gradle Error First

### Quick Fix (Do This First):

1. **In Android Studio, click the blue link in the error:**
   - **"Re-download dependencies and sync project (requires network)"**
   - Wait 3-5 minutes for downloads

2. **If that doesn't work, try this:**
   - Click **"Stop Gradle build processes (requires restart)"**
   - Close Android Studio completely
   - Reopen Android Studio
   - Wait for project to load
   - Click **File → Sync Project with Gradle Files**

3. **If still failing, clean build:**
   - **Build → Clean Project**
   - Wait for completion
   - **Build → Rebuild Project**
   - Wait for completion

---

## Step 2: Build the APK

### Once Gradle Sync is Successful:

1. **Build APK:**
   - Go to: **Build** → **Build Bundle(s) / APK(s)** → **Build APK(s)**
   - Wait for build to complete (2-5 minutes)
   - You'll see: **"BUILD SUCCESSFUL"** in Build Output

2. **Find the APK:**
   - When build completes, click **"locate"** in the notification
   - OR navigate to: `app/build/outputs/apk/debug/app-debug.apk`
   - This is your APK file!

3. **Install on Phone:**
   - Copy `app-debug.apk` to your phone (via USB, email, or cloud)
   - On phone: Settings → Security → Enable "Unknown Sources"
   - Tap the APK file to install
   - Open "Abbu Steps" app!

---

## Alternative: Build APK from Terminal (If Android Studio Fails)

If Android Studio keeps failing, try terminal:

1. **Open Terminal** (on your Mac)

2. **Navigate to project:**
   ```bash
   cd "/Users/ahmadmuaaz/Documents/steps couner"
   ```

3. **Make gradlew executable:**
   ```bash
   chmod +x gradlew
   ```

4. **Build APK:**
   ```bash
   ./gradlew assembleDebug
   ```

5. **Find APK:**
   - Location: `app/build/outputs/apk/debug/app-debug.apk`

---

## Still Having Issues?

If Gradle still fails, try this comprehensive fix:

1. **Delete Gradle cache:**
   ```bash
   cd ~/.gradle
   rm -rf caches/
   ```

2. **Delete project build folders:**
   ```bash
   cd "/Users/ahmadmuaaz/Documents/steps couner"
   rm -rf .gradle
   rm -rf app/build
   rm -rf build
   ```

3. **Reopen Android Studio:**
   - Open the project
   - Wait for Gradle sync
   - Try building again

---

## Quick Checklist

- [ ] Fixed Gradle error (sync successful)
- [ ] Build → Build APK(s)
- [ ] Found APK at `app/build/outputs/apk/debug/app-debug.apk`
- [ ] Copied APK to phone
- [ ] Enabled Unknown Sources on phone
- [ ] Installed and tested app!

---

## Need Help?

If you're still stuck, share the exact error message and I'll help fix it!

