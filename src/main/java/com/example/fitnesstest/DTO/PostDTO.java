package com.example.fitnesstest.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PostDTO {

    private String content;
    private List<String> mediaList;
    private String video;

}
