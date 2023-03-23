# REST_INFO, REST_REVIEW 테이블에서 
#  서울에 위치한 식당들의
# 식당 ID, 이름, 음식종류, 즐겨찾기 수, 주소, 리뷰 평균 
# 리뷰 평균은 소수점 세번째 자리에서 반올림
# 결과는 리뷰 평균점수 기준으로 내림차순 정렬, 평균점수가 같으면 즐겨찾기수로 내림차순 
SELECT A.REST_ID, A.REST_NAME, A.food_type, A.favorites, A.address, ROUND(AVG(B.review_score), 2) as SCORE
FROM REST_INFO as A
JOIN REST_REVIEW B ON A.REST_ID = B.REST_ID
GROUP BY A.REST_ID
HAVING A.ADDRESS LIKE '서울%'
ORDER BY SCORE DESC, A.FAVORITES DESC

