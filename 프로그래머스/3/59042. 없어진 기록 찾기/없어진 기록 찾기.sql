-- 코드를 입력하세요
-- inner 조인을 해서 조회되는 id를 찾고 이 내용을 제외한 나머지 동물들의 id를 조회해서 응답을 주면 되는걸까 ?
-- 아니면 ins에서 outer 조인해서 null인 내용과 outer에서 ins를 조인해서 null인 내용을 합치면 되는걸까 ?
SELECT ao.animal_id, ao.name
from animal_outs ao
left join animal_ins ai on ai.animal_id = ao.animal_id
where ai.animal_id IS NULL
;