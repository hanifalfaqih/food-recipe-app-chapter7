package com.allana.food_recipe_app_chapter7.di

import com.allana.food_recipe_app_chapter7.base.arch.GenericViewModelFactory
import com.allana.food_recipe_app_chapter7.ui.features.home.HomeRepository
import com.allana.food_recipe_app_chapter7.ui.features.home.HomeViewModel
import com.allana.food_recipe_app_chapter7.ui.loginpage.LoginPageRepository
import com.allana.food_recipe_app_chapter7.ui.loginpage.LoginPageViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ViewModelModule {

    // TODO add detailViewModel
    @Provides
    @ActivityScoped
    fun provideCoinListViewModel(
        homeRepository: HomeRepository
    ): HomeViewModel {
        return GenericViewModelFactory(HomeViewModel(homeRepository)).create(
            HomeViewModel::class.java
        )
    }
    @Provides
    @ActivityScoped
    fun provideLoginPageViewModel(
        repository : LoginPageRepository
    ) : LoginPageViewModel{
        return GenericViewModelFactory(LoginPageViewModel(repository)).create(
            LoginPageViewModel::class.java
        )
    }
    // TODO add registerViewModel
    // TODO add splashViewModel
    // TODO add profileViewModel
}