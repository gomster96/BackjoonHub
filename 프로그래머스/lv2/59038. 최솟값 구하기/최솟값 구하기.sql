-- 코드를 입력하세요
SELECT A.DATETIME as 시간
FROM ANIMAL_INS as A
WHERE A.DATETIME = (SELECT MIN(DATETIME) FROM ANIMAL_INS)