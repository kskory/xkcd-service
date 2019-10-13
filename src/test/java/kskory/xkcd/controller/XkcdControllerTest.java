package kskory.xkcd.controller;

import feign.FeignException;
import kskory.xkcd.service.XkcdService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(XkcdController.class)
public class XkcdControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private XkcdService service;

    @Test
    public void shouldReturnComicTitle() throws Exception {
        when(service.getCurrentComicTitle()).thenReturn("some title");

        mockMvc.perform(get("/xkcd/current/title"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("the title of today’s XKCD comic was: some title"));
    }

    @Test
    public void shouldMapToErrorMessage() throws Exception {
        when(service.getCurrentComicTitle()).thenThrow(new FeignException.ServiceUnavailable("msg", null));

        mockMvc.perform(get("/xkcd/current/title"))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }
}