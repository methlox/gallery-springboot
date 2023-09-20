create table if not exists gallery (
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `file_name` varchar(255),
    `content_type` varchar(255),
    `data` binary large object
)