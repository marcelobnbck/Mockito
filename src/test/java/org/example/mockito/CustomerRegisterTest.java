package org.example.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerRegisterTest {

    @Spy
    @InjectMocks
    private CustomerRegister customerRegister;

    @Mock
    private CustomerRepository repository;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void register_success() throws InvalidValueException {
        Customer objectSaved = new Customer("123", "Joao", "Rua da Saudade, 123. Sao Paulo");

        when(repository.save(any(Customer.class))).thenReturn(objectSaved);

        when(customerRegister.validateRealCpf(anyString())).thenReturn(true);

        CustomerVO vo = new CustomerVO("123", "Joao", "Rua da Saudade, 123. Sao Paulo");

        CustomerVO register = customerRegister.register(vo);

        assertEquals(objectSaved.getId(), register.getId());

        verify(customerRegister).register(vo);
    }

    @Test
    public void register_success_verify() throws InvalidValueException {
        CustomerRegister customerRegister2 = mock(CustomerRegister.class);

        CustomerVO vo = new CustomerVO("83488532275", "Joao", "Rua da Saudade, 123. Sao Paulo");

        customerRegister2.register(vo);

        verify(customerRegister2, times(1)).register(vo);
        verifyNoMoreInteractions(customerRegister2);
    }

    @Test
    public void validate_cpf_success() {
        customerRegister = mock(CustomerRegister.class);
        when(customerRegister.validateRealCpf(anyString())).thenReturn(true);
        Assert.assertTrue(customerRegister.validateRealCpf("9999"));
    }

    @Test
    public void shouldReturnFalseToInvalidateCpf() {
        customerRegister = mock(CustomerRegister.class);
        when(customerRegister.validateRealCpf(anyString())).thenCallRealMethod();
        Assert.assertFalse(customerRegister.validateRealCpf("9999"));
    }

    @Test
    public void testCustomerMethodsWithSpy() {
        Customer customerSpy = spy(new Customer("54771831440", "John Doe", "NY Street, 50 New York"));

        assertEquals("John Doe", customerSpy.getName());
        assertEquals("54771831440", customerSpy.getCpf());
        assertEquals("NY Street, 50 New York", customerSpy.getAddress());

        //doNothing().when(customerSpy).updateName("Jane Doe");

        customerSpy.updateName("Jane Doe");

        verify(customerSpy).updateName("Jane Doe");

        assertEquals("Jane Doe", customerSpy.getName());
    }

    @Test
    public void testCustomerUpdateWithCaptor() {
        Customer customerMock = mock(Customer.class);

        //when(customerMock.getName()).thenReturn("John Doe");
        //when(customerMock.getCpf()).thenReturn("54771831440");

        customerMock.logUpdate("John Doe", "Jane Doe");

        ArgumentCaptor<String> oldNameCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> newNameCaptor = ArgumentCaptor.forClass(String.class);

        verify(customerMock).logUpdate(oldNameCaptor.capture(), newNameCaptor.capture());

        assertEquals("John Doe", oldNameCaptor.getValue());
        assertEquals("Jane Doe", newNameCaptor.getValue());
    }

}