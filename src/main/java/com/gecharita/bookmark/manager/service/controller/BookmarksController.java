package com.gecharita.bookmark.manager.service.controller;

import com.gecharita.bookmark.manager.service.dto.BookmarkDTO;
import com.gecharita.bookmark.manager.service.mapper.BookmarkMapper;
import com.gecharita.bookmark.manager.service.model.Bookmark;
import com.gecharita.bookmark.manager.service.service.BookmarksService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @DeleteMapping("/{id}")
    public void deleteBookmark(@PathVariable long id){
        bookmarksService.deleteBookmark(id);
    }

    @PostMapping("/")
    public ResponseEntity<Bookmark> createBookmark(@RequestBody BookmarkDTO bookmarkDTO){
        Bookmark bookmark = bookmarkMapper.toBookmark(bookmarkDTO);
        bookmark = bookmarksService.createBookmark(bookmark);
        return ResponseEntity.ok(bookmark);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bookmark> updateBookmark(@RequestBody BookmarkDTO bookmarkDTO, @PathVariable long id){
        Bookmark bookmark = bookmarkMapper.toBookmark(bookmarkDTO);
        bookmark = bookmarksService.updateBookmark(bookmark, id);
        return ResponseEntity.ok(bookmark);
    }
}
