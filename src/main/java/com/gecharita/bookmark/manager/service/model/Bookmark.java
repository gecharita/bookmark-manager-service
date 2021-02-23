package com.gecharita.bookmark.manager.service.model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "bookmarks")
public class Bookmark implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    @Column(name = "category")
    private String group;

}
