package com.commerce.application.service.comment;

import com.commerce.application.dto.comment.CommentDto;
import com.commerce.application.dto.comment.CreateCommentDto;
import com.commerce.application.dto.comment.UpdateCommentDto;
import com.commerce.application.dto.customer.CustomerDto;
import com.commerce.application.dto.product.ProductDto;
import com.commerce.application.helpers.MongoHelper;
import com.commerce.application.model.document.Comment;
import com.commerce.application.repository.CommentRepository;
import com.commerce.application.service.customer.CustomerSearch;
import com.commerce.application.service.product.ProductSearch;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.commerce.application.mapper.CommentMapper.commentMapper;
import static com.commerce.application.mapper.CustomerMapper.customerMapper;
import static com.commerce.application.mapper.ProductMapper.productMapper;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final CustomerSearch customerSearch;
    private final ProductSearch productSearch;

    public CommentServiceImpl(CommentRepository repository, CustomerSearch customerSearch, ProductSearch productSearch) {
        this.repository = repository;
        this.customerSearch = customerSearch;
        this.productSearch = productSearch;
    }

    @Override
    public List<CommentDto> listAllByCustomerId(Integer id) {
        checkCustomerInDb(id);
        return repository.findCommentsByCustomerId(id).stream()
                .map(commentMapper::toCommentDto)
                .toList();
    }

    private void checkCustomerInDb(Integer id) {
        if (!customerSearch.customerExistsById(id))
            throw new EntityNotFoundException();
    }

    @Override
    public List<CommentDto> listAllByProductId(Integer id) {
        checkProductInDb(id);
        return repository.findCommentsByProductId(id).stream()
                .map(commentMapper::toCommentDto)
                .toList();
    }

    private void checkProductInDb(Integer id) {
        if (!productSearch.productExistsById(id))
            throw new EntityNotFoundException();
    }

    @Override
    public CommentDto listOneComment(Integer id) {
        Comment comment = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return commentMapper.toCommentDto(comment);
    }

    @Override
    public CommentDto createComment(CreateCommentDto commentDto) {
        Comment comment = new Comment();

        comment.setId(MongoHelper.autoIncrementId(repository.findAll()));
        comment.setCustomer(findCustomer(commentDto.customer_id()));
        comment.setProduct(findProduct(commentDto.product_id()));
        comment.setMessage(commentDto.message());
        comment.setScore(commentDto.score());

        return commentMapper.toCommentDto(repository.save(comment));
    }

    private CustomerDto findCustomer(Integer id){
        return customerMapper.toCustomerDto(customerSearch.findCustomerById(id));
    }

    private ProductDto findProduct(Integer id) {
        return productMapper.toProductDto(productSearch.findProductById(id));
    }

    @Override
    public CommentDto updateComment(UpdateCommentDto commentDto) {
        Comment comment = repository.findById(commentDto.id())
                .orElseThrow(EntityNotFoundException::new);

        comment.actualizar(commentDto);

        return commentMapper.toCommentDto(repository.save(comment));
    }

    @Override
    public void deleteComment(Integer id) {
        Comment comment = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        repository.delete(comment);
    }
}
