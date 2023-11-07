create table candidate
(
    id          integer      not null,
    cv          varchar(255),
    description varchar(255),
    firstname   varchar(255) not null,
    lastname    varchar(255) not null,
    photo       varchar(255),
    secondname  varchar(255),
    primary key (id)
);
create table completed_tests
(
    candidate_id integer not null,
    id           integer not null,
    test_id      integer not null,
    primary key (id)
);
create table direction
(
    id          integer not null,
    description varchar(255),
    name        varchar(255),
    primary key (id)
);
create table l_directions_candidates
(
    candidate_id integer not null,
    direction_id integer not null,
    primary key (candidate_id, direction_id)
);
create table l_directions_tests
(
    direction_id integer not null,
    test_id      integer not null,
    primary key (direction_id, test_id)
);
create table test_result
(
    completed_test_id integer not null,
    grade             integer not null,
    id                integer not null,
    date              timestamp(6),
    primary key (id)
);
create table tests
(
    id          integer not null,
    description varchar(255),
    name        varchar(255),
    primary key (id)
);

create sequence candidate_id_seq start with 1 increment by 1;
create sequence completed_tests_id_seq start with 1 increment by 1;
create sequence direction_id_seq start with 1 increment by 1;
create sequence test_result_id_seq start with 1 increment by 1;
create sequence tests_id_seq start with 1 increment by 1;

alter table if exists completed_tests add constraint completed_test_candidate_fk foreign key (candidate_id) references candidate;
alter table if exists completed_tests add constraint completed_test_tests_fk foreign key (test_id) references tests;
alter table if exists l_directions_candidates add constraint candidate_direction_fk foreign key (direction_id) references direction;
alter table if exists l_directions_candidates add constraint direction_candidate_fk foreign key (candidate_id) references candidate;
alter table if exists l_directions_tests add constraint test_direction_fk foreign key (direction_id) references direction;
alter table if exists l_directions_tests add constraint direction_test_fk foreign key (test_id) references tests;
alter table if exists test_result add constraint test_result_completed_test_fk foreign key (completed_test_id) references completed_tests;
