package com.gecharita.bookmark.manager.service.mapper;

import com.gecharita.bookmark.manager.service.dto.BookmarkDTO;
import com.gecharita.bookmark.manager.service.model.Bookmark;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookmarkMapper {

    Bookmark toBookmark(BookmarkDTO bookmarkDTO);

    BookmarkDTO toBookmarkDTO(Bookmark bookmark);
}
