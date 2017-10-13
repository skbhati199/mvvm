package com.infoskillstechnology.homeworkout;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

/**
 * Created by Skbhati on 13-10-2017.
 * Info Skills Technology Pvt. Ltd.
 * skbhati199@gmail.com
 */

public class ViewModelProviderFactory<V> implements ViewModelProvider.Factory {

    private final V viewModel;

    public ViewModelProviderFactory(V viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if(modelClass.isAssignableFrom(viewModel.getClass())){
            return (T) viewModel;
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
