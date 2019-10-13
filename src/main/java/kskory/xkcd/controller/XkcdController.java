package kskory.xkcd.controller;

import kskory.xkcd.service.XkcdService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("xkcd")
public class XkcdController {

    private XkcdService xkcdService;

    public XkcdController(XkcdService xkcdService) {
        this.xkcdService = xkcdService;
    }

    @GetMapping("current/title")
    public String getCurrentComicTitle() {
        return String.format("the title of today’s XKCD comic was: %s", xkcdService.getCurrentComicTitle());
    }
}
