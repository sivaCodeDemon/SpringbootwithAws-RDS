package com.example.service;

import com.example.entity.StudentEntity;
import com.example.model.StudentModel;
import com.example.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class StudentService {


    private StudentRepository studentRepository;


    public String addStudenstsInMongoDb(StudentModel model){
        log.info("START   : addStudenstsInMongoDb   :StudentService.java ");
        StudentEntity entity= new StudentEntity();
        entity.setStu_Name(model.getStu_Name());
        entity.setStu_Marks(model.getStu_Marks());
        entity.setStu_Status(model.getStu_Status());
        studentRepository.save(entity);
        log.info("END     : addStudenstsInMongoDb   :StudentService.java ");
        return "ADDED_SUCCESSFULLY";
    }


    public StudentEntity getStudentBuId(Integer id){
        log.info("START   : getStudentBuId   :StudentService.java ");
        Optional<StudentEntity> entity=studentRepository.findById(id);
        StudentEntity originalEntity=entity.get();
        log.info("END     : getStudentBuId   :StudentService.java ");
            return originalEntity;
    }

    public List<StudentEntity> getAllStudents(){
        log.info("START   : getAllStudents   :StudentService.java ");
        List<StudentEntity> list= studentRepository.findAll();
        log.info("END     : getAllStudents   :StudentService.java ");
        return  list;
    }


    public String updateStudentData(StudentModel model, Integer studentId){
        log.info("START   : updateStudentData   :StudentService.java ");
        Optional<StudentEntity> stuEntity=studentRepository.findById(studentId);
        StudentEntity entity=stuEntity.get();
        entity.setStu_Status(model.getStu_Status());
        entity.setStu_Name(model.getStu_Name());
        entity.setStu_Marks(model.getStu_Marks());
        studentRepository.save(entity);
        log.info("END     : updateStudentData   :StudentService.java ");
        return "UPDATED_SUCCESSFULLY";
    }


    public String deleteStudentsData(Integer id){
        log.info("START   : deleteStudentsData   :StudentService.java ");
         studentRepository.deleteById(id);
        log.info("END     : deleteStudentsData   :StudentService.java ");
        return  "DELETED_SUCCESSFULLY";
    }

}
