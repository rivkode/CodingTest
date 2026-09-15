-- 코드를 입력하세요
SELECT fd.product_id as PRODUCT_ID, fd.product_name as PRODUCT_NAME, sum(amount*price)  as TOTAL_SALES
from food_product fd
join food_order fo on fo.product_id = fd.product_id
where fo.PRODUCE_DATE >= '2022-05-01' and fo.PRODUCE_DATE < '2022-06-01'
group by product_id
order by total_sales desc, product_id asc