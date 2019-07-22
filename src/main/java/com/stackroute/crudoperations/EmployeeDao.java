package com.stackroute.crudoperations;

import com.stackroute.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDao {
    //Object for the JdbcTemplate
    private JdbcTemplate jdbcTemplate;

    //Setters and getters for the jdbc template

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {

        return jdbcTemplate;
    }

    public void createTable()//Creating table called customers
    {
        String query = "create table customers(id int,name varchar(20))";
        jdbcTemplate.execute(query);
        System.out.println("Created table");
    }

    public List<Employee> readEmployee()//Retrieving the data from the table employee
    {
        System.out.println("Reading the table");
        return jdbcTemplate.query("select * from Employee", new RowMapperImplementation());

    }

    public int updateEmployee() {//Updating the employee
        System.out.println("Updating the employee");
        return jdbcTemplate.update("update Employee set id=1 where name='pranyusha'");
    }

    public int deleteEmployee() {//Deleting the employee
        System.out.println("Deleting the employee");
        String query = "delete from Employee where id=5";
        return jdbcTemplate.update(query);
    }
    //Implementing  RowMapper to map class instances and table columns
    static final class RowMapperImplementation implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setAge(resultSet.getInt("age"));
            employee.setGender(resultSet.getString("gender"));
            return employee;
        }
    }
}

