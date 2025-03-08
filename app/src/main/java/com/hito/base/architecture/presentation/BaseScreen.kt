package com.hito.base.architecture.presentation

import com.hito.base.architecture.navigation.BaseFeatureMapper
import com.hito.base.architecture.navigation.BaseRoute
import com.hito.base.architecture.navigation.Navigator

abstract class BaseScreen<
        ST : BaseState,
        A : BaseAction,
        VM : BaseViewModel<A, ST>,
        R : BaseRoute,
        M : BaseFeatureMapper<R>>(
    private val viewModel: VM,
    private val navigator: Navigator<R, M>,
) {


    init {
        viewModel.initializeViewModel(::onState)
    }

    protected fun emitAction(action: A) {
        viewModel.onAction(action)
    }

    protected fun navigate(route: R) {
        navigator.navigate(route)
    }

    abstract fun onState(state: ST)
}