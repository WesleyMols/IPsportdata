CREATE PROCEDURE `create_view` ()
BEGIN
Drop view  if exists output;

create view output AS
Select	power, lactate_one, lactate_two, lt_diff
From user_input
where username = 'wes';

SELECT * FROM db_ip_wesley.output;
END
