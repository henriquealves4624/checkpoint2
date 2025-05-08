package br.com.fiap.checkpoint2.dto.paciente;

import br.com.fiap.checkpoint2.model.paciente.Paciente;

public class PacienteResponse {
    private Long id;
    private String nome;
    private String endereco;
    private String bairro;
    private String email;
    private String telefone_completo;



    public PacienteResponse toDto(Paciente paciente){

        this.setId(paciente.getId());
        this.setBairro(paciente.getBairro());
        this.setEmail(paciente.getEmail());
        this.setEndereco(paciente.getEndereco());
        this.setNome(paciente.getNome());
        this.setTelefone_completo(paciente.getTelefone_completo());
        return this;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone_completo() {
        return telefone_completo;
    }
    public void setTelefone_completo(String telefone_completo) {
        this.telefone_completo = telefone_completo;
    }

}
