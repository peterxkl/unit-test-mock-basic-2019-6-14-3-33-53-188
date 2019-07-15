package cashregister;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
        Item item = new  Item("paper",10.00);
        Item [] items = {item};
        Purchase purchase = new Purchase(items);
        FakePrinter printer = new FakePrinter();

        //when
        CashRegister cashRegister = new CashRegister(printer);
        //then
        cashRegister.process(purchase);
        Assertions.assertTrue(printer.isCalled());
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        Item item = new  Item("paper",10.00);
        Item [] items = {item};
        FakePurchase purchase = new FakePurchase(items);
        FakePrinter printer = new FakePrinter();

        //when
        CashRegister cashRegister = new CashRegister(printer);
        //then
        cashRegister.process(purchase);
        Assertions.assertEquals("TEST",purchase.getResult());

    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        Printer printer1 = mock(Printer.class);
        Purchase purchase1 = mock(Purchase.class);
        //when
        when(purchase1.asString()).thenReturn("TEST");
        CashRegister cashRegister = new CashRegister(printer1);
        //then
        cashRegister.process(purchase1);
        verify(printer1).print("TEST");
    }

}
