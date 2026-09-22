# Write your MySQL query statement below
SELECT e1.name FROM EMPLOYEE e1
JOIN Employee e2
ON e1.id = e2.managerId
GROUp BY e2.managerId
Having Count(*) >= 5;