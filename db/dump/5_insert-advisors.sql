INSERT INTO public."advisor" (id, first_name, last_name, birthdate, email,  hiringdate, specialty)
SELECT gen_random_uuid(), first_name, last_name, to_date(birthdate, 'YYYY-MM-DD'), email, to_date(hiringdate, 'YYYY-MM-DD'), specialty FROM (
    VALUES
     ('Nadia', 'Omar', '1978-08-10', 'nadia.omar@example.com', '2000-04-11', 'Assurance'),
     ('André', 'Moreira', '1991-09-30', 'andre.moreira@example.com', '2000-04-11', 'Placement_Prêt'),
     ('Hiroko', 'Kobayashi', '1987-02-10', 'hiroko.kobayashi@example.com', '2000-04-11', 'immobilier'),
     ('Tariq', 'Choudhury', '1994-04-01', 'tariq.choudhury@example.com', '2000-04-11', 'Crédit_consommation'),
     ('Catarina', 'Santos', '1976-10-20', 'catarina.santos@example.com', '2000-04-11', 'Crédit_consommation'),
     ('Jin', 'Kim', '1990-11-10', 'jin.kim@example.com', '2000-04-11', 'immobilier')

) AS advisors (first_name, last_name, birthdate, email, hiringDate, specialty)
