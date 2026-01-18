package com.abbusteps.app.data.repository;

/**
 * Repository for managing step data.
 * Handles all data operations related to step counting.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 +2\u00020\u0001:\u0001+B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bJ\u000e\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0011\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0013\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\bJ\u000e\u0010\u0016\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0017\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010\u000fJ\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\bJ\u000e\u0010\u001a\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\u001b2\u0006\u0010\'\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010%J\u0016\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010*\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/abbusteps/app/data/repository/StepRepository;", "", "stepRecordDao", "Lcom/abbusteps/app/data/dao/StepRecordDao;", "preferencesManager", "Lcom/abbusteps/app/data/preferences/PreferencesManager;", "(Lcom/abbusteps/app/data/dao/StepRecordDao;Lcom/abbusteps/app/data/preferences/PreferencesManager;)V", "getAllStepRecords", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/abbusteps/app/data/model/StepRecord;", "getDailyGoal", "", "getLastBootTimestamp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastStepCounterValue", "getMonthlySteps", "getStepRecordsSince", "days", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTodayStepRecord", "getWeeklySteps", "isPaused", "", "isRemindersEnabled", "resetTodaySteps", "", "saveLastBootTimestamp", "timestamp", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveLastStepCounterValue", "value", "setDailyGoal", "goal", "setPaused", "paused", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setRemindersEnabled", "enabled", "setTodaySteps", "steps", "updateTodaySteps", "Companion", "app_debug"})
public final class StepRepository {
    @org.jetbrains.annotations.NotNull
    private final com.abbusteps.app.data.dao.StepRecordDao stepRecordDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.abbusteps.app.data.preferences.PreferencesManager preferencesManager = null;
    private static final float AVERAGE_STEP_LENGTH_METERS = 0.75F;
    private static final float CALORIES_PER_STEP = 0.04F;
    @org.jetbrains.annotations.NotNull
    public static final com.abbusteps.app.data.repository.StepRepository.Companion Companion = null;
    
    public StepRepository(@org.jetbrains.annotations.NotNull
    com.abbusteps.app.data.dao.StepRecordDao stepRecordDao, @org.jetbrains.annotations.NotNull
    com.abbusteps.app.data.preferences.PreferencesManager preferencesManager) {
        super();
    }
    
    /**
     * Get today's step record.
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.abbusteps.app.data.model.StepRecord> getTodayStepRecord() {
        return null;
    }
    
    /**
     * Get all step records.
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.abbusteps.app.data.model.StepRecord>> getAllStepRecords() {
        return null;
    }
    
    /**
     * Get step records for the last N days.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getStepRecordsSince(int days, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.abbusteps.app.data.model.StepRecord>> $completion) {
        return null;
    }
    
    /**
     * Get weekly steps (last 7 days).
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getWeeklySteps(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    /**
     * Get monthly steps (current month).
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMonthlySteps(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    /**
     * Update steps for today.
     * This is called by the sensor service when new steps are detected.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateTodaySteps(int steps, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Get daily goal from preferences.
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getDailyGoal() {
        return null;
    }
    
    /**
     * Set daily goal.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setDailyGoal(int goal, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Get reminders enabled status.
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> isRemindersEnabled() {
        return null;
    }
    
    /**
     * Set reminders enabled.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setRemindersEnabled(boolean enabled, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Save last step counter value (for handling device reboot).
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveLastStepCounterValue(int value, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Get last step counter value.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLastStepCounterValue(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    /**
     * Save last boot timestamp.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveLastBootTimestamp(long timestamp, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Get last boot timestamp.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLastBootTimestamp(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    /**
     * Check if step counting is paused.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object isPaused(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Set pause state for step counting.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setPaused(boolean paused, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/abbusteps/app/data/repository/StepRepository$Companion;", "", "()V", "AVERAGE_STEP_LENGTH_METERS", "", "CALORIES_PER_STEP", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}