%  declaring & fitting the preprocessing pipeline
preprocessing_pipeline(Dataset, Schema, Pipeline) :- 
    schema_transformation(Schema, Step0),
    Classes = [petal_width, petal_length, sepal_width, sepal_length],
    normalize(Step0, Classes, Step1),
    one_hot_encode(Step1, [species], Step2), 
    fit(Step2, Dataset, Pipeline).
