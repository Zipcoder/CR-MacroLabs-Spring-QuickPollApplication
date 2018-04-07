//Poll Creation
insert into poll (poll_id, question) values (1, 'What is your favorite color?');
insert into poll (poll_id, question) values (2, 'What is your favorite superhero?');
insert into poll (poll_id, question) values (3, 'What is your favorite state?');
insert into poll (poll_id, question) values (4, 'What is your favorite animal?');
insert into poll (poll_id, question) values (5, 'What is your favorite teacher?');

//Option Creation
insert into option (option_id, option_value, poll_id) values (1, 'Red', 1);
insert into option (option_id, option_value, poll_id) values (2, 'Green', 1);
insert into option (option_id, option_value, poll_id) values (3, 'Blue', 1);
insert into option (option_id, option_value, poll_id) values (4, 'Super Man', 2);
insert into option (option_id, option_value, poll_id) values (5, 'Spooder Man', 2);
insert into option (option_id, option_value, poll_id) values (6, 'Bat Man', 2);
insert into option (option_id, option_value, poll_id) values (7, 'PA', 3);
insert into option (option_id, option_value, poll_id) values (8, 'NJ', 3);
insert into option (option_id, option_value, poll_id) values (9, 'CA', 3);
insert into option (option_id, option_value, poll_id) values (10, 'Deerbra', 4);
insert into option (option_id, option_value, poll_id) values (11, 'Cat', 4);
insert into option (option_id, option_value, poll_id) values (12, 'Tiger', 4);
insert into option (option_id, option_value, poll_id) values (13, 'Leon', 5);
insert into option (option_id, option_value, poll_id) values (14, 'Tariq', 5);
insert into option (option_id, option_value, poll_id) values (15, 'Froilan', 5);