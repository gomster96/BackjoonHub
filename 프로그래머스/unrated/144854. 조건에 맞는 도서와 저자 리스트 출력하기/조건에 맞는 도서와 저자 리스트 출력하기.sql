-- 코드를 입력하세요
SELECT B.book_id, A.author_name,  DATE_FORMAT(B.published_date, "%Y-%m-%d") as PUBLSHED_DATE
FROM Book B
INNER JOIN AUTHOR A
ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE B.CATEGORY = "경제"
ORDER BY B.published_date ASC;
