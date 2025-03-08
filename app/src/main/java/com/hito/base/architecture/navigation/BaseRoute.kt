package com.hito.base.architecture.navigation

open class BaseRoute(private val address: String){
    open fun findAddress() = address
}