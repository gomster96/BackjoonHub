# BOOK, BOOK_SALE
# 2022년 1월의 카테고리 별 도서 판매량 합산
# CATEGORY, 총 판메량 리스트를 출력
# 카테고리명으로 오름차순 
SELECT A.category, SUM(B.SALES)
FROM BOOK as A
JOIN BOOK_SALES as B ON A.book_id = B.book_id
WHERE DATE_FORMAT(B.sales_date, "%Y-%m") = '2022-01'
GROUP BY A.category
ORDER BY A.category 