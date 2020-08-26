create table customer
(
	id serial not null
		constraint customer_pk
			primary key,
	first_name varchar(45),
	last_name varchar(45),
	email varchar(45)
);

alter table customer owner to postgres;

create unique index customer_id_uindex
	on customer (id);

