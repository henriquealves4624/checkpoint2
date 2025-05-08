package br.com.fiap.checkpoint2.service.paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.dto.paciente.PacienteRequestCreate;
import br.com.fiap.checkpoint2.dto.paciente.PacienteRequestUpdate;
import br.com.fiap.checkpoint2.model.paciente.Paciente;


@Service
public class PacienteService {

    private List<Paciente> pacientes = new ArrayList<>();
    private Long sequence = 1L;

    public Paciente createPaciente(PacienteRequestCreate dto){
        Paciente paciente = new Paciente();
        paciente.setId(sequence++);
        paciente.setBairro(dto.getBairro());
        paciente.setEmail(dto.getEmail());
        paciente.setEndereco(dto.getEndereco());
        paciente.setNome(dto.getNome());
        paciente.setTelefone_completo(dto.getTelefone_completo());
        pacientes.add(paciente);
        return paciente;
    }

    public Optional<Paciente> getProductById(Long id) {
        
         return pacientes.stream()
         .filter(p -> p.getId().equals(id))
         .findFirst();
        
    }

    public List<Paciente> getAll(){
        return pacientes;
    }

    public Optional<Paciente> UpdatePaciente(Long id, PacienteRequestUpdate dto){
        return pacientes.stream().filter(p -> p.getId().equals(id))
                  .findFirst()
                  .map(p -> {
                      p.setId(dto.getId());
                      p.setNome(dto.getNome());
                      p.setEndereco(dto.getEndereco());
                      p.setBairro(dto.getBairro());
                      p.setEmail(dto.getEmail());
                      p.setTelefone_completo(dto.getTelefone_completo());
                     return p;
               });} 

    public boolean DeletePaciente(Long id){
        return pacientes.removeIf(p -> p.getId().equals(id));
    }
        
    
    

}
