package dev.m1stwng.sturdy.product.service;

import dev.m1stwng.sturdy.product.dto.request.CreateProductRequest;
import dev.m1stwng.sturdy.product.dto.request.UpdateProductRequest;
import dev.m1stwng.sturdy.product.dto.request.UpdateProductSkuRequest;
import dev.m1stwng.sturdy.product.dto.response.ProductResponse;
import dev.m1stwng.sturdy.product.entity.Product;
import dev.m1stwng.sturdy.product.exception.DuplicateProductException;
import dev.m1stwng.sturdy.product.exception.ProductNotFoundException;
import dev.m1stwng.sturdy.product.mapper.ProductMapper;
import dev.m1stwng.sturdy.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public Page<ProductResponse> findAll(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(productMapper::toResponse);
    }

    public ProductResponse findById(UUID id) {
        return productRepository.findById(id)
                .map(productMapper::toResponse)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public ProductResponse create(CreateProductRequest request) {
        final String sku = request.sku().trim().toUpperCase(Locale.ROOT);

        if (productRepository.existsBySku(sku)) {
            throw new DuplicateProductException(sku);
        }

        final Product product = Product.builder()
                .sku(sku)
                .name(request.name())
                .description(request.description())
                .category(request.category())
                .subcategory(request.subcategory())
                .build();

        return productMapper.toResponse(productRepository.save(product));
    }

    public ProductResponse update(UUID id, UpdateProductRequest request) {
        final Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setName(request.name());
        product.setDescription(request.description());
        product.setCategory(request.category());
        product.setSubcategory(request.subcategory());

        return productMapper.toResponse(productRepository.save(product));
    }

    public ProductResponse updateSku(UUID id, UpdateProductSkuRequest request) {
        final Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        final String sku = request.sku().trim().toUpperCase(Locale.ROOT);

        if (productRepository.existsByIdAndSkuNot(id, sku)) {
            throw new DuplicateProductException(sku);
        }

        product.setSku(sku);

        return productMapper.toResponse(productRepository.save(product));
    }

    public void activate(UUID id) {
        final Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setActive(true);

        productRepository.save(product);
    }

    public void deactivate(UUID id) {
        final Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setActive(false);

        productRepository.save(product);
    }

    public void delete(UUID id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }

        productRepository.deleteById(id);
    }
}
