package com.yildizan.newsfrom.api.service;

import com.yildizan.newsfrom.api.client.MapboxClient;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapService {

    private final MapboxClient mapboxClient;

    @Value("${mapbox.access-token}")
    private String accessToken;

    public byte[] getTile(int z, int x, int y) {
        return mapboxClient.fetchTile(z, x, y, accessToken);
    }

}
