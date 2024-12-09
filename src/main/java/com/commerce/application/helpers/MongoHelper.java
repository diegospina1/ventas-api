package com.commerce.application.helpers;

import com.commerce.application.model.document.Comment;

import java.util.Comparator;
import java.util.List;

public class MongoHelper {

    public static Integer autoIncrementId(List<Comment> comments){
        return comments.isEmpty() ? 1 :
                comments.stream()
                        .max(Comparator.comparingInt(Comment::getId)).get().getId() + 1;
    }
}
