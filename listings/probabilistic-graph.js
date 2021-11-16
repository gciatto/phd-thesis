// JavaScript
let clausesParser = ClausesParser.Companion.withOperatorSet(PROBLOG_OPERATORS)
let scope = Scope.Companion.empty()
let probabilisticTheory = clausesParser.parseTheory("(*@\color{magenta}$\langle$@*)theory from (*@\color{magenta}\cref{fig:valid-probabilistic-graph}$\rangle$@*)")
let problogSolver = Solver.Companion.problog.solverWithDefaultBuiltinsAndStaticKB(probabilisticTheory)
let query = scope.structOf("path", [scope.varOf("From"), scope.varOf("To")])
let options = probabilistic(SolveOptions.Companion.allLazily())
let si = problogSolver.solveWithOptions(query, options).iterator()
while (si.hasNext()) {
    let solution = si.next();
    if (solution.isYes)
        console.log('yes: ${solution.solvedQuery} with probability ${probability(solution)}')
}
