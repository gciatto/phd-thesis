interface Solver { 
    val staticKb: Theory
    val dynamicKb: Theory
    val libraries: Libraries
    fun solve(goal: Struct): Sequence<Solution> 
}