WITH project_durations AS (
    SELECT ID,
           MONTH(START_DATE) AS start_month,
           YEAR(START_DATE) AS start_year,
           MONTH(FINISH_DATE) AS finish_month,
           YEAR(FINISH_DATE) AS finish_year
    FROM project
),
project_months AS (
    SELECT ID,
           (finish_year - start_year) * 12 + (finish_month - start_month) AS duration_months
    FROM project_durations
)
SELECT p.ID, p.CLIENT_ID, p.START_DATE, p.FINISH_DATE
FROM project p
JOIN project_months pm ON p.ID = pm.ID
WHERE pm.duration_months = (
    SELECT MAX(duration_months)
    FROM project_months
);
