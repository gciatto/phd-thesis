/* Hyper paramenters */
hidden_layers([10]). hidden_layers([20, 10]). hidden_layers([30, 20, 10]).

/* Learning paramenters */
max_epochs(30). max_epochs(50).
batch_size(32). batch_size(16).
learning_rate(0.01). learning_rate(0.1).
loss(cross_entropy).

/* Workflow paramenters */
target_performance(0.90).
test_percentage(0.2).

/* Generates all possible hyper and learning params combinations */
params(
    [hidden_layers(H)],
    [iterations(X), learning_rate(Y), batch_size(Z), loss(L)]
) :- hidden_layers(H),
     max_epochs(X),
     learning_rate(Y),
     batch_size(Z),
     loss(L).

/* Generates and trains all possible Predictors for the given Dataset and Schema, */
/* whose Performance is at least target_performance. */
model_selection(Dataset, Schema, Predictor, Transformation, Performance) :-
     test_percentage(R), target_performance(T),
     random_split(Dataset, R, TraingSet, TestSet),
     preprocessing_pipeline(TraingSet, Schema, Transformation),
     transform(TraingSet, Transformation, ProcessedTrainingSet),
     params(HyperParams, LearnParams),
     train_cv(TraingSet, HyperParams, LearnParams, P),
     P >= T,
     multi_layer_perceptron(4, HyperParams, NN),
     train(NN, TrainingSet, LearnParams, Predictor),
     transform(TraingSet, Transformation, ProcessedTestSet),
     test(NN, TestSet, Performance).

/* Example of training query: */
?- iris_dataset(D), iris_schema(S), model_selection(D, S, P, _, A).
