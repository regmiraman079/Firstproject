CREATE TABLE artist (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    href VARCHAR(255),
    spotify_url VARCHAR(255),
    followers INTEGER,
    popularity INTEGER,
    type VARCHAR(100),
    uri VARCHAR(255)
);
----------------------------------------------
CREATE TABLE genres (
    id BIGSERIAL PRIMARY KEY,
    artist_id VARCHAR(255),
    genre VARCHAR(255)
);
-----------------------------------------------
CREATE TABLE images (
    id BIGSERIAL PRIMARY KEY,
    artist_id VARCHAR(255),
    url VARCHAR(255),
    height INTEGER,
    width INTEGER
);
--------------------------------------------------
CREATE TABLE search_metadata (
    id BIGSERIAL PRIMARY KEY,
    href VARCHAR(255),
    limit_value INTEGER,
    next VARCHAR(255),
    offset_value INTEGER,
    previous VARCHAR(255),
    total INTEGER
);
