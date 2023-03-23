-- 코드를 입력하세요
# 이름이 NULL이면 집계하지 않음
# 동물보호소에 들어온 동물의 이름이 얼마인지 
SELECT count(DISTINCT A.NAME) as count
FROM ANIMAL_INS as A
WHERE A.NAME IS NOT NULL