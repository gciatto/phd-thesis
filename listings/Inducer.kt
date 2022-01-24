interface Inducer {
    fun induce(
        positiveExamples: Iterable<Clause>,
        negativeExamples: Iterable<Clause>,
        background: Theory
    ): Theory
}