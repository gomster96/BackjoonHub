# 아직 입양을 못 간 동물 중
# 가장 오래 보호소에 있었던 
# 3마리의 이름, 보호시작일
# 보호시작일로 정렬 
SELECT A.name, A.datetime
FROM ANIMAL_INS as A
LEFT JOIN ANIMAL_OUTS as B ON A.animal_id = B.animal_id
WHERE B.animal_id is NULL
ORDER BY A.datetime
limit 3