package webapp.service;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import webapp.dao.impl.MockDeptDao;
import webapp.exception.DeptNotFoundException;
import webapp.model.Dept;
import webapp.model.Emp;
import webapp.service.DeptInfoService;
import webapp.util.EmployeeDataSource;

// JUnit

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/webapp/spring/beans.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptInfoServiceTest {
	static Logger log = Logger.getLogger(DeptInfoServiceTest.class);
	
	@Autowired
	ApplicationContext factory;
	
	@Test
	public void test1_GetDeptInfo() {
		log.info("###@@@ testDeptInfoService()");
		
		DeptInfoService service = factory.getBean(DeptInfoService.class);

		Dept dept = service.getDeptinfo(10);
			
		assertNotNull(dept);
		log.info("deptno = " + dept.getDeptno());
		log.info("dname = " + dept.getDname());
		log.info("loc = " + dept.getLoc());

	}
	
	@Test
	public void test2_GetDeptInfoWithEmps() {
		
		log.info("###@@@ testGetDeptInfoWithEmps()");
		
		DeptInfoService service = factory.getBean(DeptInfoService.class);

		Dept dept = service.getDeptInfoWithEmps(10);
			
		assertNotNull(dept);
		log.info(dept.getDeptno() + " " + dept.getDname());
		
		List<Emp> emps = dept.getEmps(); 
		
		if(emps != null) {
			for(Emp e : emps) {
				log.info(e.getEmpno() + " " + e.getEname());
			}
		}

	}

	@Test
	public void test3_GetDeptInfoAll() {
	
		log.info("###@@@ testGetDeptInfoAll()");
		
		DeptInfoService service = factory.getBean(DeptInfoService.class);
		
		List<Dept> list = service.getDeptInfoAll();
		
		assertNotNull(list);
		
		for(Dept d : list) {
			log.info(d.getDeptno() + ", " + d.getDname()+ ", " + d.getLoc());
		}
	}
	
	@Test
	public void test4_GetDeptInfoAllWithEmps() {
	
		log.info("###@@@ testGetDeptInfoAllWithEmps()");
		
		DeptInfoService service = factory.getBean(DeptInfoService.class);
		
		List<Dept> list = service.getDeptInfoAllWithEmps();
		
		assertNotNull(list);
		
		for(Dept d : list) {
			log.info(d.getDeptno() + ", " + d.getDname()+ ", " + d.getLoc());
			for(Emp e : d.getEmps())
				log.info(e.getEmpno() + ", " + e.getEname() + ", " + e.getJob());
		}
	}
	

}
