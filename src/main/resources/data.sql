
INSERT INTO task_status (id, name) VALUES (1, 'PENDING');
INSERT INTO task_status (id, name) VALUES (2, 'IN_PROGRESS');
INSERT INTO task_status (id, name) VALUES (3, 'COMPLETED');

-- USERS
INSERT INTO users (id, username, password) VALUES
    (1, 'raul', '$2a$10$/VH/ic1qjosjo8Ivcrj6iOmjZCoKJmkeGU9g.eY.q1f9E7RAbZ5SW');


INSERT INTO tasks (id, title, description, created_at, updated_at, status_id, user_id) VALUES
    (1, 'Tarea inicial', 'Primera tarea demo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, 1);