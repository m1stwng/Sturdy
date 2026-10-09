package dev.m1stwng.sturdy.warehouse.service;

import dev.m1stwng.sturdy.warehouse.dto.request.CreateWarehouseRequest;
import dev.m1stwng.sturdy.warehouse.dto.request.UpdateWarehouseCodeRequest;
import dev.m1stwng.sturdy.warehouse.dto.request.UpdateWarehouseRequest;
import dev.m1stwng.sturdy.warehouse.dto.response.WarehouseResponse;
import dev.m1stwng.sturdy.warehouse.entity.Warehouse;
import dev.m1stwng.sturdy.warehouse.exception.DuplicateWarehouseException;
import dev.m1stwng.sturdy.warehouse.exception.WarehouseNotFoundException;
import dev.m1stwng.sturdy.warehouse.mapper.WarehouseMapper;
import dev.m1stwng.sturdy.warehouse.repository.WarehouseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseMapper warehouseMapper;
    private final WarehouseRepository warehouseRepository;

    public List<WarehouseResponse> findAll() {
        return warehouseRepository.findAll()
                .stream()
                .map(warehouseMapper::toResponse)
                .toList();
    }

    public WarehouseResponse findById(UUID id) {
        return warehouseRepository.findById(id)
                .map(warehouseMapper::toResponse)
                .orElseThrow(() -> new WarehouseNotFoundException(id));
    }

    public WarehouseResponse create(CreateWarehouseRequest request) {
        final String code = request.code().trim().toUpperCase(Locale.ROOT);

        if (warehouseRepository.existsByCode(code)) {
            throw new DuplicateWarehouseException(code);
        }

        final Warehouse warehouse = Warehouse.builder()
                .code(code)
                .alias(request.alias())
                .build();

        return warehouseMapper.toResponse(warehouseRepository.save(warehouse));
    }

    public WarehouseResponse update(UUID id, UpdateWarehouseRequest request) {
        final Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new WarehouseNotFoundException(id));

        warehouse.setAlias(request.alias());

        return warehouseMapper.toResponse(warehouseRepository.save(warehouse));
    }

    public WarehouseResponse updateCode(UUID id, UpdateWarehouseCodeRequest request) {
        final Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new WarehouseNotFoundException(id));

        final String code = request.code().trim().toUpperCase(Locale.ROOT);

        if (warehouseRepository.existsByIdAndCodeNot(id, code)) {
            throw new DuplicateWarehouseException(code);
        }

        warehouse.setCode(code);

        return warehouseMapper.toResponse(warehouseRepository.save(warehouse));
    }

    public void delete(UUID id) {
        if (!warehouseRepository.existsById(id)) {
            throw new WarehouseNotFoundException(id);
        }

        warehouseRepository.deleteById(id);
    }
}
