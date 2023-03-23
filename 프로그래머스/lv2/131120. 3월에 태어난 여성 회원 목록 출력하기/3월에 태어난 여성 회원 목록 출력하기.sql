# 생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일을 조회 
SELECT MEMBER_ID, MEMBER_NAME, GENDER, LEFT(DATE_OF_BIRTH, 10)
from member_profile
where date_of_birth like '_____03___'
AND gender = 'W'
AND tlno is NOT NULL
ORDER BY member_id asc


