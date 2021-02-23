package com.gecharita.bookmark.manager.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookmarkDTO implements Serializable {
    private Long id;
    private String name;
    private String url;
    private String group;
}
