no_attack((X1, Y1), (X2, Y2)) :-
  X1 =\= X2, % infix operator
  Y1 =\= Y2,
  (Y2 - Y1) =\= (X2 - X1), 
  (Y2 - Y1) =\= (X1 - X2). % arithmetic expression

no_attack_all(_, []).
no_attack_all(C , [H | Hs]) :-
  no_attack(C, H),
  no_attack_all(C, Hs).

solution(_, []).
solution(N, [(X, Y) | Cs]) :-
  solution(N, Cs),
  between(1, N, Y), % built-in predicate
  no_attack_all((X, Y), Cs).