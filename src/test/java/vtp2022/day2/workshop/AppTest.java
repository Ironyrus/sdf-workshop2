// To test: C:\Users\vans_\sdf-workshop1\sdf-workshop2> mvn test


package vtp2022.day2.workshop;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testBankAccount() {
        FixedDepositAccount accOne = new FixedDepositAccount("Wayne", 5000);
        
        //Testing whether balance is as expected
        assertEquals("MESSAGE ERROR ERROR", 5003, accOne.getBalance(), 1e-15);
    }
}
