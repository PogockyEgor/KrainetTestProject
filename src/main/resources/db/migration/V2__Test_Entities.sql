insert into direction (id, name, description)
values (1, 'backend', 'java backend developer');

insert into direction (id, name, description)
values (2, 'frontend', 'TS frontend developer');

insert into tests (id, name, description)
values (1, 'CV Service', 'web service development test for java backend developer');

insert into l_directions_tests (test_id, direction_id)
values (1,1);

insert into candidate (id, firstname, lastname, secondname, description, cv, photo)
values (1,'Egor', 'Pogocky', 'Stanislavovich', 'good candidate', 'path/to/file/cv.pdf', 'path/to/file/photo.png');

insert into l_directions_candidates (candidate_id, direction_id)
values (1,1);

insert into completed_tests(id, candidate_id, test_id)
values (1,1,1);

insert into test_result (id, date, grade, completed_test_id)
values (1, '2023-11-06', 9, 1);

insert into test_result (id, date, grade, completed_test_id)
values (2, '2023-11-07', 10, 1);
