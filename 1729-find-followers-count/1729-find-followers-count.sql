# Write your MySQL query statement below
SELECT DISTINCT user_id,
        COUNT(follower_id) AS followers_count
FROM Followers 
Group By user_id
ORDER BY user_id;