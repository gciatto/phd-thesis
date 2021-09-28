fun even(request: Request): Sequence<Response> = sequence {
    var n = 1
    while (true) {
        yield(Integer.of(n))
        n++
    }
  }.filter {
    it.value % 2 == 0
  }.map {
    request.replyWith(request.arguments[0] mguWith it)
  }
