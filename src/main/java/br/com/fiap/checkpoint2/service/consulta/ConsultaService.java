package br.com.fiap.checkpoint2.service.consulta;

import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.dto.consulta.ConsultaRequestCreate;
import br.com.fiap.checkpoint2.dto.consulta.ConsultaRequestUpdate;
import br.com.fiap.checkpoint2.model.consulta.Consulta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    private List<Consulta> consultas = new ArrayList<>();
    private Long sequence = 1L;

    public Consulta createConsulta(ConsultaRequestCreate dto) {
        Consulta consulta = new Consulta();
        consulta.setId(sequence++);
        consulta.setProfissionalId(dto.getProfissionalId());
        consulta.setPacienteId(dto.getPacienteId());
        consulta.setDataConsulta(dto.getDataConsulta());
        consulta.setStatusConsulta(dto.getStatusConsulta());
        consulta.setQuantidadeHoras(dto.getQuantidadeHoras());
        consulta.setValorConsulta(dto.getValorConsulta());
        consultas.add(consulta);
        return consulta;
    }

    public Optional<Consulta> getConsultaById(Long id) {
        return consultas.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst();
    }

    public List<Consulta> getAll() {
        return consultas;
    }

    public Optional<Consulta> updateConsulta(Long id, ConsultaRequestUpdate dto) {
        return consultas.stream().filter(c -> c.getId().equals(id))
            .findFirst()
            .map(c -> {
                c.setProfissionalId(dto.getProfissionalId());
                c.setPacienteId(dto.getPacienteId());
                c.setDataConsulta(dto.getDataConsulta());
                c.setStatusConsulta(dto.getStatusConsulta());
                c.setQuantidadeHoras(dto.getQuantidadeHoras());
                c.setValorConsulta(dto.getValorConsulta());
                return c;
            });
    }

    public boolean deleteConsulta(Long id) {
        return consultas.removeIf(c -> c.getId().equals(id));
    }
}
