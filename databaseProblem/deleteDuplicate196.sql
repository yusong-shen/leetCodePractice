/**
Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Id is the primary key column for this table.
For example, after running your query, the above Person table should have the following rows:

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+
**/
-- SELECT 
-- 	Id, Email
-- FROM 
-- 	Person
-- GROUP BY 
-- 	Email
-- HAVING 
-- 	COUNT(Email)>1) AS duplicate;

DELETE FROM
	Person 
LEFT JOIN 
	(SELECT 
	*
	FROM 
		Person 
	GROUP BY 
		Email
	HAVING 
		COUNT(Email)>1) AS duplicate
ON 
	P1.Id = duplicate.Id
WHERE
	duplicate.Id IS NOT NULL;