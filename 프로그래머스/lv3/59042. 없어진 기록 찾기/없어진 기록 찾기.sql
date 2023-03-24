# 입양을 간 기록 O 보호소에 들어온 기록 X인 
# 동물의 ID, 이름
# 정렬 ID
SELECT A.animal_id, A.name
FROM ANIMAL_OUTS as A
WHERE A.animal_id NOT IN 
                        (
                        SELECT ANIMAL_ID
                        FROM ANIMAL_INS
                        # SELECT A.animal_id 
                        # SELECT *
                        # FROM ANIMAL_INS as A
                        # JOIN ANIMAL_OUTS as B ON A.animal_id = B.animal_id
                        )