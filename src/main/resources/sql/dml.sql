insert into company (name)
values ('Google'),
       ('Meta'),
       ('Amazon');

insert into company_locales (company_id, lang, desctiption)
values ((select id from company where name = 'Google'), 'en', 'Google description'),
       ((select id from company where name = 'Google'), 'ru', 'Google описание'),
       ((select id from company where name = 'Meta'), 'en', 'Meta description'),
       ((select id from company where name = 'Meta'), 'ru', 'Meta описание');

insert into users (birth_date, firstname, lastname, role, username, company_id)
values ('1990-01-11', 'Ivan', 'Dmitrof', 'USER', 'ivan@gmail.com', (select id from company where name = 'Google')),
       ('1990-01-11', 'Migel', 'Huares', 'USER', 'huares@gmail.com', (select id from company where name = 'Google')),
       ('1990-01-11', 'Sveta', 'Huares', 'USER', 'sveta@gmail.com', (select id from company where name = 'Meta'));