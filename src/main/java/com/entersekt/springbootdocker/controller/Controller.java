package com.entersekt.springbootdocker.controller;

import com.entersekt.springbootdocker.dto.FileDto;
import com.entersekt.springbootdocker.service.FilePathService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/file")
@RestController
public class Controller {
    private Logger logger = LoggerFactory.getLogger(Controller.class);

    private FilePathService filePathService;

    @Autowired
    public Controller(FilePathService filePathService) {
        this.filePathService = filePathService;
    }

    @RequestMapping(value = "/filepath", produces = MediaType.APPLICATION_JSON_VALUE)
    public FileDto getFilePath(@RequestParam("path") String path){
        if (filePathService == null){
            return new FileDto();
        }
        FileDto results = filePathService.fileFilePath(path);
        logger.info("FP : " + results);
        return results;
    }
}
