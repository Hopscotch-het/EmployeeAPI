package com.example.EmployeeAPI;

import com.example.EmployeeAPI.Dao.EmployeeDao;
import com.example.EmployeeAPI.Entity.Employee;
import com.example.EmployeeAPI.Services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class EmployeeApiApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Mock
	private EmployeeDao employeeDao;

	@InjectMocks
	private EmployeeService employeeService;

	@Test
	public void create(){
//		assertNotNull(employeeService.addEmployee("t"));
	}
//
//	@Test
//	public void givenEmployeeId_WhenDeleteRequestRaise_ThenItWouldBeDeletedFrom Database(){
//		long employeeResigned=5;
//		employeeService.deleteEmployee(employeeResigned);
//	}

}
