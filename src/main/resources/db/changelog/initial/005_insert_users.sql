insert into users(email, password)
values ('kanat@ad.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2'),
       ('retreat@ad.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2');

insert into authorities(authority) values ('ADMIN');
insert into user_authority(user_id, authority_id)
values (1, 1), (2, 1);


insert into institutes(NAME)
values ('ИНСТИТУТ ДИЗАЙНА, АРХИТЕКТУРА И ТЕКСТИЛЯ'),
       ('ИНСТИТУТ ЦИФРОВОЙ ТРАНСФОРМАЦИИ И ПРОГРАММИРОВАНИЯ'),
       ('ИНСТИТУТ СТРОИТЕЛЬСТВА И ИННОВАЦИОННЫХ ТЕХНОЛОГИЙ'),
       ('ИНСТИТУТ ЭНЕРГЕТИКИ И ТРАНСПОРТА'),
       ('ИНСТИТУТ ЭКОНОМИКИ И МЕНЕДЖМЕНТА'),
       ('ИНСТИТУТ РОССИЙСКО-КЫРГЫЗСКОГО ИНСТИТУТА АВТОМАТИЗАЦИИ УПРАВЛЕНИЯ БИЗНЕСА'),
       ('ИНСТИТУТ МЕЖКУЛЬТУРНОЙ КОММУНИКАЦИИ И ПСИХОЛОГИИ'),
       ('ИНСТИТУТ МАРКЕТИНГА И ЭЛЕКТРОННОЙ КОММЕРЦИИ'),
       ('СТРУКТУРНЫЕ ПОДРАЗДЕЛЕНИЯ'),
       ('КИТЭ'),
       ('КОМТЕХНО')
