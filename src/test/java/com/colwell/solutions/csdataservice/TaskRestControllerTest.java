package com.colwell.solutions.csdataservice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskRestController.class)
public class TaskRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CrudRepository<Task, String> taskRepository;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @WithMockUser
    public void createTask() throws Exception{

        when(taskRepository.save(Mockito.any(Task.class))).thenReturn(new Task("WINNER"));

        this.mockMvc.perform(get("/repository-task"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("WINNER")));
    }
}