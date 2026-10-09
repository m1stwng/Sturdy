package dev.m1stwng.sturdy.warehouse.controller;

import dev.m1stwng.sturdy.warehouse.dto.request.CreateWarehouseRequest;
import dev.m1stwng.sturdy.warehouse.dto.request.UpdateWarehouseCodeRequest;
import dev.m1stwng.sturdy.warehouse.dto.request.UpdateWarehouseRequest;
import dev.m1stwng.sturdy.warehouse.dto.response.WarehouseResponse;
import dev.m1stwng.sturdy.warehouse.service.WarehouseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/warehouses")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;

    @GetMapping
    ResponseEntity<List<WarehouseResponse>> findAll() {
        return ResponseEntity.ok(warehouseService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<WarehouseResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(warehouseService.findById(id));
    }

    @PostMapping
    ResponseEntity<WarehouseResponse> create(@RequestBody @Valid CreateWarehouseRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(warehouseService.create(request));
    }

    @PatchMapping("/{id}")
    ResponseEntity<WarehouseResponse> update(
            @PathVariable UUID id,
            @RequestBody @Valid UpdateWarehouseRequest request
    ) {
        return ResponseEntity.ok(warehouseService.update(id, request));
    }

    @PatchMapping("/{id}/code")
    ResponseEntity<WarehouseResponse> updateCode(
            @PathVariable UUID id,
            @RequestBody @Valid UpdateWarehouseCodeRequest request
    ) {
        return ResponseEntity.ok(warehouseService.updateCode(id, request));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<WarehouseResponse> delete(@PathVariable UUID id) {
        warehouseService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
