package com.khunchheang.photobookmark.di.builder

import com.khunchheang.photobookmark.ui.module.MainActivityModule
import com.khunchheang.photobookmark.ui.mvp.mainactivity.MainActivity
import com.khunchheang.photobookmark.ui.scope.MainActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @MainActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

}