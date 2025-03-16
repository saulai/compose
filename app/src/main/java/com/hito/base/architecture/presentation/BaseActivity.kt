package com.hito.base.architecture.presentation

import androidx.activity.ComponentActivity
import androidx.navigation.NavHostController
import com.hito.base.architecture.navigation.BaseFeatureMapper
import com.hito.base.architecture.navigation.BaseRoute

abstract class BaseActivity(private val featureMapper: BaseFeatureMapper<BaseRoute>) : ComponentActivity() {

    protected fun setNavController(navHostController: NavHostController){
        featureMapper.setNavController(navHostController)
    }

    abstract fun setTheme()
}