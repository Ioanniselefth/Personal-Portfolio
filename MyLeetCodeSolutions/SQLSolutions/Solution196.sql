# 196. Delete Duplicate Emails
# Please write a DELETE statement and DO NOT write a SELECT statement.
DELETE 
    p1 
FROM 
    Person p1, Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id