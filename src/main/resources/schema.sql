CREATE TABLE task_status (
                             id BIGINT PRIMARY KEY,
                             name VARCHAR(50) NOT NULL
);

CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL
);

CREATE TABLE tasks (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       description TEXT,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP,
                       status_id BIGINT,
                       user_id BIGINT,
                       CONSTRAINT fk_task_status FOREIGN KEY (status_id) REFERENCES task_status(id),
                       CONSTRAINT fk_task_user FOREIGN KEY (user_id) REFERENCES users(id)
);