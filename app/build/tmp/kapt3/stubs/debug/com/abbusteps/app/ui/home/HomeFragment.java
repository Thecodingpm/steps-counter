package com.abbusteps.app.ui.home;

/**
 * Home fragment with goal progress display and clickable day circles.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0002J$\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020!H\u0016J\b\u0010*\u001a\u00020!H\u0016J\b\u0010+\u001a\u00020!H\u0016J\u001a\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\f2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010.\u001a\u00020!H\u0002J\b\u0010/\u001a\u00020!H\u0002J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\u001fH\u0002J\b\u00102\u001a\u00020!H\u0002J\b\u00103\u001a\u00020!H\u0002J\b\u00104\u001a\u00020!H\u0002J\b\u00105\u001a\u00020!H\u0002J\u0010\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020\u001fH\u0002J\u0010\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020:H\u0002J\u0010\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020\u001fH\u0002J\u0010\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020\u0011H\u0002J\u0010\u0010A\u001a\u00020!2\u0006\u00107\u001a\u00020\u001fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006B"}, d2 = {"Lcom/abbusteps/app/ui/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/abbusteps/app/databinding/FragmentHomeBinding;", "binding", "getBinding", "()Lcom/abbusteps/app/databinding/FragmentHomeBinding;", "dateFormat", "Ljava/text/SimpleDateFormat;", "dayCircles", "", "Landroid/view/View;", "dayContainers", "decimalFormat", "Ljava/text/DecimalFormat;", "serviceBound", "", "serviceConnection", "Landroid/content/ServiceConnection;", "stepService", "Lcom/abbusteps/app/service/StepCounterService;", "viewModel", "Lcom/abbusteps/app/viewmodel/StepViewModel;", "getViewModel", "()Lcom/abbusteps/app/viewmodel/StepViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "formatNumber", "", "number", "", "observeViewModel", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onStart", "onStop", "onViewCreated", "view", "setupClickListeners", "setupDayContainers", "showDayData", "dayIndex", "showEditStepsDialog", "showFaqDialog", "showMenuBottomSheet", "showResetConfirmDialog", "updateActiveTime", "steps", "updateCalories", "calories", "", "updateDistance", "distanceKm", "updateGoalProgress", "goal", "updatePauseState", "isPaused", "updateStepDisplay", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.abbusteps.app.databinding.FragmentHomeBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final java.text.DecimalFormat decimalFormat = null;
    @org.jetbrains.annotations.NotNull
    private final java.text.SimpleDateFormat dateFormat = null;
    @org.jetbrains.annotations.Nullable
    private com.abbusteps.app.service.StepCounterService stepService;
    private boolean serviceBound = false;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<android.view.View> dayContainers = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<android.view.View> dayCircles = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.ServiceConnection serviceConnection = null;
    
    public HomeFragment() {
        super();
    }
    
    private final com.abbusteps.app.databinding.FragmentHomeBinding getBinding() {
        return null;
    }
    
    private final com.abbusteps.app.viewmodel.StepViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupDayContainers() {
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    @java.lang.Override
    public void onStop() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void showDayData(int dayIndex) {
    }
    
    private final void showMenuBottomSheet() {
    }
    
    private final void showResetConfirmDialog() {
    }
    
    private final void showEditStepsDialog() {
    }
    
    private final void showFaqDialog() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void updateStepDisplay(int steps) {
    }
    
    private final void updateGoalProgress(int goal) {
    }
    
    private final void updatePauseState(boolean isPaused) {
    }
    
    private final void updateDistance(float distanceKm) {
    }
    
    private final void updateCalories(float calories) {
    }
    
    private final void updateActiveTime(int steps) {
    }
    
    private final java.lang.String formatNumber(int number) {
        return null;
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}