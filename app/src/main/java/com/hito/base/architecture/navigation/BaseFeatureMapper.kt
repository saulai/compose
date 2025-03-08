package com.hito.base.architecture.navigation

import androidx.navigation.NavHostController
import com.hito.base.architecture.exception.DuplicateRouteException

abstract class BaseFeatureMapper<R : BaseRoute>(routes: List<R>) {

    private lateinit var onNavigation: (String) -> Unit
    private lateinit var navController: NavHostController
    internal lateinit var routeList: MutableList<R>

    init {
        routeList.addAll(routes)
    }

    fun setNavController(navController: NavHostController) {
        onNavigation = { screen: String -> navController.navigate(screen) }
    }

    internal fun checkDuplicates(newRoutes: List<R>) {
        newRoutes.forEach { newRoute ->
            routeList.find { it.findAddress() == newRoute.findAddress() }
                ?.let { throw DuplicateRouteException("duplicate route -> ${newRoute::javaClass}") }
        }
    }

    internal fun mapRoute(route: R) {
        if (checkOuterNavigation(route)) {
            checkInnerNavigation(route)
        }
    }

    abstract fun checkOuterNavigation(route: R): Boolean

    private fun checkInnerNavigation(route: R) {
        navController.navigate(route.findAddress())
    }
}
