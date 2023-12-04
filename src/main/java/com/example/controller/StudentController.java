package com.example.controller;


import com.example.entity.StudentEntity;
import com.example.model.StudentModel;
import com.example.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class StudentController {

    private StudentService studentService;

    @PostMapping(path = "/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody StudentModel studentModel){
        log.info("START   : addStudent   :StudentService.java ");
        String status=studentService.addStudenstsInMongoDb(studentModel);
        if(!status.isEmpty()){
        log.info("END   : addStudent   :StudentService.java ");
            return  new ResponseEntity<>(status, HttpStatus.OK);
        }
        log.error("END   : addStudent   :StudentService.java ");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/getStudentById")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Integer id){
        log.info("START   : getStudentById   :StudentService.java ");
        StudentEntity entity=studentService.getStudentBuId(id);
        if(entity!=null){
        log.info("START   : getStudentById   :StudentService.java ");
            return  new ResponseEntity<>(entity, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/allStudents")
    public ResponseEntity<List<StudentEntity>> getAllStudents(){
        log.info("START   : getAllStudents   :StudentService.java ");
        List<StudentEntity> entities=studentService.getAllStudents();
        if(!entities.isEmpty()){
        log.info("END   : getAllStudents   :StudentService.java ");
        return new ResponseEntity<>(entities,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateById")
    public ResponseEntity<String> updateStudent(@RequestBody StudentModel studentModel, @PathVariable Integer id){
        log.info("START   : updateStudent   :StudentService.java ");
        String entity=studentService.updateStudentData(studentModel,id);
        if(!entity.isEmpty()){
            log.info("END   : updateStudent   :StudentService.java ");
            return new ResponseEntity<>(entity,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("deleteById")
    public ResponseEntity<String> deleteStudentsById(@PathVariable Integer id){
        log.info("START   : deleteStudentsById   :StudentService.java ");
        String entity=studentService.deleteStudentsData(id);
        if(!entity.isEmpty()){
            log.info("START   : deleteStudentsById   :StudentService.java ");
            return new ResponseEntity<>(entity,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
