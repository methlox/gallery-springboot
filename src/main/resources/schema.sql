create table if not exists gallery (
    id bigint identity primary key,
    file_name varchar(255)
    content_type varchar(255)
    data binary
)