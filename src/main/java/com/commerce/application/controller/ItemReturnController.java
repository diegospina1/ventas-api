package com.commerce.application.controller;

import com.commerce.application.dto.itemReturn.*;
import com.commerce.application.service.itemReturn.ItemReturnService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-return")
public class ItemReturnController {

    private final ItemReturnService itemReturnService;

    public ItemReturnController(ItemReturnService itemReturnService) {
        this.itemReturnService = itemReturnService;
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<ItemReturnDto>> listAllReturnsByCustomerId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(itemReturnService.listAllReturnsByCustomerId(id));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<ItemReturnDto>> listAllReturnsByProductId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(itemReturnService.listAllReturnsByProductId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemReturnDto> listOneItemReturn(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(itemReturnService.listOneItemReturn(id));
    }

    @PostMapping
    public ResponseEntity<ItemReturnDto> createReturn(@RequestBody @Valid CreateReturnDto returnDto) {
        return ResponseEntity.ok(itemReturnService.createReturn(returnDto));
    }

    @PutMapping
    public ResponseEntity<ItemReturnDto> updateReturn(@RequestBody @Valid UpdateReturnDto returnDto){
        return ResponseEntity.ok(itemReturnService.updateReturn(returnDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReturn(@PathVariable("id") Integer id) {
        itemReturnService.deleteReturn(id);
        return ResponseEntity.noContent().build();
    }
}
