package com.abbusteps.app;

/**
 * Application class for Abbu Steps app.
 * Provides singleton instances of database and repository.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/abbusteps/app/AbbuStepsApplication;", "Landroid/app/Application;", "()V", "database", "Lcom/abbusteps/app/data/database/AppDatabase;", "getDatabase", "()Lcom/abbusteps/app/data/database/AppDatabase;", "database$delegate", "Lkotlin/Lazy;", "preferencesManager", "Lcom/abbusteps/app/data/preferences/PreferencesManager;", "getPreferencesManager", "()Lcom/abbusteps/app/data/preferences/PreferencesManager;", "preferencesManager$delegate", "repository", "Lcom/abbusteps/app/data/repository/StepRepository;", "getRepository", "()Lcom/abbusteps/app/data/repository/StepRepository;", "repository$delegate", "onCreate", "", "Companion", "app_debug"})
public final class AbbuStepsApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy database$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy preferencesManager$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy repository$delegate = null;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.abbusteps.app.AbbuStepsApplication INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.abbusteps.app.AbbuStepsApplication.Companion Companion = null;
    
    public AbbuStepsApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.abbusteps.app.data.database.AppDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.abbusteps.app.data.preferences.PreferencesManager getPreferencesManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.abbusteps.app.data.repository.StepRepository getRepository() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/abbusteps/app/AbbuStepsApplication$Companion;", "", "()V", "INSTANCE", "Lcom/abbusteps/app/AbbuStepsApplication;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.abbusteps.app.AbbuStepsApplication getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}