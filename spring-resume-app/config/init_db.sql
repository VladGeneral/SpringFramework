create table account
(
	id bigint not null
		constraint account_pk
			primary key,
	login varchar not null,
	password varchar not null,
	first_name varchar not null,
	last_name varchar not null,
	middle_name varchar,
	email varchar not null,
	active boolean default true not null,
	created timestamp default now() not null
);

alter table account owner to resume;

create unique index account_email_uindex
	on account (email);

create unique index account_id_uindex
	on account (id);

create unique index account_login_uindex
	on account (login);



create table role
(
	id smallint not null
		constraint role_pk
			primary key,
	name varchar not null
);

alter table role owner to resume;

create unique index role_id_uindex
	on role (id);


create table account_role
(
	id bigint not null
		constraint account_role_pk
			primary key,
	id_account bigint not null
		constraint account_role_account_id_fk
			references account
				on update cascade on delete cascade,
	id_role smallint not null
		constraint account_role_role_id_fk
			references role
				on update cascade on delete cascade
);

alter table account_role owner to resume;

create unique index account_role_id_uindex
	on account_role (id);

create unique index account_role_id_account_id_role_uindex
	on account_role (id_account, id_role);




create table account_registration
(
	id bigint not null
		constraint account_registration_pk
			primary key
		constraint account_registration_account_id_fk
			references account
				on update cascade on delete cascade,
	code varchar not null
);

alter table account_registration owner to resume;

create unique index account_registration_code_uindex
	on account_registration (code);

create unique index account_registration_id_uindex
	on account_registration (id);



create table test
(
	id bigint not null
		constraint test_pk
			primary key,
	id_account bigint not null
		constraint test_account_id_fk
			references account
				on update cascade on delete cascade,
	name varchar not null,
	description text not null,
	time_per_question integer default 30 not null
);

alter table test owner to resume;

create unique index test_id_uindex
	on test (id);




create table question
(
	id bigint not null
		constraint question_pk
			primary key,
	id_test bigint not null
		constraint question_test_id_fk
			references test
				on update cascade on delete cascade,
	name varchar not null
);

alter table question owner to resume;

create unique index question_id_uindex
	on question (id);



create table answer
(
	id bigint not null
		constraint answer_pk
			primary key,
	id_question bigint not null
		constraint answer_question_id_fk
			references question
				on update cascade on delete cascade,
	name varchar not null,
	correct boolean default false not null
);

alter table answer owner to resume;

create unique index answer_id_uindex
	on answer (id);



create table result
(
    id bigint not null
        constraint result_pk
            primary key,
    id_account bigint not null
        constraint result_account_id_fk
            references account
            on update cascade on delete cascade,
    id_test bigint
        constraint result_test_id_fk
            references test
            on update cascade on delete set null,
    percent double precision not null,
    test_name varchar not null,
    test_description text not null,
    created timestamp default now() not null
);

alter table result owner to resume;

create unique index result_id_uindex
    on result (id);





create sequence account_seq;

alter sequence account_seq owner to resume;

create sequence account_role_seq;

alter sequence account_role_seq owner to resume;

create sequence answer_seq;

alter sequence answer_seq owner to resume;

create sequence question_seq;

alter sequence question_seq owner to resume;

create sequence result_seq;

alter sequence result_seq owner to resume;

create sequence test_seq;

alter sequence test_seq owner to resume;

















