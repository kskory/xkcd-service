package kskory.xkcd.service;

import kskory.xkcd.client.ComicInfo;
import kskory.xkcd.client.XkcdClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class XkcdServiceTest {

    private static final String TITLE = "some title";

    @Mock
    private XkcdClient xkcdClient;

    @InjectMocks
    private XkcdService xkcdService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnComicTitle() {
        when(xkcdClient.getCurrentComicInfo()).thenReturn(ComicInfo.builder().title(TITLE).build());

        assertEquals(TITLE, xkcdService.getCurrentComicTitle());
    }

}