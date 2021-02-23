package com.gecharita.bookmark.manager.service.service.impl;

import com.gecharita.bookmark.manager.service.model.Bookmark;
import com.gecharita.bookmark.manager.service.repository.BookmarksRepository;
import com.gecharita.bookmark.manager.service.service.BookmarksService;
import org.springframework.stereotype.Service;

@Service
public class BookmarksServiceImpl implements BookmarksService {

    private final BookmarksRepository bookmarksRepository;

    public BookmarksServiceImpl(BookmarksRepository bookmarksRepository) {
        this.bookmarksRepository = bookmarksRepository;
    }


    public Iterable<Bookmark> findAllBookmarks() {
        return bookmarksRepository.findAll();
    }
}
