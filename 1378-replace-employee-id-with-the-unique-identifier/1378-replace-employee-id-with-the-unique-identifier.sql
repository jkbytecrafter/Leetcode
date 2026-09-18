# Write your MySQL query statement below
SELECT eu.unique_id,e.name
FROM Employees e
Left JOIN EmployeeUNI eu
ON e.id=eu.id;