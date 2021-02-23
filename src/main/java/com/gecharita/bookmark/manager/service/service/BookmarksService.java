package com.gecharita.bookmark.manager.service.service;

import com.gecharita.bookmark.manager.service.model.Bookmark;

public interface BookmarksService {
    public Iterable<Bookmark> findAllBookmarks();
}
