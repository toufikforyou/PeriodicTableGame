package dev.toufikforyou.periodictable.main.domain.model

data class Element(
    val atomicNumber: Int,
    val symbol: String,
    val name: String,
    val atomicMass: Double,
    val category: String
)