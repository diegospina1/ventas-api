package com.commerce.application.mapper;

import com.commerce.application.dto.comment.CommentDto;
import com.commerce.application.model.document.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);

    CommentDto toCommentDto(Comment comment);
}
