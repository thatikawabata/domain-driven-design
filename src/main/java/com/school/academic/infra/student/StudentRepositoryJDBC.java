package com.school.academic.infra.student;

import com.school.academic.domain.student.*;
import com.school.shared.domain.CPF;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryJDBC implements StudentRepository {

    private final Connection connection;

    public StudentRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void registration(Student student) {
        try {
            var sql = "INSERT INTO STUDENT VALUE(?,?,?)";
            PreparedStatement ps = null;
            ps = connection.prepareStatement(sql);
            ps.setString(1, student.getCpf().getNumber());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail().getEmail());
            ps.execute();


            sql = sql = "INSERT INTO PHONE VALUE(?,?)";
            ps = connection.prepareStatement(sql);
            for(Phone phone: student.getPhones()){
                ps.setString(1, phone.getDdd());
                ps.setString(2, phone.getNumber());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Student findByCPF(CPF cpf) {
        try {
            var sql = "SELECT id, name, email FROM STUDENT WHERE cpf like ?";
            PreparedStatement ps = null;
            ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumber());

            var rs = ps.executeQuery();
            var find = rs.next();
            if(!find){
                throw new StudentNotFound(cpf);
            }

            var name = rs.getString("name");
            var email = new Email(rs.getString("email"));
            var findStudent = new Student(cpf, name, email);

            populatePhone(rs, findStudent);

            return findStudent;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void populatePhone(java.sql.ResultSet rs, Student findStudent) throws SQLException {              
        var id = rs.getLong("id");
        var sql = "SELECT ddd, number FROM PHONE WHERE student_id = ?";
        var ps = connection.prepareStatement(sql);
        ps.setLong(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            var number = rs.getString("number");
            var ddd = rs.getString("ddd");
            findStudent.addPhone(ddd, number);
        }
    }

    @Override
    public List<Student> findByAllRegistrationStudents() {
        try {
            var sql = "SELECT id, cpf, nome, email FROM STUDENT";
            var ps = connection.prepareStatement(sql);
            var rs = ps.executeQuery();
            List<Student> students = new ArrayList<>();

            while (rs.next()) {
                var cpf = new CPF(rs.getString("cpf"));
                var name = rs.getString("name");
                var email = new Email(rs.getString("email"));
                var findStudent = new Student(cpf, name, email);

                populatePhone(rs, findStudent);
                students.add(findStudent);
            }

            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
