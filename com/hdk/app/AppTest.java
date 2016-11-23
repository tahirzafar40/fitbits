package com.hdk.app;

import com.hdk.ops.LocationInputValidator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest  extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-) // TODO
     */
    public void testApp()
    {

        assertTrue( true );
    }
    /**
     * Rigourous Test for pattern validator :-)
     */
    public void testLocationInputValidator()
    {

        String locStringPositive = "87N";
        String locStringNegative = "876";

        String instrStringPositive = "LMMMR";
        String instrStringNegative = "LMMXMR";

        boolean locTestPositive = LocationInputValidator.validateLoc(locStringPositive);
        boolean locTestNegative = LocationInputValidator.validateLoc(locStringNegative);


        boolean testInstrStringPositive  = LocationInputValidator.validateInstr(instrStringPositive);
        boolean testInstrStringNegative = LocationInputValidator.validateInstr(instrStringNegative);

        assertEquals(locTestPositive,true );
        assertEquals(locTestNegative,false );


       assertEquals(testInstrStringPositive,true );
       assertEquals(testInstrStringNegative,false );
    }

}
