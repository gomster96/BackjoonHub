-- 코드를 입력하세요
# 가격이 제일 비싼 식품의 식품 ID, 식품 이름, 식품 코드, 식품 분류, 식품 가격으 조회
SELECT * 
FROM FOOD_PRODUCT 
WHERE PRICE = 
(SELECT MAX(PRICE) PRICE FROM FOOD_PRODUCT);