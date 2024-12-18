
DROP TABLE if exists public.account CASCADE;
DROP TABLE if exists public.client CASCADE;
DROP TABLE if exists public.insurance CASCADE;

/* TODO : ajouter la création de la table "client" */

-- Création de la table "client"
CREATE TABLE client (
    id uuid PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    birthdate DATE NOT NULL
);
-- Création de la table "account"
CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    client_id uuid NOT NULL,
    balance DECIMAL(15,2) NOT NULL DEFAULT 0.00,
    creationtime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active BOOLEAN NOT NULL DEFAULT TRUE,

    -- Définition de la contrainte de clé étrangère
    CONSTRAINT fk_client FOREIGN KEY (client_id)
        REFERENCES public.client(id)
        ON DELETE CASCADE  -- Si un client est supprimé, supprimer tous ses comptes
);

CREATE TABLE insurance (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE client_insurance (
    client_id uuid,
    insurance_id INT,
    PRIMARY KEY (client_id, insurance_id),
    FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE,
    FOREIGN KEY (insurance_id) REFERENCES insurance(id) ON DELETE CASCADE
);

CREATE TABLE advisor (
    id uuid PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    birthdate DATE NOT NULL,
    hiringDate DATE NOT NULL,
    specialty VARCHAR(50) NOT NULL
)

