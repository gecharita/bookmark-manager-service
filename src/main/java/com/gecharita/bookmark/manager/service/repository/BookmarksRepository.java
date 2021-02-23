package com.gecharita.bookmark.manager.service.repository;

import com.gecharita.bookmark.manager.service.model.Bookmark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarksRepository extends CrudRepository<Bookmark, Long> {
}
