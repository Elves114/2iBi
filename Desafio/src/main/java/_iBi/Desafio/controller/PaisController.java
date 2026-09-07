package _iBi.Desafio.controller;

import _iBi.Desafio.dto.PaisRequest;
import _iBi.Desafio.dto.PaisResponse;
import _iBi.Desafio.service.PaisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paises")
@RequiredArgsConstructor
public class PaisController {

    private final PaisService paisService;

    @PostMapping
    public ResponseEntity<PaisResponse> criar(
            @Valid @RequestBody PaisRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(paisService.criar(request));
    }

    @GetMapping
    public ResponseEntity<List<PaisResponse>> listar(
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return ResponseEntity.ok(
                paisService.listar(sort, direction)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaisResponse> buscarPorId(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                paisService.buscarPorId(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaisResponse> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody PaisRequest request
    ) {
        return ResponseEntity.ok(
                paisService.atualizar(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id
    ) {
        paisService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}