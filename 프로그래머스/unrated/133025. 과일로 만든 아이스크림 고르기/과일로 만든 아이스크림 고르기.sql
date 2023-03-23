-- 코드를 입력하세요
# 총 주문량이 3000보다 크고
# 주성분이 과일인 아이스크림
# 총 주문량이 큰 순서대로 내림차순 
SELECT f.flavor as FLAVOR
FROM FIRST_HALF as f
LEFT JOIN ICECREAM_INFO as i 
ON f.flavor = i.flavor
WHERE f.total_order > 3000 
AND i.ingredient_type = 'fruit_based'
ORDER BY f.total_order desc