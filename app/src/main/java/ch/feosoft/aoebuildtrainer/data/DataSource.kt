package ch.feosoft.aoebuildtrainer.data

import ch.feosoft.aoebuildtrainer.model.BuildOrder

object DataSource {

    private val data = mutableListOf(
        BuildOrder("Cicero 22p Scouts"),
        BuildOrder("Cicero 22p M@A"),
        BuildOrder("Cicero 27+2 FC"),
        BuildOrder("Mine"),
        BuildOrder("Trush"),
        BuildOrder("Turk FI"),
        BuildOrder("FI"),
        BuildOrder("FC UU"),
        BuildOrder("Cicero 22p Archers"),
        BuildOrder("Smush"),
        BuildOrder("Drush FC")
    )

    fun getData(): List<BuildOrder> {
        return data
    }

    fun addBuildOrder(buildOrder: BuildOrder) {
        data.add(buildOrder)
    }
}