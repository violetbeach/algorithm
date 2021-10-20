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

16. Weather Observation Station 11
select distinct city from station where city regexp '^[^aeiou]|[^aeiou]$'

17. Weather Observation Station 12
select distinct city from station where city regexp '^[^aeiou].*[^aeiou]$'

18. Higher Than 75 Marks
select name from students where marks>75 order by right(name, 3), id;
-- select name from students where marks>75 order by substring(name, length(name)-2, 3), id;

19. Employee Names
select name from employee order by name;

20. Employee Salaries
select name from employee where salary > 2000 and months < 10;

21. Top Earners
select max(salary*months), count(1) from employee group by salary * months order by salary * months desc limit 1;

22. Weather Observation Station 2
select round(sum(lat_n), 2), round(sum(long_w), 2) from station;

23. Weather Observation Station 13
select truncate(sum(lat_n), 4) from station where lat_n between 38.7880 and 137.2345;

24. Weather Observation Station 14
select truncate(max(lat_n), 4) from station where lat_n < 137.2345;

25. Weather Observation Station 15
select round(long_w, 4) from station where lat_n < 137.2345 order by lat_n desc limit 1;


26. Weather Observation Station 16
select round(min(lat_n), 4) from station where lat_n > 38.7780;

27. Type of Triangle
select 
case
    when A = B and B = C then 'Equilateral'
    when A >= B+C or C >= A+B or B >= A+C then 'Not A Triangle'
    when A = B or A = C OR B = C then 'Isosceles'
    else 'Scalene'
end
from triangles;

