package com.example.EmployeeAPI;

import com.example.EmployeeAPI.DTO.response.EmployeeDetails;
import com.example.EmployeeAPI.Dao.EmployeeDao;
import com.example.EmployeeAPI.Entity.Employee;
import com.example.EmployeeAPI.Services.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeApiApplicationTests {


	@Mock
	private EmployeeDao employeeDao;

	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;

	@Test void givenPageNo_WhenGetEmployeeRaised_ThenItShouldGetEmployee_ForSpecificPage_FromDatabase(){
		int PAGESIZE =5;
		int pageNo=0;
		Pageable pageable = PageRequest.of(pageNo,PAGESIZE);
		List<Employee> listOfEmployee =new LinkedList<>();
		LocalDate date =LocalDate.now();
		LocalDateTime localDateTime =LocalDateTime.now();

		for (int i=0;i<5;i++) {
			listOfEmployee.add(new Employee(i,"abc"+i, date, localDateTime, localDateTime));
		}

		Page<Employee> pagedListOfEmployee = new PageImpl(listOfEmployee);
		when(employeeDao.findAll(pageable)).thenReturn(pagedListOfEmployee);

		List<EmployeeDetails> employeeDetailsListExpected =new LinkedList<>();
		for (Employee employee : listOfEmployee){
			EmployeeDetails employeeDetails=new EmployeeDetails();
			employeeDetails.seteId(employee.geteId());
			employeeDetails.seteName(employee.geteName());
			employeeDetails.setDateOfJoining(employee.getDateOfJoining());
			employeeDetailsListExpected.add(employeeDetails);
		}
		List<EmployeeDetails> employeeDetailsListActual = employeeServiceImpl.getEmployees(pageNo);

		for(int i=0;i<employeeDetailsListActual.size();i++) {
			assertEquals(employeeDetailsListExpected.get(i).geteId(), employeeDetailsListActual.get(i).geteId());
			assertEquals(employeeDetailsListExpected.get(i).geteName(), employeeDetailsListActual.get(i).geteName());
			assertEquals(employeeDetailsListExpected.get(i).getDateOfJoining(), employeeDetailsListActual.get(i).getDateOfJoining());
		}
	}
	@Test
	public void givenEmployeeDetails_WhenAddEmployeeRaised_ThenItShouldAddEmployee_ToDatabase(){
		long employeeId =1;

		LocalDate date = LocalDate.now();
		LocalDateTime dateTime =LocalDateTime.now();

		com.example.EmployeeAPI.DTO.request.EmployeeDetails employeeDetails =new com.example.EmployeeAPI.DTO.request.EmployeeDetails();
		employeeDetails.seteName("het");
		Employee employee = new Employee(employeeDetails.geteName(),date,dateTime,dateTime);
		employee.seteId(employeeId);

		EmployeeDetails employeeDetailsExpected =new EmployeeDetails();
		employeeDetailsExpected.seteName("het");
		employeeDetailsExpected.seteId(employeeId);
		employeeDetailsExpected.setDateOfJoining(date);

		when(employeeDao.save(any())).thenReturn(employee);

		EmployeeDetails employeeDetailsActual = employeeServiceImpl.addEmployee(employeeDetails);

		assertEquals(employeeDetailsExpected.geteId(),employeeDetailsActual.geteId());
		assertEquals(employeeDetailsExpected.geteName(),employeeDetailsActual.geteName());
		assertEquals(employeeDetailsExpected.getDateOfJoining(),employeeDetailsActual.getDateOfJoining());


	}

	@Test
	public void givenEmpTd_WhenGetEmployeeRaised_ThenItShouldReturnTheEmployeeDetails_FromDatabase(){
		long employeeId =1;

		LocalDate date = LocalDate.now();
		LocalDateTime dateTime =LocalDateTime.now();

		Employee employee = new Employee("het",date,dateTime,dateTime);
		employee.seteId(employeeId);

		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.seteId(employeeId);
		employeeDetails.seteName("het");
		employeeDetails.setDateOfJoining(date);

		when(employeeDao.getById(employeeId)).thenReturn(employee);
		EmployeeDetails actual = employeeServiceImpl.getEmployee(employeeId);
		assertEquals(employeeDetails.geteId(),actual.geteId());
		assertEquals(employeeDetails.geteName(),actual.geteName());
		assertEquals(employeeDetails.getDateOfJoining(),actual.getDateOfJoining());

	}

	@Test
	public void givenNewName_WhenUpdateEmployeeRaise_ThenItShoulBeUpdatedInDatabase(){
		long employeeId =1;
		com.example.EmployeeAPI.DTO.request.EmployeeDetails employeeDetails =new com.example.EmployeeAPI.DTO.request.EmployeeDetails();
		employeeDetails.seteId(1);
		employeeDetails.seteName("abc");

		LocalDate date = LocalDate.now();
		LocalDateTime dateTime =LocalDateTime.now();
		Employee employee = new Employee("het",date,dateTime,dateTime);
		employee.seteId(employeeId);

		ArgumentCaptor<Employee> employee1 = ArgumentCaptor.forClass(Employee.class);

		when(employeeDao.existsById(employeeId)).thenReturn(true);
		when(employeeDao.getById(employeeId)).thenReturn(employee);

		ResponseEntity<String> actual = employeeServiceImpl.updateEmployee(employeeDetails);
		verify(employeeDao,times(1)).save(employee1.capture());
		ResponseEntity<String> expected= ResponseEntity.status(HttpStatus.OK).body("Employee Updated Successfully");

		assertEquals(expected,actual);

	}

	@Test
	public void givenEmployeeId_WhenDeleteRequestRaise_ThenItShouldBeDeleted_FromDatabase(){

		long employeeResignedId=5;
		LocalDate date=LocalDate.now();
		LocalDateTime dateTime=LocalDateTime.now();
		Employee employee=new Employee(employeeResignedId,"het",date,dateTime,dateTime);
		ArgumentCaptor<Long> employeeIdCapturer = ArgumentCaptor.forClass(Long.class);
		when(employeeDao.existsById(employeeResignedId)).thenReturn(true);
		when(employeeDao.getById(employeeResignedId)).thenReturn(employee);

		ResponseEntity<String> actualMessage=employeeServiceImpl.deleteEmployee(employeeResignedId);
		ResponseEntity<String> expectedMessage=ResponseEntity.status(HttpStatus.OK).body("Employee Deleted Successfully");
		verify(employeeDao,times(1)).delete(employee);
		verify(employeeDao,times(1)).getById(employeeIdCapturer.capture());
		assertEquals(employeeResignedId,employeeIdCapturer.getValue());
		assertEquals(expectedMessage, actualMessage);

	}
}