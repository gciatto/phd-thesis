class Request(
    val context: ExecutionContext,
    val signature: Signature,
    val arguments: List<Term>
) { 
    fun solve(subQuery: Struct): Sequence<Solution>
    fun replySuccess(): Response
    fun replyFail(): Response
    fun replyWith(substition: Substitution): Response
    fun replyException(exception: TuPrologRuntimeException): Response
}