package com.commerce.application.service.comment;

import com.commerce.application.dto.comment.CommentDto;
import com.commerce.application.dto.comment.CreateCommentDto;
import com.commerce.application.dto.comment.UpdateCommentDto;
import jakarta.validation.Valid;

import java.util.List;

public interface CommentService {
    List<CommentDto> listAllByCustomerId(Integer id);

    List<CommentDto> listAllByProductId(Integer id);

    CommentDto listOneComment(Integer id);

    CommentDto createComment(@Valid CreateCommentDto commentDto);

    CommentDto updateComment(@Valid UpdateCommentDto commentDto);

    void deleteComment(Integer id);
}
