
ALTER TABLE organization DROP CONSTRAINT ORGANIZATION_MANAGER;
ALTER TABLE employees DROP CONSTRAINT DIVISION_MANAGER;
ALTER TABLE orders DROP CONSTRAINT ORDERS_AUTHOR;
ALTER TABLE orders DROP CONSTRAINT ORDERS_EXECUTOR;


DROP TABLE employees IF EXISTS;
DROP TABLE divisions IF EXISTS;
DROP TABLE organization IF EXISTS;
DROP TABLE orders IF EXISTS;
DROP SEQUENCE global_seq IF EXISTS;