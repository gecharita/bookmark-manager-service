package com.gecharita.bookmark.manager.service.service;

import com.gecharita.bookmark.manager.service.model.Bookmark;

import java.util.Optional;

public interface BookmarksService {
    public Iterable<Bookmark> findAllBookmarks();

    public Optional<Bookmark> getBookmark(long id);

    public void deleteBookmark(long id);

    public Bookmark createBookmark(Bookmark bookmark);

    public Bookmark updateBookmark(Bookmark bookmark, long id);
}
