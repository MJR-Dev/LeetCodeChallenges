/*employee [ id, name, age, salary, deptid]			
Write a SQL query to list all employees who have max salary in each dept
Company Name: CDK Global*/
		
select e1.id, e1.name, e1.deptid, e1.salary from employee e1 where (deptid,salary) in (
	select deptid, max(salary) from employee group by deptid order by salary desc);
	
