iris(SepalLength, SepalWidth, PetalLength, PetalWidth, setosa) :- 
    PetalLength =< 2.28.

iris(SepalLength, SepalWidth, PetalLength, PetalWidth, virginica) :- 
    PetalLength > 2.28, PetalWidth not_in [0.78, 1.68].

iris(SepalLength, SepalWidth, PetalLength, PetalWidth, versicolor).
