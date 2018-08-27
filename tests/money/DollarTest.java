package money;

import org.junit.Test;
import static org.junit.Assert.*;

class Dollar {

    int amount;

    Dollar(int amount){
        this.amount = amount;
    }

    Dollar multiply(int multiple) {
        return new Dollar(amount*multiple);
    }

    @Override
    public boolean equals(Object candidate){
        return this.amount == ((Dollar)candidate).amount;
    }

}

public class DollarTest {

    @Test
    public void testMultiplicationBy2(){
        Dollar dollar = new Dollar(5);
        assertEquals(new Dollar(10),dollar.multiply(2));
    }

    @Test
    public void testMultiplication(){
        Dollar five = new Dollar(5);
        assertEquals(new Dollar(10), five.multiply(2));
        assertEquals(new Dollar(15), five.multiply(3));
    }

    @Test
    public void testEquality(){
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(7)));
    }

}
