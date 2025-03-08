package com.hito.base.architecture.navigation

import com.hito.base.architecture.exception.DuplicateRouteException

abstract class BaseFeatureMapper<R : BaseRoute>(routes: List<R>) {

    internal lateinit var routeList: MutableList<R>

    init {
        routeList.addAll(routes)
    }

    internal fun checkDuplicates(newRoutes: List<R>) {
        newRoutes.forEach { newRoute ->
            routeList.find { it.address == newRoute.address }
                ?.let { throw DuplicateRouteException("duplicate route -> ${newRoute::javaClass}") }
        }
    }

    abstract fun mapRoute(route: R)
}
