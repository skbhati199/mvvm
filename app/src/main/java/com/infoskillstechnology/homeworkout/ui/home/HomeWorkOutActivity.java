package com.infoskillstechnology.homeworkout.ui.home;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.infoskillstechnology.homeworkout.BR;
import com.infoskillstechnology.homeworkout.R;
import com.infoskillstechnology.homeworkout.databinding.ActivityHomeWorkOutBinding;
import com.infoskillstechnology.homeworkout.databinding.NavHeaderHomeWorkOutBinding;
import com.infoskillstechnology.homeworkout.ui.base.BaseActivity;

import javax.inject.Inject;

public class HomeWorkOutActivity extends BaseActivity<ActivityHomeWorkOutBinding, HomeWorkoutViewModel> implements HomeWorkoutNavigator, NavigationView.OnNavigationItemSelectedListener {


    @Inject
    ViewModelProvider.Factory mViewModelFactory;


    private HomeWorkoutViewModel mHomeViewModel;

    ActivityHomeWorkOutBinding mActivityHomeBinding;


    private DrawerLayout mDrawer;

    private Toolbar mToolbar;

    private NavigationView mNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityHomeBinding = getViewDataBinding();
        mHomeViewModel.setNavigator(this);
        setUp();
    }

    private void setUp() {
        mDrawer = mActivityHomeBinding.drawerLayout;
        mToolbar = mActivityHomeBinding.toolbar;
        mNavigationView = mActivityHomeBinding.navView;
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawer.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
        setUpNavMenu();
    }

    private void setUpNavMenu() {
        NavHeaderHomeWorkOutBinding navHeaderHomeWorkOutBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.nav_header_home_work_out, mActivityHomeBinding.navView,false);
        mActivityHomeBinding.navView.addHeaderView(navHeaderHomeWorkOutBinding.getRoot());

        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public HomeWorkoutViewModel getViewModel() {
        mHomeViewModel = ViewModelProviders.of(this, mViewModelFactory).get(HomeWorkoutViewModel.class);
        return mHomeViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home_work_out;
    }


    @Override
    public void openActivity() {

    }

    @Override
    public void handleError() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mDrawer.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.nav_camera:
                Toast.makeText(this, "Camera App", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}
