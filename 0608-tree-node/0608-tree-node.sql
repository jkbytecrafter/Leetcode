# Write your MySQL query statement below
SELECT id,
        CASE 
            WHEN p_id IS NULL THEN 'Root'
            WHEN id NOT IN (SELECT DISTINCT p_id FROM Tree Where p_id IS NOT NULL) THEN 'Leaf'
            ELSE 'Inner'
        END as type
FROM Tree;