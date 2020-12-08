create database origin_studenls;

use origin_studenls;

create table student
(
	student_id int not null
		primary key,
	name char(10) not null,
	open_id char(30) null
);

create table note
(
	note_id char(20) not null
		primary key,
	start_time char(10) null,
	end_time char(10) null,
	content varchar(255) null,
	state int null,
	type int null,
	student_id int null,
	constraint note_ibfk_1
		foreign key (student_id) references student (student_id)
);

create index student_id
	on note (student_id);

create table teacher
(
	teacher_id int not null
		primary key,
	name char(10) not null,
	open_id char(30) null
);

create table course
(
	course_id int not null
		primary key,
	course_name varchar(20) not null,
	teacher_id int null,
	constraint course_ibfk_1
		foreign key (teacher_id) references teacher (teacher_id)
);

create index teacher_id
	on course (teacher_id);

create table hits
(
	note_id char(20) not null,
	course_id int not null,
	primary key (note_id, course_id),
	constraint hits_ibfk_2
		foreign key (course_id) references course (course_id),
	constraint hits_note_note_id_fk
		foreign key (note_id) references note (note_id)
);

create index course_id
	on hits (course_id);

create table takes
(
	student_id int not null,
	course_id int not null,
	primary key (student_id, course_id),
	constraint takes_ibfk_1
		foreign key (student_id) references student (student_id),
	constraint takes_ibfk_2
		foreign key (course_id) references course (course_id)
);

create index course_id
	on takes (course_id);

create table times
(
	week int not null,
	time int not null,
	course_id int null,
	id int not null
		primary key,
	constraint times_ibfk_1
		foreign key (course_id) references course (course_id)
);

create table reviews
(
	note_id char(20) not null,
	teacher_id int not null,
	times_id int not null,
	primary key (note_id, teacher_id, times_id),
	constraint review_ibfk_1
		foreign key (note_id) references note (note_id),
	constraint review_ibfk_2
		foreign key (teacher_id) references teacher (teacher_id),
	constraint review_ibfk_3
		foreign key (times_id) references times (id)
);

create index teacher_id
	on review (teacher_id);

create index times_id
	on review (times_id);

create table selected
(
	note_id char(20) not null,
	times_id int not null,
	primary key (note_id, times_id),
	constraint selected_ibfk_1
		foreign key (note_id) references note (note_id),
	constraint selected_ibfk_2
		foreign key (times_id) references times (id)
);

create index times_id
	on selected (times_id);

create index course_id
	on times (course_id);
