package ch.feosoft.aoebuildtrainer.service

import ch.feosoft.aoebuildtrainer.data.DataSource
import ch.feosoft.aoebuildtrainer.model.BuildOrder

object BuildOrderService {

    fun getAllBuildOrders(): List<BuildOrder> {
        return DataSource.getData()
    }

    fun addBuildOrder(buildOrder: BuildOrder) {
        DataSource.addBuildOrder(buildOrder)
    }
}