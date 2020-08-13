create table student
(

	id serial not null
		constraint student_pk
			primary key,
	first_name varchar(45),
	last_name varchar(45),
	email varchar(45)
);

alter table student owner to postgres;

create unique index student_id_uindex
	on student (id);

