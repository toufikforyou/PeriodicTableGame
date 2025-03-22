package dev.toufikforyou.periodictable.main.domain.model

data class Element(
    val atomicNumber: Int,
    val symbol: String,
    val name: String,
    val atomicMass: Double,
    val category: String
)

enum class ElementCategory {
    ALKALI_METAL,
    ALKALINE_EARTH_METAL,
    TRANSITION_METAL,
    POST_TRANSITION_METAL,
    METALLOID,
    NONMETAL,
    HALOGEN,
    NOBLE_GAS,
    LANTHANIDE,
    ACTINIDE
}