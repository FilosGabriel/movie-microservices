package com.filos.api.clients.moviedb;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "images", url = "#{imageConfiguration.sourcePath}")
public interface ImageTheMovieDB {
    @RequestMapping(method = RequestMethod.GET, value = "https://image.tmdb.org/t/p/original/{imageId}.jpg")
    byte[] getImage(@PathVariable(name = "imageId") String imageId);
}
