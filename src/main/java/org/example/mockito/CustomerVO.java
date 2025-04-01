package org.example.mockito;

public class CustomerVO {

    private Long id;
    private String cpf;
    private String name;

    public CustomerVO(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}