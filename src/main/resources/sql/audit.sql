ALTER TABLE users add column created_at TIMESTAMP;
ALTER TABLE users add column modified_at TIMESTAMP;


ALTER TABLE users add column created_by varchar(32);
ALTER TABLE users add column modified_by varchar(32);