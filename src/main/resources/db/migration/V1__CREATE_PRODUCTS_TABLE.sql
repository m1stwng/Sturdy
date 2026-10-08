CREATE TABLE products
(
    id          UUID PRIMARY KEY      DEFAULT GEN_RANDOM_UUID(),

    sku         VARCHAR(50)  NOT NULL UNIQUE CHECK (sku = UPPER(sku)),
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(2500),
    category    VARCHAR(255) NOT NULL,
    subcategory VARCHAR(255),

    active      BOOLEAN      NOT NULL DEFAULT TRUE
);
