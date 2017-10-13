package com.infoskillstechnology.homeworkout.di.builder;

import com.infoskillstechnology.homeworkout.di.module.AppModule;
import com.infoskillstechnology.homeworkout.ui.home.HomeWorkOutActivity;
import com.infoskillstechnology.homeworkout.ui.home.HomeWorkOutActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Skbhati on 13-10-2017.
 * Info Skills Technology Pvt. Ltd.
 * skbhati199@gmail.com
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {HomeWorkOutActivityModule.class, AppModule.class})
    abstract HomeWorkOutActivity bindHomeWorkOutActivity();


}
