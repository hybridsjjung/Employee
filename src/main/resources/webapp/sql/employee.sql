// *Join 방법*
select * 
from dept d, emp e
where d.deptno = e.deptno 
and d.deptno = 40;

// = > inner join
select * 
from dept d inner join emp e
on d.deptno = e.deptno
where d.deptno = 40;

// => outer join
select * 
from dept d left join emp e
on d.deptno = e.deptno
where d.deptno = 40;


select * from dept where deptno = 10;

insert into dept (deptno, dname, loc) values (50, '총무부', 'seoul');
insert into dept values (60, '인사부', 'incheon');
insert into dept (deptno, dname) values (70, '홍보부');

delete from dept where deptno > 40;

rollback
commit

select * from dept;