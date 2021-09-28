fun natural(request: Request): Sequence<Response> = sequence {
    var n = 1
    while (true) {
        yield(Integer.of(n))
        n++
    }
  }.map {
    request.replyWith(request.arguments[0] mguWith it)
  }
