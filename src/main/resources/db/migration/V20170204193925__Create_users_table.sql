-- For H2 Database
create table users (
  id bigserial not null primary key,
  name varchar(512) not null,
  age int not null,
  description varchar(140),
  created_at timestamp not null,
  updated_at timestamp not null
)
