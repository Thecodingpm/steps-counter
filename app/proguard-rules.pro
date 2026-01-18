# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Room
-keep class * extends androidx.room.RoomDatabase
-dontwarn androidx.room.paging.**

# Keep custom model classes
-keep class com.abbusteps.app.data.model.** { *; }

