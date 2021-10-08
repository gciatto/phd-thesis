val x = train.inputsArray()
val y = train.classesArray()
val knn = knn(x, y, 5) // 5-nearest-neighbours classifier
val mlp = mlp(x, y,    // multi-layer perceptron classifier 
    arrayOf(Layer.rectifier(15),                 // with 2 hidden layers
        Layer.rectifier(5), 
        Layer.mle(3, OutputFunction.SIGMOID)), // with sigmoid activation
    epochs, TimeFunction.constant(learningRate))
val decisionTree = cart( // decision tree classifier
    Formula.lhs("Class"), train.inputs().merge(train.classes()),
    SplitRule.GINI, maxDepth, maxNodes, nodeSize)