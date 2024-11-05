SELECT CLIENT_ID, COUNT(*) AS project_count
FROM project
GROUP BY CLIENT_ID
HAVING COUNT(*) = (
    SELECT MAX(project_count)
    FROM (
        SELECT CLIENT_ID, COUNT(*) AS project_count
        FROM project
        GROUP BY CLIENT_ID
    ) AS client_project_counts
);