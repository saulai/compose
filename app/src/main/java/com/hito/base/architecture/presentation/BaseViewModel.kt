package com.hito.base.architecture.presentation

abstract class BaseViewModel<A: BaseAction, ST:BaseState> {

    private lateinit var stateEmitter: (ST) -> Unit

    internal fun initializeViewModel(stateReceiver: (ST)-> Unit){
        this.stateEmitter = stateReceiver
    }

    protected fun emitState(state: ST){
        stateEmitter.invoke(state)
    }

    abstract fun onAction(action: A)


}