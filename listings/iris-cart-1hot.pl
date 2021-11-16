iris(SepalLength, SepalWidth, PetalLength, PetalWidth, setosa) :- 
    PetalWidth =< 0.78.

iris(SepalLength, SepalWidth, PetalLength, PetalWidth, versicolor) :- 
    PetalWidth > 0.78, PetalWidth in [0.78, 1.68], PetalLength <= 4.91.

iris(SepalLength, SepalWidth, PetalLength, PetalWidth, virginica) :- 
    PetalWidth > 0.78, PetalWidth in [0.78, 1.68], PetalLength > 4.91.

iris(SepalLength, SepalWidth, PetalLength, PetalWidth, virginica) :- 
    PetalWidth > 0.78, PetalWidth > 1.68.
