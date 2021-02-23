package com.gecharita.bookmark.manager.service.service.impl;

import com.gecharita.bookmark.manager.service.model.Bookmark;
import com.gecharita.bookmark.manager.service.repository.BookmarksRepository;
import com.gecharita.bookmark.manager.service.service.BookmarksService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookmarksServiceImpl implements BookmarksService {

    private final BookmarksRepository bookmarksRepository;

    public BookmarksServiceImpl(BookmarksRepository bookmarksRepository) {
        this.bookmarksRepository = bookmarksRepository;
    }

    @Override
    public Iterable<Bookmark> findAllBookmarks() {
        return bookmarksRepository.findAll();
    }

    @Override
    public Optional<Bookmark> getBookmark(long id) {
        return bookmarksRepository.findById(id);
    }

    @Override
    public void deleteBookmark(long id) throws ResourceNotFoundException {
        if(bookmarksRepository.findById(id).isEmpty() ){
           throw new ResourceNotFoundException();
        }
        bookmarksRepository.deleteById(id);
    }

    @Override
    public Bookmark createBookmark(Bookmark bookmark) {
        bookmark.setId(null);
        return bookmarksRepository.save(bookmark);
    }

    @Override
    public Bookmark updateBookmark(Bookmark bookmark, long id) {
        if(bookmarksRepository.findById(id).isPresent()){
            bookmark.setId(id);
            return bookmarksRepository.save(bookmark);
        }
        throw new ResourceNotFoundException();
    }

}
