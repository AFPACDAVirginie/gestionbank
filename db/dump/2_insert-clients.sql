-- Génération des 100 utilisateurs
INSERT INTO public."client" (first_name, last_name, birthdate, id, email, bankadvisor_id)
SELECT clients.first_name, clients.last_name, to_date(clients.birthdate, 'YYYY-MM-DD'), gen_random_uuid(), clients.email, bankadvisor.id AS bankadvisor_id FROM (
    VALUES
        ('John', 'Smith', '1990-05-15', 'john.smith@example.com'),
        ('Emma', 'Johnson', '1985-12-20', 'emma.johnson@example.com'),
        ('Ahmed', 'Ali', '1978-07-10', 'ahmed.ali@example.com'),
        ('Maria', 'Garcia', '1995-02-28', 'maria.garcia@example.com'),
        ('Hiroshi', 'Sato', '1983-09-08', 'hiroshi.sato@example.com'),
        ('Sophie', 'Dubois', '1992-04-03', 'sophie.dubois@example.com'),
        ('Juan', 'Martinez', '1989-10-12', 'juan.martinez@example.com'),
        ('Ling', 'Li', '1976-06-25', 'ling.li@example.com'),
        ('Yuki', 'Tanaka', '1980-03-17', 'yuki.tanaka@example.com'),
        ('Fatima', 'Khan', '1998-08-05', 'fatima.khan@example.com'),
        ('Mikhail', 'Ivanov', '1991-11-30', 'mikhail.ivanov@example.com'),
        ('Ana', 'Silva', '1987-01-22', 'ana.silva@example.com'),
        ('Andrea', 'Ricci', '1984-07-08', 'andrea.ricci@example.com'),
        ('Muhammad', 'Abdullah', '1993-04-14', 'muhammad.abdullah@example.com'),
        ('Javier', 'Gonzalez', '1979-09-02', 'javier.gonzalez@example.com'),
        ('Fatemeh', 'Mohammadi', '1986-05-18', 'fatemeh.mohammadi@example.com'),
        ('Hans', 'Schmidt', '1990-02-10', 'hans.schmidt@example.com'),
        ('Youssef', 'El Amir', '1982-12-24', 'youssef.elamir@example.com'),
        ('Sofia', 'Kowalski', '1996-10-01', 'sofia.kowalski@example.com'),
        ('Ravi', 'Patel', '1988-03-12', 'ravi.patel@example.com'),
        ('Nadia', 'Popescu', '1975-08-20', 'nadia.popescu@example.com'),
        ('Santiago', 'Lopez', '1981-01-07', 'santiago.lopez@example.com'),
        ('Agnieszka', 'Nowak', '1994-06-16', 'agnieszka.nowak@example.com'),
        ('Chen', 'Wang', '1983-11-28', 'chen.wang@example.com'),
        ('Alessandro', 'Rossi', '1997-09-14', 'alessandro.rossi@example.com'),
        ('Elena', 'Novak', '1989-04-02', 'elena.novak@example.com'),
        ('Abdul', 'Ahmed', '1984-12-10', 'abdul.ahmed@example.com'),
        ('Giovanni', 'Ferrari', '1992-07-22', 'giovanni.ferrari@example.com'),
        ('Natasha', 'Ivanova', '1978-03-05', 'natasha.ivanova@example.com'),
        ('Ali', 'Al-Farsi', '1985-10-13', 'ali.alfarsi@example.com'),
        ('Seung', 'Park', '1990-05-25', 'seung.park@example.com'),
        ('Léa', 'Dupont', '1987-01-03', 'lea.dupont@example.com'),
        ('Igor', 'Vasiliev', '1996-08-11', 'igor.vasiliev@example.com'),
        ('Yasmin', 'Khalifa', '1980-04-19', 'yasmin.khalifa@example.com'),
        ('Katarzyna', 'Kowalczyk', '1993-12-27', 'katarzyna.kowalczyk@example.com'),
        ('Dong', 'Nguyen', '1995-10-30', 'dong.nguyen@example.com'),
        ('Amir', 'Elias', '1981-02-15', 'amir.elias@example.com'),
        ('Katja', 'Laine', '1977-06-05', 'katja.laine@example.com'),
        ('Rajesh', 'Sharma', '1994-07-20', 'rajesh.sharma@example.com'),
        ('Ana', 'Sousa', '1988-09-10', 'ana.sousa@example.com'),
        ('Giorgos', 'Papadopoulos', '1983-03-25', 'giorgos.papadopoulos@example.com'),
        ('Maya', 'Patil', '1990-12-05', 'maya.patil@example.com'),
        ('Fiona', 'Murphy', '1976-04-15', 'fiona.murphy@example.com'),
        ('Santiago', 'Hernandez', '1997-05-01', 'santiago.hernandez@example.com'),
        ('Yuki', 'Takahashi', '1982-08-21', 'yuki.takahashi@example.com'),
        ('Irina', 'Kuznetsova', '1996-01-25', 'irina.kuznetsova@example.com'),
        ('José', 'Gutierrez', '1979-11-15', 'jose.gutierrez@example.com'),
        ('Amira', 'Said', '1985-03-05', 'amira.said@example.com'),
        ('Federico', 'Romano', '1992-06-20', 'federico.romano@example.com')
) AS clients (first_name, last_name, birthdate, email)

JOIN public.bankadvisor AS bankadvisor ON TRUE
ORDER BY RANDOM()
LIMIT 100
ON CONFLICT(email) DO NOTHING;

