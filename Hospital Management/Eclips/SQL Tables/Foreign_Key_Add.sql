alter table patient
		add foreign key(diagnosis) references diagnosis_fees(diagnosis);