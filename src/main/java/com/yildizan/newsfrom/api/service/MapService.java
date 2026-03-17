package com.yildizan.newsfrom.api.service;

import com.yildizan.newsfrom.api.client.MapboxClient;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@RequiredArgsConstructor
public class MapService {

    private final MapboxClient mapboxClient;

    @Value("${mapbox.access-token}")
    private String accessToken;

    @Value("${mapbox.cache-path}")
    private String cachePath;

    public byte[] getTile(int z, int x, int y) {
        Path tilePath = Path.of(cachePath, String.valueOf(z), String.valueOf(x), y + ".png");

        if (Files.exists(tilePath)) {
            try {
                return Files.readAllBytes(tilePath);
            } catch (IOException e) {
                // failed to read cached tile, will fetch from Mapbox
            }
        }

        byte[] tile = mapboxClient.fetchTile(z, x, y, accessToken);

        try {
            Files.createDirectories(tilePath.getParent());
            Files.write(tilePath, tile);
        } catch (IOException e) {
            // failed to cache tile, will fetch from Mapbox
        }

        return tile;
    }

}
