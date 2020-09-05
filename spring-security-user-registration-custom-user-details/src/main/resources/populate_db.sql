
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: http://www.luv2code.com/generate-bcrypt-password
--
--
-- Default passwords here are: fun123

INSERT INTO "user" (username,password,first_name,last_name,email)
VALUES 
('john','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','John','Doe','john@luv2code.com'),
('mary','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Mary','Public','mary@luv2code.com'),
('susan','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Susan','Adams','susan@luv2code.com');



INSERT INTO role (name)
VALUES 
('ROLE_EMPLOYEE'),('ROLE_MANAGER'),('ROLE_ADMIN');

--
-- Table structure for table `users_roles`
--



INSERT INTO users_roles (user_id,role_id)
VALUES 
(1, 1),
(2, 1),
(2, 2),
(3, 1),
(3, 3)