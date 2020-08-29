
create table project (
    id SERIAL Primary Key,
    title Varchar not null Unique
);

create Table commit_history (
    commit_id Varchar Primary Key,
    project_id int not null,
    commiter Varchar,
    build_success BOOLEAN,
    test_success BOOLEAN,
    auto_push_success BOOLEAN,
    message varchar,
    CONSTRAINT fk_project
      FOREIGN KEY(project_id) 
	  REFERENCES project(id)
);

