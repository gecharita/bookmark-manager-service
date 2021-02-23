package com.gecharita.bookmark.manager.service.controller;

import com.gecharita.bookmark.manager.service.dto.BookmarkDTO;
import com.gecharita.bookmark.manager.service.mapper.BookmarkMapper;
import com.gecharita.bookmark.manager.service.service.BookmarksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path="/api/bookmarks")
public class BookmarksController {

    private final BookmarksService bookmarksService;
    private final BookmarkMapper bookmarkMapper;

    public BookmarksController(BookmarksService bookmarksService, BookmarkMapper bookmarkMapper) {
        this.bookmarksService = bookmarksService;
        this.bookmarkMapper = bookmarkMapper;
    }

    @GetMapping("/test")
    public ResponseEntity<BookmarkDTO> getMessage(){
        BookmarkDTO bookmarkDTO = new BookmarkDTO();
        bookmarkDTO.setId(0L);
        bookmarkDTO.setName("test-name");
        bookmarkDTO.setGroup("test-group");
        bookmarkDTO.setUrl("test-url");
        return ResponseEntity.ok(bookmarkDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<BookmarkDTO>> getAllBookmarks(){
        List<BookmarkDTO> bookmarkDTOs = StreamSupport.stream(bookmarksService.findAllBookmarks().spliterator(), false)
                .map(bookmarkMapper:: toBookmarkDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(bookmarkDTOs);
    }
}
