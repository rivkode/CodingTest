-- 코드를 입력하세요

SELECT j.flavor
from july j
join first_half f on f.flavor = j.flavor
group by j.flavor
order by sum(j.total_order) + sum(f.total_order) DESC
limit 3

# SELECT A.FLAVOR
# FROM FIRST_HALF A
#     INNER JOIN JULY B ON A.FLAVOR = B.FLAVOR 
# GROUP BY FLAVOR
# ORDER BY SUM(B.TOTAL_ORDER)+ SUM(A.TOTAL_ORDER) DESC
# LIMIT 3;