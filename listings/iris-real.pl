iris(SepalLength, SepalWidth, PetalLength, PetalWidth, setosa) :- 
    PetalWidth =< 0.78.

iris(SepalLength, SepalWidth, PetalLength, PetalWidth, versicolor) :- 
    PetalWidth > 0.78, PetalLength in [2.86, 4.91].

iris(SepalLength, SepalWidth, PetalLength, PetalWidth, virginica) :- 
    PetalWidth > 0.78, PetalLength not_in [2.86, 4.91].
