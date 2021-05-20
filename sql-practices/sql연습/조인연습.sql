-- inner join

-- 예제1
-- employees 테이블과 titles 테이블을 join하여 
-- 직원의 이름과 직책을 모두 출력 하세요.

select a.emp_no, a.first_name, b.title
  from employees a, titles b
 where a.emp_no = b.emp_no; -- join condition 

-- 예제2
-- employees 테이블과 titles 테이블를 join하여 직원의 이름과 직책을 출력하되 
-- 여성 엔지니어만 출력하세요.
select a.emp_no, a.first_name, b.title, a.gender
  from employees a, titles b
 where a.emp_no = b.emp_no   -- join cond1
   and a.gender = 'F'        -- row-select cond1
   and b.title = 'engineer'; -- row-select cond2

--   
-- ANSI / ISO SQL1999 JOIN 표준 문법
--
-- 1) natural join
-- 두 테이블에 공통 컬럼이 있으면 별다른 조건없이 묵시적으로 조인됨
-- 쓸일이 없음
      select a.first_name, b.title 
        from employees a
natural join titles b;
-- on a.emp_no = b.emp_no; 생략

-- 2) join ~ using
select a.first_name, b.title 
  from employees a
  join titles b using (emp_no);

-- 3) join ~ on
select a.first_name, b.title 
  from employees a
  join titles b on a.emp_no = b.emp_no;

-- outer join
-- insert into dept values(null, '총무');
-- insert into dept values(null, '개발');
-- insert into dept values(null, '영업');
-- insert into dept values(null, '기획');
select * from dept;
-- insert into emp values(null, '둘리', 1);
-- insert into emp values(null, '마이콜', 2);
-- insert into emp values(null, '또치', 3);
-- insert into emp values(null, '길동', null);
select * from emp;

   select a.name as '이름', ifnull(b.name, '없음') as '부서' 
     from emp a
left join dept b
       on a.dept_no = b.no;
  
    select a.name, b.name 
      from emp a
right join dept b
        on a.dept_no = b.no;

-- 실습문제 1
-- 현재 회사 상황을 반영한 직원별 근무부서를 
-- 사번, 직원 전체이름, 근무 부서 형태로 출력해 보세요.
select a.emp_no, a.first_name, c.dept_name
  from employees a, 
       dept_emp b,   
       departments c
 where a.emp_no = b.emp_no
   and b.dept_no = c.dept_no
   and b.to_date = '9999-01-01';
  
-- 실습문제 2: 
-- 현재 회사에서 지급되고 있는 급여체계를 반영한 결과를 출력하세요.
-- 사번,  전체이름, 연봉  이런 형태로 출력하세요.    
select a.emp_no, a.first_name, b.salary
  from employees a, salaries b
 where a.emp_no = b.emp_no
   and b.to_date = '9999-01-01';





