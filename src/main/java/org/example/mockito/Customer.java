package org.example.mockito;

public class Customer {

    private Long id;
    private String cpf;
    private String name;
    private String address;

    public Customer(String cpf, String name, String address) {
        this.cpf = cpf;
        this.name = name;
        this.address = address;
    }

    public Long getId() { return id; }

    public void setId(Long id) {this.id = id; }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void updateName(String newName) {
        this.name = newName;
    }

    public void logUpdate(String oldName, String newName) {
        System.out.println("Updating client from " + oldName + " to " + newName);
    }
}