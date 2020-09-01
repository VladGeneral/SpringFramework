insert into users values
('john', '{bcrypt}$2y$12$Pc.Ehzze1wXZ8S1Mdot5eeLIl351iJz/f336U93H4g1RDJMpkyDli', 1),
('mary', '{bcrypt}$2y$12$Pc.Ehzze1wXZ8S1Mdot5eeLIl351iJz/f336U93H4g1RDJMpkyDli', 1),
('susan', '{bcrypt}$2y$12$Pc.Ehzze1wXZ8S1Mdot5eeLIl351iJz/f336U93H4g1RDJMpkyDli', 1);

insert into authorities values
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_ADMIN');