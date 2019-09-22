package com.example;

import java.sql.*;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class StudentsCrudImpl implements StudentsDao {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String username = "root";
//    private static final String password = "1234";
    private static final String password = "rootpasswordgiven";
    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Students> getStudentList() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from students");
            List<Students> StudentsList = new ArrayList<>();
            while (rs.next()) {
                Students sp = new Students();
                sp.setName(rs.getString("Name"));
                sp.setIdstudents(rs.getLong("idStudents"));
                sp.setFacultet(rs.getString("facultet"));
                sp.setSurname(rs.getString("Surname"));
                sp.setDayOfBirth(rs.getDate("dayOfBirth"));
                StudentsList.add(sp);
            }
            return StudentsList;
        } catch (Exception ex) {
            throw new RuntimeException("Error", ex);
        }
    }

    @Override
    public void delete(Students students) {
        String sql = "DELETE FROM students WHERE idStudents=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, students.getIdstudents());
            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addStudent(Students students) {
        String sql = "insert into students (Name, Surname, facultet, dayOfBirth ) values (?,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, students.getName());
            statement.setString(2, students.getSurname());
            statement.setString(3, students.getFacultet());
            statement.setDate(4, new java.sql.Date(students.getDayOfBirth().getTime()));
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editStudent(Students students) {
        String sql = "update students s set  s.Name = ?, s.Surname = ?,s.facultet = ?, s.dayOfBirth = ? where s.idStudents = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, students.getName());
            statement.setString(2, students.getSurname());
            statement.setString(3, students.getFacultet());
            statement.setDate(4, new java.sql.Date(students.getDayOfBirth().getTime()));
            statement.setLong(5, students.getIdstudents());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
