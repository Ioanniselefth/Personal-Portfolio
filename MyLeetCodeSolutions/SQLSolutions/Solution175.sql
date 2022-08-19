#175. Combine Two Tables

SELECT firstName, lastName, City, State
FROM Person left join Address
on Person.PersonId = Address.PersonId;