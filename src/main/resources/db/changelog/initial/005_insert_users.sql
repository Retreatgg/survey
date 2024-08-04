insert into users(email, password)
values ('kanat@ad.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2'),
       ('retreat@ad.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2');

insert into authorities(authority) values ('ADMIN');
insert into user_authority(user_id, authority_id)
values (1, 1), (2, 1);