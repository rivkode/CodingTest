-- 코드를 작성해주세요 
-- 분화 시작 부모, 분화 나온 개체 자식 개체
SELECT a.id, count(b.parent_id) as child_count 
FROM ecoli_data a
left join ecoli_data b on a.id = b.parent_id
group by a.id
order by a.id
