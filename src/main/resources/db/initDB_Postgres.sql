
ALTER TABLE organization DROP CONSTRAINT ORGANIZATION_MANAGER;
ALTER TABLE employees DROP CONSTRAINT DIVISION;
ALTER TABLE orders DROP CONSTRAINT ORDERS_AUTHOR;
ALTER TABLE orders DROP CONSTRAINT ORDERS_EXECUTOR;

DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS divisions;
DROP TABLE  IF EXISTS organization;
DROP TABLE IF EXISTS employees;

DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;



CREATE TABLE organization
(
  id  INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR(255),
  legal_address VARCHAR(255),
  physical_address VARCHAR(255),
  manager_id INTEGER
);

CREATE TABLE employees
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  middle_name VARCHAR(255),
  position VARCHAR(255),
  organization_id INTEGER NOT NULL,
  FOREIGN KEY (organization_id) REFERENCES organization (id) ON DELETE CASCADE
);

CREATE TABLE divisions
(
  id  INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR(255),
  contacts  VARCHAR(255),
  manager_id INTEGER,
  organization_id INTEGER NOT NULL,
  FOREIGN KEY (manager_id) REFERENCES employees (id),
  FOREIGN KEY (organization_id) REFERENCES organization (id) ON DELETE CASCADE
);

CREATE TABLE orders
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  subject     VARCHAR(255),
  author_id   INTEGER NOT NULL,
  executor_id INTEGER NOT NULL,
  deadline    TIMESTAMP,
  controlled  BOOLEAN,
  executed    BOOLEAN,
  text        VARCHAR(255),
  state       VARCHAR(255)
);


ALTER TABLE organization
  ADD CONSTRAINT organization_manager FOREIGN KEY (manager_id) REFERENCES employees (id);

ALTER TABLE employees
  ADD CONSTRAINT division FOREIGN KEY (division_id) REFERENCES divisions (id);

ALTER TABLE orders
  ADD CONSTRAINT orders_author FOREIGN KEY (author_id) REFERENCES employees (id) ON DELETE CASCADE ;

ALTER TABLE orders
  ADD CONSTRAINT orders_executor FOREIGN KEY (executor_id) REFERENCES employees (id) ON DELETE CASCADE ;










