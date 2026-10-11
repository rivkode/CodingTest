-- 코드를 입력하세요
SELECT ao.animal_id, ao.animal_type, ao.name
from animal_ins ai
join animal_outs ao on ai.animal_id = ao.animal_id
where ao.sex_upon_outcome = case
when ai.sex_upon_intake = 'Intact Female' then 'Spayed Female'
when ai.sex_upon_intake = 'Intact Male' then 'Neutered Male'
end;