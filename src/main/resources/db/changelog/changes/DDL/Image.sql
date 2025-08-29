CREATE TABLE images (
    id BIGSERIAL PRIMARY KEY,
    artist_id VARCHAR(255),
    url VARCHAR(255),
    height INTEGER,
    width INTEGER
);
