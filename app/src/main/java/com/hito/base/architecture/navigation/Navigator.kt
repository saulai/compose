package com.hito.base.architecture.navigation

import com.hito.base.architecture.exception.DuplicateRouteException

class Navigator<R : BaseRoute, M : BaseFeatureMapper<R>>(private val featureMappers: List<M>) {

    init {
        featureMappers.forEach {
            checkDuplicates(it)
        }
    }

    fun navigate(route: R) {
        featureMappers.forEach { it.mapRoute(route) }
    }

    private fun checkDuplicates(featureMapper: M) {
        try {
            featureMappers.forEach { it.checkDuplicates(featureMapper.routeList) }
        } catch (exception: DuplicateRouteException) {
            throw DuplicateRouteException(
                "Feature mapper -> ${featureMapper::javaClass} with ${exception.description}"
            )
        }
    }
}