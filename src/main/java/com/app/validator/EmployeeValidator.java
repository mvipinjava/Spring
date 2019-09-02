package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clz) {
		return Employee.class.equals(clz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee e=(Employee)target;
		
		if(!Pattern.matches("[A-Za-z]{2,8}", e.getEmpName())) {
			errors.rejectValue("empName", null,"Pleasec enter valid name");
		}
		
		if(e.getEmpSal()==null || e.getEmpSal()<=0.0) {
			errors.rejectValue("empSal", null,"Pleasec enter valid Salary");
		}
		
		//NULL,EMPTY, NON SPACE CHARS
		if(!StringUtils.hasText(e.getEmpDept())) {
			errors.rejectValue("empDept", null,"Pleasec choose one Dept");
		}
		
	}

}


