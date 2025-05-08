package br.com.fiap.checkpoint2.controller.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.checkpoint2.dto.consulta.ConsultaRequestCreate;
import br.com.fiap.checkpoint2.dto.consulta.ConsultaRequestUpdate;
import br.com.fiap.checkpoint2.dto.consulta.ConsultaResponse;
import br.com.fiap.checkpoint2.service.consulta.ConsultaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaResponse> create(@RequestBody ConsultaRequestCreate dto) {
        return ResponseEntity.status(201).body(new ConsultaResponse().toDto(consultaService.createConsulta(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponse> update(@PathVariable Long id, @RequestBody ConsultaRequestUpdate dto) {
        return consultaService.updateConsulta(id, dto)
            .map(c -> new ConsultaResponse().toDto(c))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = consultaService.deleteConsulta(id);
        return result ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponse> findById(@PathVariable Long id) {
        return consultaService.getConsultaById(id)
            .map(c -> new ConsultaResponse().toDto(c))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> findAll() {
        List<ConsultaResponse> response = consultaService.getAll().stream()
            .map(c -> new ConsultaResponse().toDto(c))
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}