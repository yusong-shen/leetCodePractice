# Employees Earning More Than Their Managers
# The Employee table holds all employees including their managers. 
# Every employee has an Id, and there is also a column for the manager Id.
/**
+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+
**/
# inner join
SELECT E.name 
	FROM Employee E JOIN Employee M ON (E.ManagerId = M.Id )
		WHERE E.Salary > M.Salary;
