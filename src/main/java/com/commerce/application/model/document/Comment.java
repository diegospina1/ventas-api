package com.commerce.application.model.document;

import com.commerce.application.dto.comment.UpdateCommentDto;
import com.commerce.application.dto.customer.CustomerDto;
import com.commerce.application.dto.product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    private Integer id;
    private CustomerDto customer;
    private ProductDto product;
    private String message;
    private Integer score;

    public void actualizar(UpdateCommentDto commentDto) {
        if (commentDto.message() != null) {
            this.message = commentDto.message();
        }
        if (commentDto.score() != null) {
            this.score = commentDto.score();
        }
    }
}
