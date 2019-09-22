package com.example;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by S.Rakhimov
 */


//@ViewScoped
@ManagedBean(name = "studentsServiceImpl")
@SessionScoped
public class StudentsServiceImpl implements StudentsService {

    private List<Students>studentsList;
    private Students student = new Students();
//    @Inject
    private final StudentsDao studentsDao;

    public StudentsServiceImpl() {
        studentsDao = new StudentsCrudImpl();
    }

    @PostConstruct
    public void init(){
        this.studentsList = studentsDao.getStudentList();
    }

    @Override
    public void delete(Students students) {
        studentsDao.delete(students);
        studentsList.remove(students);
    }

    @Override
    public void addStudent(Students students) {
        studentsDao.addStudent(students);
        studentsList = studentsDao.getStudentList();
    }

    @Override
    public void editStudent(Students students) {
        studentsDao.editStudent(students);
    }

    public List<Students> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Students> studentsList) {
        this.studentsList = studentsList;
    }

    public Students getStudents() {
        return student;
    }

    public void setStudents(Students students) {
        this.student = students;
    }
}
