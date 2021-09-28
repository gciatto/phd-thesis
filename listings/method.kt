fun method(request: Request): Sequence<Response> = sequence {
  request.arguments[i] // read the i-th actual argument
  request.context.staticKb[h] // read clauses in KB whose head matches h
  solve(goal) // perform sub-queries

  val substitution = (arg0 mguWith value0) + (arg1 mguWith value1) + ...

  yield(request.replyWith(substitution))
  // or
  yield(request.replyFail())
  // or
  yield(request.reply*(...))
}