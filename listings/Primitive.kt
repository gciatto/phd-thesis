fun interface Primitive {
    fun solve(request: Request<ExecutionContext>): Sequence<Response>
}