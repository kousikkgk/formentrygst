package com.kousik.formentrygst.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kousik.formentrygst.dao.StudentDao;
import com.kousik.formentrygst.model.Student;

@RestController
public class StudentController {
	@Autowired
	private StudentDao studentDao;

	List<Student> bookStore=new ArrayList<>();
	
//	@PostMapping("/submitDynamicForm")
//	public ResponseEntity<Object> addBook(@RequestBody Student student){
//		bookStore.add(student);
//		ServiceResponse<Student> response=new ServiceResponse<Student>("success",student);
//		return new ResponseEntity<Object>(response,HttpStatus.OK);
//	}
	
	@PostMapping("/submitDynamicForm")
	@ResponseBody
	public List<Student> postSeries(@RequestBody List<Student> myObjects) {
	   // myObjects.forEach(System.out::println);
	    // Handle myObjects
		for(Student obj:myObjects) {
			System.out.println(obj.getAge());
			System.out.println(obj.getName());
			if(obj.getAge()!=0 || obj.getName()!=null) {
				studentDao.save(obj);
			} 
		}
	    //System.out.println(myObjects);
//	    studentDao.saveAll(myObjects);
	    return myObjects;
	}
}
