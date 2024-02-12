-- DATE_FORMAT(date, format) 이란
-- 여기서 date는 포맷을 적용하려는 날짜이며, format은 원하는 날짜 형식을 지정합니다.
-- 예를 들어, '%Y-%m-%d' 형식은 'YYYY-MM-DD'로 날짜를 표시합니다.
-- NULL을 제외하기 위해서는 IS NOT NULL을 사용하여 NULL 을 가지는 행을 제외합니다.
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE MONTH(DATE_OF_BIRTH) = 3 AND TLNO IS NOT NULL AND GENDER = 'w'
ORDER BY MEMBER_ID;