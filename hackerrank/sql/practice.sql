1. Revising the Select Query I
select * from city where countrycode = 'USA' and population > 100000;

2. Revising the Select Query II
select name from city where countrycode = 'USA' and population > 120000;

3. Select All
select * from city;

4. Select By ID
select * from city where id = 1661;

5. Japanese Cities Attributes
select * from city where countrycode = 'JPN';

6. Japanese Cities Names
select name from city where countrycode ='JPN';

7. Weather Observation Station 1
select city, state from station;

8. Weather Observation Station 3
select distinct city from station where id %2 = 0;

9. Weather Observation Station 4
SELECT count(1) - count(distinct CITY) from station;

10. Weather Observation Station 5
(select CITY, length(CITY) from STATION order by length(CITY), CITY limit 1)
UNION
(select CITY, length(CITY) from STATION order by length(CITY) DESC, CITY limit 1);
11. Weather Observation Station 6 -- 1. substring, 2. regexp, 3. LIKE OR
select distinct city from station where city regexp '^[aeiou]';

12. Weather Observation Station 7
select distinct city from station where city regexp '[aeiou]$';

13. Weather Observation Station 8
select distinct city from station where city regexp '^[aeiou].*[aeiou]$';

14. Weather Observation Station 9
select distinct city from station where city regexp '^[^aeiou]';

15. Weather Observation Station 10
select distinct city from station where city regexp '[^aeiou]$';
