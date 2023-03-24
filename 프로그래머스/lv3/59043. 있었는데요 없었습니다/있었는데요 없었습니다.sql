# 동물의 입양일이 잘못됌
# 보호시작일보다, 입양일이 더 빠른 동물의 
# 아이디, 이름 조회
# 정렬 보호시작일 
SELECT A.animal_id, a.name
FROM ANIMAL_INS as A
JOIN ANIMAL_OUTS as B ON A.animal_id = B.animal_id
WHERE A.datetime > b.datetime
ORDER BY A.datetime