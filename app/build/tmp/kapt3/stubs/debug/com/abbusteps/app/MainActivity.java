package com.abbusteps.app;

/**
 * Main activity of the app.
 * Handles permissions, starts step counter service, and manages navigation.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/abbusteps/app/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "activityRecognitionPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "binding", "Lcom/abbusteps/app/databinding/ActivityMainBinding;", "notificationPermissionLauncher", "checkAndRequestPermissions", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setupToolbar", "setupViewPager", "showPermissionDeniedDialog", "startStepCounterService", "MainPagerAdapter", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.abbusteps.app.databinding.ActivityMainBinding binding;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> activityRecognitionPermissionLauncher = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> notificationPermissionLauncher = null;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Setup toolbar.
     */
    private final void setupToolbar() {
    }
    
    /**
     * Setup ViewPager with fragments.
     */
    private final void setupViewPager() {
    }
    
    /**
     * Check and request necessary permissions.
     */
    private final void checkAndRequestPermissions() {
    }
    
    /**
     * Start the step counter service.
     */
    private final void startStepCounterService() {
    }
    
    /**
     * Show dialog when permission is denied.
     */
    private final void showPermissionDeniedDialog() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    /**
     * ViewPager adapter for main fragments.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/abbusteps/app/MainActivity$MainPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "app_debug"})
    static final class MainPagerAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {
        
        public MainPagerAdapter(@org.jetbrains.annotations.NotNull
        androidx.appcompat.app.AppCompatActivity activity) {
            super(null);
        }
        
        @java.lang.Override
        public int getItemCount() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public androidx.fragment.app.Fragment createFragment(int position) {
            return null;
        }
    }
}