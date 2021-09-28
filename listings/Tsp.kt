import it.unibo.tuprolog.core.List as LogicList

object Tsp : TernaryRelation<ExecutionContext>("tsp") {
  init { com.google.ortools.Loader.loadNativeLibraries() }

  private fun Request<ExecutionContext>.tsp(cities: List<Term>): Sequence<Pair<LogicList, Integer>> { ... }

  // other utility methods

  override fun Request<ExecutionContext>.computeAll(fst: Term, snd: Term, trd: Term): Sequence<Response> {
    val allCities = solve(Struct.template("path", 3))
      .filterIsInstance<Solution.Yes>()
      .map { it.solvedQuery }
      .flatMap { sequenceOf(it[0], it[1]) }
      .toSet()

    return allCities
      .subsets()
      .flatMap { it.permutations() }
      .map { it to (Set.of(it) mguWith fst) }
      .filter { (cities, substitution) -> cities.isNotEmpty() && substitution is Unifier }
      .flatMap { (cities, substitution) -> tsp(cities).map { it.addLeft(substitution) } }
      .map { (substitution, circuit, cost) -> substitution + (snd mguWith circuit) + (trd mguWith cost) }
      .filterIsInstance<Unifier>()
      .map { replySuccess(it) }
  }
}