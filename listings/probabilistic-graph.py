# Python
probabilisticTheory = parse_theory("(*@\color{magenta}$\langle$@*)theory from (*@\color{magenta}\cref{fig:valid-probabilistic-graph}$\rangle$@*)", PROBLOG_OPERATORS)
problogSolver = problog_solver(static_kb=probabilisticTheory)
query = struct('path', var('From'), var('To'))
for solution in problogSolver.solve(query, solve_options(lazy=True, probabilistic=True)):
    if solution.is_yes:
        print(f"yes: {solution.solved_query} with probability {probability(solution)}")
