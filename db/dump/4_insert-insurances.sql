INSERT INTO public."insurance" (name)
SELECT name FROM (
    VALUES
        (name 'assurance habitation'),
        (name 'assurance santé'),
        (name 'assurance vie'),
        (name 'assurance automobile'),
        (name 'assurance scolaire'),
        (name 'responsabilité civile personnelle'),
        (name 'responsabilité civile professionnelle')
) AS insurances (name);
