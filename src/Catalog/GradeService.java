package Catalog;

import Catalog.Database.Config.DatabaseConfiguration;

import java.sql.*;

public class GradeService {
    public void addGrade(String lastNameStudent, String firstNameStudent, String iSubject, int grade) {
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {

            String query = "INSERT into grade(id_student, id_subject_prof, grade) VALUES(" +
                    "                       (select id from student where last_name = ? and first_name = ?)," +
                    "                       (select id from subject where name = ?), ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, lastNameStudent);
            preparedStatement.setString(2, firstNameStudent);
            preparedStatement.setString(3, iSubject);
            preparedStatement.setInt(4, grade);

            preparedStatement.execute();
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//            resultSet.close();

        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong adding a new grade");
        }
    }
}
