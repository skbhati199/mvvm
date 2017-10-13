package com.infoskillstechnology.homeworkout.di.component;

import android.app.Application;

import com.infoskillstechnology.homeworkout.HomeWorkoutApp;
import com.infoskillstechnology.homeworkout.di.builder.ActivityBuilder;
import com.infoskillstechnology.homeworkout.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Skbhati on 13-10-2017.
 * Info Skills Technology Pvt. Ltd.
 * skbhati199@gmail.com
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Buidler {

        @BindsInstance
        Buidler application(Application application);

        AppComponent build();
    }

    void inject(HomeWorkoutApp app);
}
