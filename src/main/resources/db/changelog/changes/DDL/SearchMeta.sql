CREATE TABLE search_metadata (
    id BIGSERIAL PRIMARY KEY,
    href VARCHAR(255),
    limit_value INTEGER,
    next VARCHAR(255),
    offset_value INTEGER,
    previous VARCHAR(255),
    total INTEGER
);
