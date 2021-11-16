ccpp(Temperature, ExhVacuum, Pressure, Humidity, Energy) :- 
     Temperature =< 8.74, Energy is 483.82.

ccpp(Temperature, ExhVacuum, Pressure, Humidity, Energy) :- 
     Temperature in [8.74, 11.69], Energy is 476.08.

ccpp(Temperature, ExhVacuum, Pressure, Humidity, Energy) :- 
     Temperature in [11.69, 14.45], Energy is 468.94.

ccpp(Temperature, ExhVacuum, Pressure, Humidity, Energy) :- 
     Temperature in [14.45, 17.82], Energy is 462.13.

ccpp(Temperature, ExhVacuum, Pressure, Humidity, Energy) :- 
     Temperature in [17.82, 22.77], ExhVacuum =< 47.33, Energy is 457.72.

ccpp(Temperature, ExhVacuum, Pressure, Humidity, Energy) :- 
     Temperature in [17.82, 22.77], ExhVacuum > 47.33, Energy is 449.16.

ccpp(Temperature, ExhVacuum, Pressure, Humidity, Energy) :- 
     Temperature > 22.77, ExhVacuum =< 66.21, Energy is 443.03.

ccpp(Temperature, ExhVacuum, Pressure, Humidity, Energy) :- 
     Temperature > 22.77, ExhVacuum > 66.21, Energy is 434.79.
