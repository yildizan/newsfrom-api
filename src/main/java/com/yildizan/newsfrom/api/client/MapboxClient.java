package com.yildizan.newsfrom.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mapbox", url = "https://api.mapbox.com")
public interface MapboxClient {

    @GetMapping("${mapbox.style-path}/{z}/{x}/{y}")
    byte[] fetchTile(
            @PathVariable("z") int z,
            @PathVariable("x") int x,
            @PathVariable("y") int y,
            @RequestParam("access_token") String accessToken
    );

}
