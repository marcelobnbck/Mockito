package org.example.mockito;

import br.com.caelum.stella.validation.CPFValidator;

public class CustomerRegister {

    private CustomerRepository repository;

    public CustomerRegister(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerVO register(CustomerVO vo) throws InvalidValueException {
        if (!validateRealCpf(vo.getCpf()))
            throw new InvalidValueException("Invalid CPF");

        Customer entity = new Customer(vo.getCpf(), vo.getName(), vo.getAddress());
        Customer customerSaved = repository.save(entity);
        vo.setId(customerSaved.getId());
        return vo;
    }

    protected boolean validateRealCpf(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(cpf);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}