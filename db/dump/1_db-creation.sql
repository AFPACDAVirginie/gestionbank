
DROP TABLE if exists public.account CASCADE;
DROP TABLE if exists public.client CASCADE;

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