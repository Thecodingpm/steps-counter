package com.abbusteps.app.data.dao;

/**
 * Data Access Object for StepRecord operations.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\'J \u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u0018\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\u0010\u001a\u00020\fH\'J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u0018J6\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u00a7@\u00a2\u0006\u0002\u0010 \u00a8\u0006!"}, d2 = {"Lcom/abbusteps/app/data/dao/StepRecordDao;", "", "deleteAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllStepRecords", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/abbusteps/app/data/model/StepRecord;", "getMonthlySteps", "", "startDate", "", "endDate", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStepRecord", "date", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStepRecordsBetween", "getStepRecordsSince", "getTodayStepRecord", "getWeeklySteps", "insertStepRecord", "stepRecord", "(Lcom/abbusteps/app/data/model/StepRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSteps", "steps", "distance", "", "calories", "lastUpdated", "", "(Ljava/lang/String;IFFJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface StepRecordDao {
    
    /**
     * Get step record for a specific date.
     */
    @androidx.room.Query(value = "SELECT * FROM step_records WHERE date = :date")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getStepRecord(@org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.abbusteps.app.data.model.StepRecord> $completion);
    
    /**
     * Get today's step record.
     */
    @androidx.room.Query(value = "SELECT * FROM step_records WHERE date = :date")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.abbusteps.app.data.model.StepRecord> getTodayStepRecord(@org.jetbrains.annotations.NotNull
    java.lang.String date);
    
    /**
     * Get all step records ordered by date (descending).
     */
    @androidx.room.Query(value = "SELECT * FROM step_records ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.abbusteps.app.data.model.StepRecord>> getAllStepRecords();
    
    /**
     * Get step records for a date range.
     */
    @androidx.room.Query(value = "SELECT * FROM step_records WHERE date BETWEEN :startDate AND :endDate ORDER BY date ASC")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getStepRecordsBetween(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.abbusteps.app.data.model.StepRecord>> $completion);
    
    /**
     * Get step records for the last N days.
     */
    @androidx.room.Query(value = "SELECT * FROM step_records WHERE date >= :startDate ORDER BY date ASC")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getStepRecordsSince(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.abbusteps.app.data.model.StepRecord>> $completion);
    
    /**
     * Get weekly total steps (last 7 days).
     */
    @androidx.room.Query(value = "SELECT SUM(steps) FROM step_records WHERE date >= :startDate")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getWeeklySteps(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    /**
     * Get monthly total steps.
     */
    @androidx.room.Query(value = "SELECT SUM(steps) FROM step_records WHERE date >= :startDate AND date <= :endDate")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMonthlySteps(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    /**
     * Insert or update a step record.
     */
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertStepRecord(@org.jetbrains.annotations.NotNull
    com.abbusteps.app.data.model.StepRecord stepRecord, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Update steps for a specific date.
     */
    @androidx.room.Query(value = "UPDATE step_records SET steps = :steps, distance = :distance, calories = :calories, lastUpdated = :lastUpdated WHERE date = :date")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateSteps(@org.jetbrains.annotations.NotNull
    java.lang.String date, int steps, float distance, float calories, long lastUpdated, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Delete all step records.
     */
    @androidx.room.Query(value = "DELETE FROM step_records")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}