package com.tejait.batch15.serviceImpl;

import com.tejait.batch15.model.Employee;
import com.tejait.batch15.repository.EmployeeRepository;
import com.tejait.batch15.serviceimpl.EmployeeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) //this class eligible for mock testing new
class EmployeeServiceImplTests {
    @Mock // create repository mock object
    EmployeeRepository repository;
    @InjectMocks  // service bean injects  into mock bean repository
    EmployeeServiceImpl service;
    @Test
    void givenEmp_whenSaveEmp_thenReturnSavedEmp(){
        //given
        Employee givenEmp=Employee.builder()
                 .id(1)
                .fname("Krishna")
                .lname("p")
             //  .fullname("Krishna p")
                .age(22)
                .salary(120000)
                .dept("java")
                .empcode("ja123va")
                .build();
        //when
        BDDMockito.given(repository.save(givenEmp)).willReturn(givenEmp);  // stubbing
        Employee savedEmp=service.saveEmployee(givenEmp);
        //then
        Assertions.assertThat(savedEmp).isNotNull();
        Assertions.assertThat(savedEmp.getId()).isPositive();
        Assertions.assertThat(savedEmp.getAge()).isGreaterThan(18);
        Assertions. assertThat(savedEmp.getDept()).isEqualTo("java");
        Assertions.assertThat(savedEmp.getFullname()).isEqualTo("Krishna p");
        Assertions.  assertThat(savedEmp).hasFieldOrProperty("empcode");
        Assertions. assertThat(savedEmp).hasFieldOrPropertyWithValue("fullname","Krishna p");
        Assertions.assertThat(savedEmp).hasNoNullFieldsOrProperties();
    }
}
