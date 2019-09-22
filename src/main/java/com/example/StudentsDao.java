package com.example;

import java.util.List;

/**
 * Created by S.Rakhimov
 */
public interface StudentsDao {
    List<Students> getStudentList();
    void delete(Students students);
    void addStudent(Students student);
    void editStudent(Students student);
}
