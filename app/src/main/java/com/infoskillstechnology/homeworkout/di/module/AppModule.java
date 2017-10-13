package com.infoskillstechnology.homeworkout.di.module;

import android.app.Application;
import android.content.Context;

import com.infoskillstechnology.homeworkout.R;
import com.infoskillstechnology.homeworkout.utils.rx.AppSchedulerProvider;
import com.infoskillstechnology.homeworkout.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Skbhati on 13-10-2017.
 * Info Skills Technology Pvt. Ltd.
 * skbhati199@gmail.com
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application){
        return application;
    }

    @Provides
    SchedulerProvider providerSchedulerProvider(){
        return new AppSchedulerProvider();
    }


    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
