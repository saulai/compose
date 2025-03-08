package com.hito.base.architecture.presentation

abstract class BaseScreen<ST: BaseState, A:BaseAction, VM: BaseViewModel<A, ST>>(
    private val  viewModel: VM
) {

    init {
        viewModel.initializeViewModel(::onState)
    }

    protected fun emitAction(action: A){
        viewModel.onAction(action)
    }

    abstract fun onState(state: ST)
}