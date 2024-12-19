INSERT INTO public."bankadvisor" (id, first_name, last_name, birthdate, email,  hiring_date)
SELECT gen_random_uuid(), first_name, last_name, to_date(birthdate, 'YYYY-MM-DD'), email, to_date(hiring_date, 'YYYY-MM-DD') FROM (
    VALUES
     ('Nadia', 'Omar', '1978-08-10', 'nadia.omar@example.com', '2000-04-11'),
     ('André', 'Moreira', '1991-09-30', 'andre.moreira@example.com', '2000-04-11'),
     ('Hiroko', 'Kobayashi', '1987-02-10', 'hiroko.kobayashi@example.com', '2000-04-11'),
     ('Tariq', 'Choudhury', '1994-04-01', 'tariq.choudhury@example.com', '2000-04-11'),
     ('Catarina', 'Santos', '1976-10-20', 'catarina.santos@example.com', '2000-04-11'),
     ('Jin', 'Kim', '1990-11-10', 'jin.kim@example.com', '2000-04-11')


) AS bankadvisors (first_name, last_name, birthdate, email, hiring_date)
