# 들어올떄는 중성화 안됌
# 나갈떄는 중성화 된 
SELECT A.animal_id, A.animal_type, A.name
FROM ANIMAL_OUTS as A
JOIN ANIMAL_INS as B ON A.animal_id = B.animal_id
WHERE A.sex_upon_outcome = 'Neutered Male' AND B.sex_upon_intake = 'Intact Male'
OR A.sex_upon_outcome = 'Spayed Female' AND B.sex_upon_intake = 'Intact Female'
ORDER BY A.animal_id