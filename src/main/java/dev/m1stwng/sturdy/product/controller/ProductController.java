package dev.m1stwng.sturdy.product.controller;

import dev.m1stwng.sturdy.product.dto.request.CreateProductRequest;
import dev.m1stwng.sturdy.product.dto.request.UpdateProductRequest;
import dev.m1stwng.sturdy.product.dto.request.UpdateProductSkuRequest;
import dev.m1stwng.sturdy.product.dto.response.ProductResponse;
import dev.m1stwng.sturdy.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    ResponseEntity<Page<ProductResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @GetMapping("/{id}")
    ResponseEntity<ProductResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    ResponseEntity<ProductResponse> create(@RequestBody @Valid CreateProductRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(request));
    }

    @PatchMapping("/{id}")
    ResponseEntity<ProductResponse> update(@PathVariable UUID id, @RequestBody @Valid UpdateProductRequest request) {
        return ResponseEntity.ok(productService.update(id, request));
    }

    @PatchMapping("/{id}/sku")
    ResponseEntity<ProductResponse> updateSku(
            @PathVariable UUID id,
            @RequestBody @Valid UpdateProductSkuRequest request
    ) {
        return ResponseEntity.ok(productService.updateSku(id, request));
    }

    @PatchMapping("/{id}/activate")
    ResponseEntity<ProductResponse> activate(@PathVariable UUID id) {
        productService.activate(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/deactivate")
    ResponseEntity<ProductResponse> deactivate(@PathVariable UUID id) {
        productService.deactivate(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ProductResponse> delete(@PathVariable UUID id) {
        productService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
