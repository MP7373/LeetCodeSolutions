SELECT
(
    SELECT Salary
    FROM
    (
        SELECT Salary, ROW_NUMBER() OVER (ORDER BY Salary DESC) as Row
        FROM
        (
            SELECT DISTINCT Salary FROM Employee
        ) as s
    ) AS SecondHighestSalary
    WHERE Row = 2
) as SecondHighestSalary