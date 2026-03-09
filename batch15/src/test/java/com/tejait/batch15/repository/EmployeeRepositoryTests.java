package com.tejait.batch15.repository;

import com.tejait.batch15.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

//@AllArgsConstructor
@DataJpaTest
//@EntityScan(basePackageClasses = Employee.class)
class EmployeeRepositoryTests {
    @Autowired
    EmployeeRepository repository;

    @Test
    void givenEmp_whenSaveEmp_thenReturnSavedEmp(){
        // given
     Employee givenEmp=Employee.builder()
               // .id(1)
                .fname("Krishna")
                .lname("p")
                .fullname("Krishna p")
                .age(22)
                .salary(120000)
                .dept("java")
                .empcode("ja123va")
                .build();
          // when
       Employee savedEmp=repository.save(givenEmp);
        // then
        Assertions.assertThat(savedEmp).isNotNull();
        Assertions.assertThat(savedEmp.getId()).isPositive();
        Assertions.assertThat(savedEmp.getAge()).isGreaterThan(18);
        Assertions. assertThat(savedEmp.getDept()).isEqualTo("java");
        Assertions.assertThat(savedEmp.getFullname()).isEqualTo("Krishna p");
        Assertions.  assertThat(savedEmp).hasFieldOrProperty("empcode");
        Assertions. assertThat(savedEmp).hasFieldOrPropertyWithValue("fullname","Krishna p");
        Assertions.assertThat(savedEmp).hasNoNullFieldsOrProperties();
    }
    @Test
    void givenId_whenFindById_getIdObject(){
         Employee givenEmp=Employee.builder()
                    .id(1)
                    .fname("Krishna")
                    .lname("p")
                    .fullname("Krishna p")
                    .age(21)
                    .salary(120000)
                    .dept("java")
                    .empcode("ja123va")
                    .build();
        Employee savedEmp=repository.save(givenEmp);
            Optional<Employee> getIdObject=repository.findById(savedEmp.getId());
            Assertions.assertThat(Employee.builder()).isNotNull();
    }
}

