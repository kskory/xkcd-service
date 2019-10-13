package kskory.xkcd.service;

import kskory.xkcd.client.XkcdClient;
import org.springframework.stereotype.Service;

@Service
public class XkcdService {

    private XkcdClient xkcdClient;

    public XkcdService(XkcdClient xkcdClient) {
        this.xkcdClient = xkcdClient;
    }

    public String getCurrentComicTitle() {
        return xkcdClient.getCurrentComicInfo().getTitle();
    }
}
