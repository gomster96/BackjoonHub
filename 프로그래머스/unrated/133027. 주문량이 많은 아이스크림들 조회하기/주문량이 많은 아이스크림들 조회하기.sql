# 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값, 1~7월까지
# 큰 순서대로 상위 3개의 맛 조회 
SELECT K.FLAVOR as FLAVOR
FROM    (
        SELECT A.FLAVOR, (A.TOTAL_ORDER + B.TOTAL_ORDER) as T
        FROM FIRST_HALF as A
        JOIN (
              SELECT FLAVOR,SUM(TOTAL_ORDER) as TOTAL_ORDER
              FROM JULY
              GROUP BY FLAVOR) as B 
        ON A.FLAVOR = B.FLAVOR) as K
ORDER BY K.T desc 
limit 3
