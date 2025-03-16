package com.hito.base.architecture.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.mycompose.ui.theme.MyComposeTheme
import com.hito.base.architecture.navigation.BaseFeatureMapper
import com.hito.base.architecture.navigation.BaseRoute

/**
 * This is a themed implementation of BaseActivity. Used if there is no need to modify the base theme.
 * This class is placed directly in the project implementing the architecture library.
 */
abstract class ThemedBaseActivity(private val featureMapper: BaseFeatureMapper<BaseRoute>) : BaseActivity(featureMapper) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme()
    }

    override fun setTheme() {
        setContent {
            MyComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    setNavController(rememberNavController())
                }
            }
        }
    }
}