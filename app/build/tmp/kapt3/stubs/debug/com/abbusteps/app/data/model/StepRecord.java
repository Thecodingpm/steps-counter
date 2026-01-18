package com.abbusteps.app.data.model;

/**
 * Entity representing a daily step record.
 * Stores step count for each calendar day.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\nH\u00c6\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/abbusteps/app/data/model/StepRecord;", "", "date", "", "steps", "", "distance", "", "calories", "lastUpdated", "", "(Ljava/lang/String;IFFJ)V", "getCalories", "()F", "getDate", "()Ljava/lang/String;", "getDistance", "getLastUpdated", "()J", "getSteps", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_debug"})
@androidx.room.Entity(tableName = "step_records")
public final class StepRecord {
    @androidx.room.PrimaryKey
    @org.jetbrains.annotations.NotNull
    private final java.lang.String date = null;
    private final int steps = 0;
    private final float distance = 0.0F;
    private final float calories = 0.0F;
    private final long lastUpdated = 0L;
    @org.jetbrains.annotations.NotNull
    public static final com.abbusteps.app.data.model.StepRecord.Companion Companion = null;
    
    public StepRecord(@org.jetbrains.annotations.NotNull
    java.lang.String date, int steps, float distance, float calories, long lastUpdated) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDate() {
        return null;
    }
    
    public final int getSteps() {
        return 0;
    }
    
    public final float getDistance() {
        return 0.0F;
    }
    
    public final float getCalories() {
        return 0.0F;
    }
    
    public final long getLastUpdated() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final float component3() {
        return 0.0F;
    }
    
    public final float component4() {
        return 0.0F;
    }
    
    public final long component5() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.abbusteps.app.data.model.StepRecord copy(@org.jetbrains.annotations.NotNull
    java.lang.String date, int steps, float distance, float calories, long lastUpdated) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004\u00a8\u0006\b"}, d2 = {"Lcom/abbusteps/app/data/model/StepRecord$Companion;", "", "()V", "getDateString", "", "dayOffset", "", "getTodayDateString", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Get today's date string in format "yyyy-MM-dd"
         */
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getTodayDateString() {
            return null;
        }
        
        /**
         * Get date string for given day offset (0 = today, -1 = yesterday, etc.)
         */
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getDateString(int dayOffset) {
            return null;
        }
    }
}