fun nQueens(n: Int) = prolog {
  staticKb(
    rule {
      "no_attack"(("X1" and "Y1"), ("X2" and "Y2")) `if` (
          ("X1" `=!=` "X2") and // infix operator
          ("Y1" `=!=` "Y2") and
          (("Y2" - "Y1") `=!=` ("X2" - "X1")) and
          (("Y2" - "Y1") `=!=` ("X1" - "X2")) // arithmetic expr
        )
    },
    fact { "no_attack_all"(`_`, emptyList) },
    rule {
      "no_attack_all"("C", consOf("H", "Hs")) `if` (
          "no_attack"("C", "H") and
          "no_attack_all"("C", "Hs")
        )
    },
    fact { "solution"(`_`, emptyList) },
    rule {
      "solution"("N", consOf(("X" and "Y"), "Cs")) `if` (
          "solution"("N", "Cs") and
          between(1, "N", "Y") and // built-in predicate
          "no_attack_all"(("X" and "Y"), "Cs")
        )
    }
  )
  return solve("solution"(n, (1 .. n).map { it and "Y$it" }))
}