/*
    Permite a criação de UUID
*/

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

SELECT UUID_GENERATE_V4();