# Write your MySQL query statement below
SELECT query_name,
        Round((SUM(rating/position) / COUNT(*)),2) as quality,
        Round(((COUNT(CASE WHEN rating < 3 THEN 1 END) / COUNT(*) ) * 100),2) as poor_query_percentage
FROM Queries
Group By query_name
Order By query_name;