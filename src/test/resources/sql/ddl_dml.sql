insert into company (id, name)
values (1, 'Google'),
       (2, 'Meta'),
       (3, 'Amazon');

select setval('company_id_seq', (select  max(id) from company));

insert into company_locales (company_id, lang, desctiption)
values ((select id from company where name = 'Google'), 'en', 'Google description'),
       ((select id from company where name = 'Google'), 'ru', 'Google описание'),
       ((select id from company where name = 'Meta'), 'en', 'Meta description'),
       ((select id from company where name = 'Meta'), 'ru', 'Meta описание');

insert into users (id, birth_date, firstname, lastname, role, username, company_id)
values (1, '1990-01-11', 'Ivan', 'Dmitrof', 'USER', 'ivan@gmail.com', (select id from company where name = 'Google')),
       (2, '1990-01-11', 'Migel', 'Huares', 'USER', 'huares@gmail.com', (select id from company where name = 'Google')),
       (3, '1990-01-11', 'Sveta', 'Huares', 'USER', 'sveta@gmail.com', (select id from company where name = 'Meta'));

select setval('users_id_seq', (select  max(id) from users));

