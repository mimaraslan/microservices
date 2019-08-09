package com.mimaraslan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mimaraslan.model.Student;

@RestController
@RequestMapping("/api/v2")
public class StudentController {
 
    private static Map<String, List<Student>> schoolDB ;
 
    static {
    	schoolDB = new HashMap<String, List<Student>>();
 
        List<Student> lst = new ArrayList<Student>();
        
        Student std = new Student("Lena", "PHD");
        lst.add(std);
        
        std = new Student("Katerina", "PHD");
        lst.add(std);
 
        schoolDB.put("A", lst);
 
        lst = new ArrayList<Student>();
        
        std = new Student("Olga", "PHD");
        lst.add(std);
        
        std = new Student("Yulya", "Postgraduate");
        lst.add(std);
        
        std = new Student("Rita", "Year VI");
        lst.add(std);
 
        schoolDB.put("B", lst);
 
    }

 // http://localhost:8081/api/v2/student/A
 // http://localhost:8081/api/v2/student/B   
 // @RequestMapping(value = "/student/{schoolname}", method = RequestMethod.GET)
    @GetMapping("/student/{schoolname}")
    public List<Student> getStudents(@PathVariable String schoolname) {
        System.out.println("Getting Student details for " + schoolname);
 
        List<Student> studentList = schoolDB.get(schoolname);
        if (studentList == null) {
            studentList = new ArrayList<Student>();
            Student std = new Student("Not Found", "N/A");
            studentList.add(std);
        }
        return studentList;
    }
}