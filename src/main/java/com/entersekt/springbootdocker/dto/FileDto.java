package com.entersekt.springbootdocker.dto;

import lombok.Data;

@Data
public class FileDto {
    private String dir;
    private String path;
    private long fileSize;

}
