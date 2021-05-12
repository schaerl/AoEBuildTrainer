package ch.feosoft.aoebuildtrainer.model

import androidx.annotation.DrawableRes
import ch.feosoft.aoebuildtrainer.R

data class BuildOrder(val name: String, val subtitle: String, @DrawableRes val iconResourceId: Int) {
    constructor(name: String) : this(name, "", R.drawable.default_icon)
}
