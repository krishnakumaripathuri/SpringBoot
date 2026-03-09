package com.tejait.batch15.controller;
import com.tejait.batch15.model.Employee;
import com.tejait.batch15.serviceimpl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tools.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTests {
    @MockitoBean
    EmployeeServiceImpl service;

    @Autowired
    MockMvc mockmvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void givenEmp_whenSaveEmp_thenReturnSavedEmp() throws Exception {
        // given
        Employee givenEmp = Employee.builder()
                .id(1)
                .fname("Krishna")
                .lname("p")
                .fullname("Krishna p")
                .age(22)
                .salary(120000)
                .dept("java")
                .empcode("ja123va")
                .build();
        // when
        BDDMockito.given(service.saveEmployee(ArgumentMatchers.any(Employee.class)))
                .willReturn(givenEmp);
        ResultActions result = mockmvc.perform(post("http://localhost:8080/employee/saveEmp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(givenEmp)));
        // then
        result.andExpect(MockMvcResultMatchers.status().isCreated());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.fname").value("Krishna"));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.age").value(22));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.dept").value("java"));
    }
}
