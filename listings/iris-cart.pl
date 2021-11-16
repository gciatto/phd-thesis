iris(SepalLength, SepalWidth, PetalLength, PetalWidth, setosa) :- 
    PetalLength =< 2.75.

iris(SepalLength, SepalWidth, PetalLength, PetalWidth, versicolor) :- 
    PetalLength > 2.75, PetalLength =< 4.85.

iris(SepalLength, SepalWidth, PetalLength, PetalWidth, virginica) :- 
    PetalLength > 2.75, PetalLength > 4.85.
