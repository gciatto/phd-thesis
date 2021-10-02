prolog {
  staticKb(
    rule {
      "ancestor"("X", "Y") `if` "parent"("X", "Y")
    },
    rule {
      "ancestor"("X", "Y") `if` ("parent"("X", "Z") and "ancestor"("Z", "Y"))
    },
    fact { "parent"("abraham", "isaac") },
    fact { "parent"("isaac", "jacob") },
    fact { "parent"("jacob", "joseph") }
  )

  for (sol in solve("ancestor"("abraham", "X")))
    if (sol is Solution.Yes)
      println(sol.substitution["X"])
}

