
create table project {
    id SERIAL Primary Key,
    title Varchar not null,
}

create Table commit_history {
    commit_id Varchar Primary Key,
    project_id int not null,
    user Varchar,
    build_success bit,
    test_success bit,
    CONSTRAINT fk_project
      FOREIGN KEY(project_id) 
	  REFERENCES project(id)
}

