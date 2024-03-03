CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     username VARCHAR(50) NOT NULL,
                                     password VARCHAR(100) NOT NULL,
                                     enabled BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS authorities (
                                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           username VARCHAR(50) NOT NULL,
                                           authority VARCHAR(50) NOT NULL
);
