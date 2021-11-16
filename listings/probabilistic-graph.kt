// Kotlin
val clausesParser = ClausesParser.withOperators(PROBLOG_OPERATORS)
val probabilisticTheory = clausesParser.parseTheory("(*@\color{magenta}$\langle$@*)theory from (*@\color{magenta}\cref{fig:valid-probabilistic-graph}$\rangle$@*)")
val problogSolver = Solver.problog.solverWithDefaultBuiltins(staticKb = probabilisticTheory)
val goal = Struct.of("path", Var.of("From"), Var.of("To"))
for (solution in problogSolver.solve(goal, SolveOptions.allLazily().probabilistic()))
    if (solution.isYes)
        println("yes: ${solution.solvedQuery} with probability ${solution.probability}")
