package com.abbusteps.app.viewmodel;

/**
 * ViewModel for step counting data.
 * Provides step count, history, and statistics.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010$\u001a\u00020\nJ\b\u0010%\u001a\u00020&H\u0002J\b\u0010\'\u001a\u00020&H\u0002J\u0006\u0010(\u001a\u00020&J\b\u0010)\u001a\u00020&H\u0002J\u0006\u0010*\u001a\u00020&J\u0006\u0010+\u001a\u00020&J\u000e\u0010,\u001a\u00020&H\u0086@\u00a2\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u00100J\u000e\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\nR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014\u00a8\u00063"}, d2 = {"Lcom/abbusteps/app/viewmodel/StepViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_allStepRecords", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/abbusteps/app/data/model/StepRecord;", "_dailyGoal", "", "_goalAchieved", "Landroidx/lifecycle/MutableLiveData;", "", "_monthlySteps", "_todayStepRecord", "_weeklySteps", "allStepRecords", "Lkotlinx/coroutines/flow/StateFlow;", "getAllStepRecords", "()Lkotlinx/coroutines/flow/StateFlow;", "dailyGoal", "getDailyGoal", "goalAchieved", "Landroidx/lifecycle/LiveData;", "getGoalAchieved", "()Landroidx/lifecycle/LiveData;", "monthlySteps", "getMonthlySteps", "repository", "Lcom/abbusteps/app/data/repository/StepRepository;", "todayStepRecord", "getTodayStepRecord", "weeklySteps", "getWeeklySteps", "getStepRecordsSince", "days", "loadAllStepRecords", "", "loadDailyGoal", "loadMonthlySteps", "loadTodayStepRecord", "loadWeeklySteps", "refresh", "resetTodaySteps", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTodaySteps", "steps", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDailyGoal", "goal", "app_debug"})
public final class StepViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.abbusteps.app.data.repository.StepRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.abbusteps.app.data.model.StepRecord> _todayStepRecord = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.abbusteps.app.data.model.StepRecord> todayStepRecord = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _dailyGoal = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> dailyGoal = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _weeklySteps = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> weeklySteps = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _monthlySteps = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> monthlySteps = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.abbusteps.app.data.model.StepRecord>> _allStepRecords = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.abbusteps.app.data.model.StepRecord>> allStepRecords = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _goalAchieved = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.Boolean> goalAchieved = null;
    
    public StepViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.abbusteps.app.data.model.StepRecord> getTodayStepRecord() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getDailyGoal() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getWeeklySteps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getMonthlySteps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.abbusteps.app.data.model.StepRecord>> getAllStepRecords() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getGoalAchieved() {
        return null;
    }
    
    /**
     * Load today's step record.
     */
    private final void loadTodayStepRecord() {
    }
    
    /**
     * Load daily goal from preferences.
     */
    private final void loadDailyGoal() {
    }
    
    /**
     * Load weekly steps.
     */
    public final void loadWeeklySteps() {
    }
    
    /**
     * Load monthly steps.
     */
    public final void loadMonthlySteps() {
    }
    
    /**
     * Load all step records for history.
     */
    private final void loadAllStepRecords() {
    }
    
    /**
     * Get step records for the last N days.
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.abbusteps.app.data.model.StepRecord> getStepRecordsSince(int days) {
        return null;
    }
    
    /**
     * Update daily goal.
     */
    public final void updateDailyGoal(int goal) {
    }
    
    /**
     * Refresh all data.
     */
    public final void refresh() {
    }
    
    /**
     * Reset today's step count to 0.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object resetTodaySteps(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Set today's step count to a specific value.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setTodaySteps(int steps, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}