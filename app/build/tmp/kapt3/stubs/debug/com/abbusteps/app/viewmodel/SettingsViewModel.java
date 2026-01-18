package com.abbusteps.app.viewmodel;

/**
 * ViewModel for settings.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/abbusteps/app/viewmodel/SettingsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_dailyGoal", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_remindersEnabled", "", "dailyGoal", "Lkotlinx/coroutines/flow/StateFlow;", "getDailyGoal", "()Lkotlinx/coroutines/flow/StateFlow;", "remindersEnabled", "getRemindersEnabled", "repository", "Lcom/abbusteps/app/data/repository/StepRepository;", "loadSettings", "", "updateDailyGoal", "goal", "updateRemindersEnabled", "enabled", "app_debug"})
public final class SettingsViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.abbusteps.app.data.repository.StepRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _dailyGoal = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> dailyGoal = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _remindersEnabled = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> remindersEnabled = null;
    
    public SettingsViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getDailyGoal() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getRemindersEnabled() {
        return null;
    }
    
    /**
     * Load settings from repository.
     */
    private final void loadSettings() {
    }
    
    /**
     * Update daily goal.
     */
    public final void updateDailyGoal(int goal) {
    }
    
    /**
     * Update reminders enabled.
     */
    public final void updateRemindersEnabled(boolean enabled) {
    }
}