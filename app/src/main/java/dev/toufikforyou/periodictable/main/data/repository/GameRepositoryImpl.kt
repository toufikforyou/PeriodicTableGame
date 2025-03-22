package dev.toufikforyou.periodictable.main.data.repository

import dev.toufikforyou.periodictable.main.domain.model.Element
import dev.toufikforyou.periodictable.main.domain.model.GameState
import dev.toufikforyou.periodictable.main.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GameRepositoryImpl : GameRepository {
    override fun getAllElements(): Flow<List<Element>> = flow {
        // Emit shuffled elements
        emit(sampleElements.shuffled())
    }

    override fun getGameState(): Flow<GameState> = flow {
        emit(GameState())
    }

    override suspend fun saveGameState(state: GameState) {
        // Implement state saving logic
    }
    
    private val sampleElements = listOf(
        // Period 1
        Element(1, "H", "Hydrogen", 1.008, "NONMETAL"),
        Element(2, "He", "Helium", 4.003, "NOBLE_GAS"),
        
        // Period 2
        Element(3, "Li", "Lithium", 6.941, "ALKALI_METAL"),
        Element(4, "Be", "Beryllium", 9.012, "ALKALINE_EARTH_METAL"),
        Element(5, "B", "Boron", 10.811, "METALLOID"),
        Element(6, "C", "Carbon", 12.011, "NONMETAL"),
        Element(7, "N", "Nitrogen", 14.007, "NONMETAL"),
        Element(8, "O", "Oxygen", 15.999, "NONMETAL"),
        Element(9, "F", "Fluorine", 18.998, "HALOGEN"),
        Element(10, "Ne", "Neon", 20.180, "NOBLE_GAS"),

        // Period 3
        Element(11, "Na", "Sodium", 22.990, "ALKALI_METAL"),
        Element(12, "Mg", "Magnesium", 24.305, "ALKALINE_EARTH_METAL"),
        Element(13, "Al", "Aluminium", 26.982, "POST_TRANSITION_METAL"),
        Element(14, "Si", "Silicon", 28.086, "METALLOID"),
        Element(15, "P", "Phosphorus", 30.974, "NONMETAL"),
        Element(16, "S", "Sulfur", 32.065, "NONMETAL"),
        Element(17, "Cl", "Chlorine", 35.453, "HALOGEN"),
        Element(18, "Ar", "Argon", 39.948, "NOBLE_GAS"),

        // Period 4 (including first row transition metals)
        Element(19, "K", "Potassium", 39.098, "ALKALI_METAL"),
        Element(20, "Ca", "Calcium", 40.078, "ALKALINE_EARTH_METAL"),
        Element(21, "Sc", "Scandium", 44.956, "TRANSITION_METAL"),
        Element(22, "Ti", "Titanium", 47.867, "TRANSITION_METAL"),
        Element(23, "V", "Vanadium", 50.942, "TRANSITION_METAL"),
        Element(24, "Cr", "Chromium", 51.996, "TRANSITION_METAL"),
        Element(25, "Mn", "Manganese", 54.938, "TRANSITION_METAL"),
        Element(26, "Fe", "Iron", 55.845, "TRANSITION_METAL"),
        Element(27, "Co", "Cobalt", 58.933, "TRANSITION_METAL"),
        Element(28, "Ni", "Nickel", 58.693, "TRANSITION_METAL"),
        Element(29, "Cu", "Copper", 63.546, "TRANSITION_METAL"),
        Element(30, "Zn", "Zinc", 65.380, "TRANSITION_METAL"),
        Element(31, "Ga", "Gallium", 69.723, "POST_TRANSITION_METAL"),
        Element(32, "Ge", "Germanium", 72.640, "METALLOID"),
        Element(33, "As", "Arsenic", 74.922, "METALLOID"),
        Element(34, "Se", "Selenium", 78.960, "NONMETAL"),
        Element(35, "Br", "Bromine", 79.904, "HALOGEN"),
        Element(36, "Kr", "Krypton", 83.798, "NOBLE_GAS"),

        // Period 5
        Element(37, "Rb", "Rubidium", 85.468, "ALKALI_METAL"),
        Element(38, "Sr", "Strontium", 87.62, "ALKALINE_EARTH_METAL"),
        Element(39, "Y", "Yttrium", 88.906, "TRANSITION_METAL"),
        Element(40, "Zr", "Zirconium", 91.224, "TRANSITION_METAL"),
        Element(41, "Nb", "Niobium", 92.906, "TRANSITION_METAL"),
        Element(42, "Mo", "Molybdenum", 95.95, "TRANSITION_METAL"),
        Element(43, "Tc", "Technetium", 98.0, "TRANSITION_METAL"),
        Element(44, "Ru", "Ruthenium", 101.07, "TRANSITION_METAL"),
        Element(45, "Rh", "Rhodium", 102.91, "TRANSITION_METAL"),
        Element(46, "Pd", "Palladium", 106.42, "TRANSITION_METAL"),
        Element(47, "Ag", "Silver", 107.87, "TRANSITION_METAL"),
        Element(48, "Cd", "Cadmium", 112.41, "TRANSITION_METAL"),
        Element(49, "In", "Indium", 114.82, "POST_TRANSITION_METAL"),
        Element(50, "Sn", "Tin", 118.71, "POST_TRANSITION_METAL"),
        Element(51, "Sb", "Antimony", 121.76, "METALLOID"),
        Element(52, "Te", "Tellurium", 127.60, "METALLOID"),
        Element(53, "I", "Iodine", 126.90, "HALOGEN"),
        Element(54, "Xe", "Xenon", 131.29, "NOBLE_GAS"),

        // Period 6
        Element(55, "Cs", "Caesium", 132.91, "ALKALI_METAL"),
        Element(56, "Ba", "Barium", 137.33, "ALKALINE_EARTH_METAL"),
        // Lanthanides (57-71)
        Element(57, "La", "Lanthanum", 138.91, "LANTHANIDE"),
        Element(58, "Ce", "Cerium", 140.12, "LANTHANIDE"),
        Element(59, "Pr", "Praseodymium", 140.91, "LANTHANIDE"),
        Element(60, "Nd", "Neodymium", 144.24, "LANTHANIDE"),
        Element(61, "Pm", "Promethium", 145.0, "LANTHANIDE"),
        Element(62, "Sm", "Samarium", 150.36, "LANTHANIDE"),
        Element(63, "Eu", "Europium", 151.96, "LANTHANIDE"),
        Element(64, "Gd", "Gadolinium", 157.25, "LANTHANIDE"),
        Element(65, "Tb", "Terbium", 158.93, "LANTHANIDE"),
        Element(66, "Dy", "Dysprosium", 162.50, "LANTHANIDE"),
        Element(67, "Ho", "Holmium", 164.93, "LANTHANIDE"),
        Element(68, "Er", "Erbium", 167.26, "LANTHANIDE"),
        Element(69, "Tm", "Thulium", 168.93, "LANTHANIDE"),
        Element(70, "Yb", "Ytterbium", 173.05, "LANTHANIDE"),
        Element(71, "Lu", "Lutetium", 174.97, "LANTHANIDE"),
        Element(72, "Hf", "Hafnium", 178.49, "TRANSITION_METAL"),
        Element(73, "Ta", "Tantalum", 180.95, "TRANSITION_METAL"),
        Element(74, "W", "Tungsten", 183.84, "TRANSITION_METAL"),
        Element(75, "Re", "Rhenium", 186.21, "TRANSITION_METAL"),
        Element(76, "Os", "Osmium", 190.23, "TRANSITION_METAL"),
        Element(77, "Ir", "Iridium", 192.22, "TRANSITION_METAL"),
        Element(78, "Pt", "Platinum", 195.08, "TRANSITION_METAL"),
        Element(79, "Au", "Gold", 196.97, "TRANSITION_METAL"),
        Element(80, "Hg", "Mercury", 200.59, "POST_TRANSITION_METAL"),
        Element(81, "Tl", "Thallium", 204.38, "POST_TRANSITION_METAL"),
        Element(82, "Pb", "Lead", 207.2, "POST_TRANSITION_METAL"),
        Element(83, "Bi", "Bismuth", 208.98, "POST_TRANSITION_METAL"),
        Element(84, "Po", "Polonium", 209.0, "METALLOID"),
        Element(85, "At", "Astatine", 210.0, "HALOGEN"),
        Element(86, "Rn", "Radon", 222.0, "NOBLE_GAS"),

        // Period 7
        Element(87, "Fr", "Francium", 223.0, "ALKALI_METAL"),
        Element(88, "Ra", "Radium", 226.0, "ALKALINE_EARTH_METAL"),
        // Actinides (89-103)
        Element(89, "Ac", "Actinium", 227.0, "ACTINIDE"),
        Element(90, "Th", "Thorium", 232.04, "ACTINIDE"),
        Element(91, "Pa", "Protactinium", 231.04, "ACTINIDE"),
        Element(92, "U", "Uranium", 238.03, "ACTINIDE"),
        Element(93, "Np", "Neptunium", 237.0, "ACTINIDE"),
        Element(94, "Pu", "Plutonium", 244.0, "ACTINIDE"),
        Element(95, "Am", "Americium", 243.0, "ACTINIDE"),
        Element(96, "Cm", "Curium", 247.0, "ACTINIDE"),
        Element(97, "Bk", "Berkelium", 247.0, "ACTINIDE"),
        Element(98, "Cf", "Californium", 251.0, "ACTINIDE"),
        Element(99, "Es", "Einsteinium", 252.0, "ACTINIDE"),
        Element(100, "Fm", "Fermium", 257.0, "ACTINIDE"),
        Element(101, "Md", "Mendelevium", 258.0, "ACTINIDE"),
        Element(102, "No", "Nobelium", 259.0, "ACTINIDE"),
        Element(103, "Lr", "Lawrencium", 262.0, "ACTINIDE"),
        Element(104, "Rf", "Rutherfordium", 267.0, "TRANSITION_METAL"),
        Element(105, "Db", "Dubnium", 268.0, "TRANSITION_METAL"),
        Element(106, "Sg", "Seaborgium", 269.0, "TRANSITION_METAL"),
        Element(107, "Bh", "Bohrium", 270.0, "TRANSITION_METAL"),
        Element(108, "Hs", "Hassium", 269.0, "TRANSITION_METAL"),
        Element(109, "Mt", "Meitnerium", 278.0, "TRANSITION_METAL"),
        Element(110, "Ds", "Darmstadtium", 281.0, "TRANSITION_METAL"),
        Element(111, "Rg", "Roentgenium", 282.0, "TRANSITION_METAL"),
        Element(112, "Cn", "Copernicium", 285.0, "TRANSITION_METAL"),
        Element(113, "Nh", "Nihonium", 286.0, "POST_TRANSITION_METAL"),
        Element(114, "Fl", "Flerovium", 289.0, "POST_TRANSITION_METAL"),
        Element(115, "Mc", "Moscovium", 290.0, "POST_TRANSITION_METAL"),
        Element(116, "Lv", "Livermorium", 293.0, "POST_TRANSITION_METAL"),
        Element(117, "Ts", "Tennessine", 294.0, "HALOGEN"),
        Element(118, "Og", "Oganesson", 294.0, "NOBLE_GAS")
    )
}
