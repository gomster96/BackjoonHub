# 공간을 둘 이상 등록한 사람 -> 헤비유저
# 헤비유저의 공간 정보
# 아이디 순 
SELECT ID, NAME, HOST_ID
FROM PLACES 
WHERE HOST_ID in (
    SELECT HOST_ID
    FROM PLACES 
    GROUP BY HOST_ID
    HAVING COUNT(HOST_ID) > 1
)
ORDER BY ID