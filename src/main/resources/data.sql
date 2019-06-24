
create table if not exists persistent_logins ( 
  username varchar(100) not null, 
  series varchar(64) primary key, 
  token varchar(64) not null, 
  last_used timestamp not null
);
/*
delete from  employes_role;
delete from  role;
delete from  employe;


INSERT INTO role (id, name) VALUES 
(1, 'ROLE_ADMIN'),
(2, 'ROLE_ACTUATOR'),
(3, 'ROLE_USER')
;




INSERT INTO employe (id, name, password, tlphon, enabled, mytask_id) VALUES 
(1, 'admin', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS', '1234',1,61),
(3, 'user', '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by', '1252',1,61);
insert into employes_role(employe_id, role_id) values
(1,1),
(1,2),
(1,3),
(3,2)
;
*/
 /*

INSERT INTO employe (id, name, password, tlphon) VALUES 
(1, 'admin', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS', 'Admin'),
(3, 'user', '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by', 'User');


insert into employe_role(employe_id, role_id) values
(1,1),
(1,2),
(1,3),
(3,2)
;*/