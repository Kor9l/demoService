alter table client modify `tel_number` long not NULL;
alter table client modify full_name varchar(255) NOT NULL;


alter table technic modify model varchar(255) NOT NULL;


alter table work modify  `title` varchar(255) NOT NULL;



alter table part modify  `title` varchar(255) NOT NULL;

alter table user modify `full_name` varchar(255) NOT NULL;
alter table user modify  `email` varchar(255) NOT NULL;
