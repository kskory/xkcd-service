package kskory.xkcd.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "xkcdClient", url = "https://xkcd.com/")
public interface XkcdClient {

    @GetMapping("info.0.json")
    ComicInfo getCurrentComicInfo();
}