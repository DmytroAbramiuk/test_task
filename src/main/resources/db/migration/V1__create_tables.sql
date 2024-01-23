CREATE TABLE customers (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    created BIGINT,
    updated BIGINT,
    full_name VARCHAR(50) CHECK (LENGTH(full_name) BETWEEN 2 AND 50),
    email VARCHAR(100) UNIQUE CHECK (LENGTH(email) BETWEEN 2 AND 100 AND email LIKE '%@%'),
    phone VARCHAR(14) CHECK ((LENGTH(phone) BETWEEN 6 AND 14) OR phone IS NULL),
    is_active BOOLEAN
);