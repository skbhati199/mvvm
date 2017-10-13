package com.infoskillstechnology.homeworkout.ui.home;

import android.arch.lifecycle.ViewModelProvider;

import com.infoskillstechnology.homeworkout.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Skbhati on 13-10-2017.
 * Info Skills Technology Pvt. Ltd.
 * skbhati199@gmail.com
 */

@Module
public class HomeWorkOutActivityModule {

    @Provides
    HomeWorkoutViewModel provideHomeViewModel(){
        return new HomeWorkoutViewModel();
    }

    @Provides
    ViewModelProvider.Factory mainViewModelProvider(HomeWorkoutViewModel main){
        return new ViewModelProviderFactory<>(main);
    }

}
