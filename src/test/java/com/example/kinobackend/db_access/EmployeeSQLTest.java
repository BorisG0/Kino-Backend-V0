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
        Employee employees[] = testEmployeeSQL.getEmployeeData();
        Employee expectedEmployee = new Employee("etebbit5@google.com.au", "Merritt", "Marie-thérèse", "Manager", "0O5fYu");
        Employee actualEmployee = new Employee();
        for(int i = 0; i < employees.length; i++){
            actualEmployee = employees[i];
            if(actualEmployee.getMailAdress().equals(expectedEmployee.getMailAdress())){
                break;
            }
        }
        assertThat(actualEmployee).usingRecursiveComparison().isEqualTo(expectedEmployee);
    }

    @Test
    void getEmployeeByMailAdress() {
        Employee expectedEmployee = new Employee("jburgher3@state.gov", "Denniston", "Loïs", "Kontrolleur", "fEBNPoX");
        Employee actualEmployee = testEmployeeSQL.getEmployeeByMailAdress(expectedEmployee.getMailAdress());
        assertThat(actualEmployee).usingRecursiveComparison().isEqualTo(expectedEmployee);
    }

}