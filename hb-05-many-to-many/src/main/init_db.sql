create table instructor
(
	id serial not null
		constraint instructor_pk
			primary key,
	first_name varchar(45),
	last_name varchar(45),
	email varchar(45),
	instructor_detail_id integer
		constraint instructor_instructor_detail_id_fk
			references instructor_detail
);

alter table instructor owner to postgres;

create unique index instructor_id_uindex
	on instructor (id);

create table instructor_detail
(
    id serial not null
        constraint instructor_detail_pk
            primary key,
    youtube_channel varchar(128),
    hobby varchar(45)
);

alter table instructor_detail owner to postgres;

create unique index instructor_detail_id_uindex
    on instructor_detail (id);

    create table review
(
	id serial not null
		constraint review_pk
			primary key,
	comment varchar(256),
	course_id integer
		constraint review_course_id_fk
			references course
);

alter table review owner to postgres;

create unique index review_id_uindex
	on review (id);


create table course
(
	id serial not null
		constraint course_pk
			primary key,
	title varchar(128),
	instructor_id integer
		constraint course_instructor_id_fk
			references instructor
);

alter table course owner to postgres;

create unique index course_id_uindex
	on course (id);

create unique index course_title_uindex
	on course (title);

create table course_student
(
	course_id int not null
		constraint course_student_course_id_fk
			references course,
	student_id int not null
		constraint course_student_student_id_fk
			references student,
	primary key (course_id,student_id)
);

alter table course_student owner to postgres;

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




