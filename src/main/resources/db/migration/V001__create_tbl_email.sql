CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE TBL_EMAIL (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    destinatario VARCHAR(255),
    assunto VARCHAR(255),
    corpo TEXT,
    date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50)
);
