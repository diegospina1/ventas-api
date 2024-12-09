package com.commerce.application.controller;

import com.commerce.application.dto.comment.CommentDto;
import com.commerce.application.dto.comment.CreateCommentDto;
import com.commerce.application.dto.comment.UpdateCommentDto;
import com.commerce.application.service.comment.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<CommentDto>> listAllByCustomerId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(commentService.listAllByCustomerId(id));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<CommentDto>> listAllByProductId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(commentService.listAllByProductId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> listOneComment(@PathVariable("id") Integer id){
        return ResponseEntity.ok(commentService.listOneComment(id));
    }

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody @Valid CreateCommentDto commentDto){
        return ResponseEntity.ok(commentService.createComment(commentDto));
    }

    @PutMapping
    public ResponseEntity<CommentDto> updateComment(@RequestBody @Valid UpdateCommentDto commentDto){
        return ResponseEntity.ok(commentService.updateComment(commentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable("id") Integer id){
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

}
