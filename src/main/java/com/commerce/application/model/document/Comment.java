package com.commerce.application.model.document;

import com.commerce.application.dto.CustomerDto;
import com.commerce.application.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Comments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    private Integer id;
    private CustomerDto customer;
    private ProductDto producto;
    private String message;
    private Integer score;

}
