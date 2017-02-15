--liquibase formatted sql
--changeset me:0001.1 context=all
CREATE TABLE template
(
    id serial,
    text character varying(32) NOT NULL,
    PRIMARY KEY (id)
);
--rollback DROP TABLE template;

--liquibase formatted sql
--changeset me:0001.2 context=all
insert into template(text) values ('Hello, %s!');
insert into template(text) values ('Zdravstvujte, %s!');
insert into template(text) values ('Bok, %s!');
--rollback DELETE FROM template;