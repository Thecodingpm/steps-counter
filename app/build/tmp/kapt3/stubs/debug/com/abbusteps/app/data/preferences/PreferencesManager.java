package com.abbusteps.app.data.preferences;

/**
 * Manages app preferences using DataStore.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0011\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006!"}, d2 = {"Lcom/abbusteps/app/data/preferences/PreferencesManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dailyGoal", "Lkotlinx/coroutines/flow/Flow;", "", "getDailyGoal", "()Lkotlinx/coroutines/flow/Flow;", "remindersEnabled", "", "getRemindersEnabled", "getLastBootTimestamp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastStepCounterValue", "isPaused", "setDailyGoal", "", "goal", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setLastBootTimestamp", "timestamp", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setLastStepCounterValue", "value", "setPaused", "paused", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setRemindersEnabled", "enabled", "Companion", "app_debug"})
public final class PreferencesManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.properties.ReadOnlyProperty<?, ?> dataStore$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Integer> DAILY_GOAL_KEY = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> REMINDERS_ENABLED_KEY = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Integer> LAST_STEP_COUNTER_VALUE_KEY = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Long> LAST_BOOT_TIMESTAMP_KEY = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> PAUSED_KEY = null;
    private static final int DEFAULT_DAILY_GOAL = 10000;
    
    /**
     * Get daily step goal.
     */
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.Integer> dailyGoal = null;
    
    /**
     * Get reminders enabled status.
     */
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.Boolean> remindersEnabled = null;
    @org.jetbrains.annotations.NotNull
    public static final com.abbusteps.app.data.preferences.PreferencesManager.Companion Companion = null;
    
    public PreferencesManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    /**
     * Get daily step goal.
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getDailyGoal() {
        return null;
    }
    
    /**
     * Set daily step goal.
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
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getRemindersEnabled() {
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
     * Get last step counter value (for handling device reboot).
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLastStepCounterValue(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    /**
     * Set last step counter value.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setLastStepCounterValue(int value, @org.jetbrains.annotations.NotNull
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
     * Set last boot timestamp.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setLastBootTimestamp(long timestamp, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Get paused state.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object isPaused(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Set paused state.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setPaused(boolean paused, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/abbusteps/app/data/preferences/PreferencesManager$Companion;", "", "()V", "DAILY_GOAL_KEY", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "DEFAULT_DAILY_GOAL", "LAST_BOOT_TIMESTAMP_KEY", "", "LAST_STEP_COUNTER_VALUE_KEY", "PAUSED_KEY", "", "REMINDERS_ENABLED_KEY", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Landroid/content/Context;", "getDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "dataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        private final androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> getDataStore(android.content.Context $this$dataStore) {
            return null;
        }
    }
}