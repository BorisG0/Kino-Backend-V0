package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Customer;
import com.example.kinobackend.responses.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeSQLTest {

    EmployeeSQL testEmployeeSQL;

    @BeforeEach
    void setUp() {
        testEmployeeSQL = new EmployeeSQL();
    }

    @AfterEach
    void tearDown() {
        testEmployeeSQL = null;
    }

    @Test
    void getEmployeeData() {
        Employee Employees[] = testEmployeeSQL.getEmployeeData();
        Employee actualEmployee = Employees[0];
        Employee expectedEmployee = new Employee("bgreenalf6@oakley.com", "Luxen", "Edmée", "TicketVerkäufer", "CawJOR");
        assertThat(actualEmployee).usingRecursiveComparison().isEqualTo(expectedEmployee);
    }

    @Test
    void getEmployeeByMailAdress() {
        Employee expectedEmployee = new Employee("jburgher3@state.gov", "Denniston", "Loïs", "Kontrolleur", "fEBNPoX");
        Employee actualEmployee = testEmployeeSQL.getEmployeeByMailAdress(expectedEmployee.getMailAdress());
        assertThat(actualEmployee).usingRecursiveComparison().isEqualTo(expectedEmployee);
    }

    @Test
    void addEmployee() {
    }
}