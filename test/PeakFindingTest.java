/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NiSE
 */
public class PeakFindingTest {
    
    public PeakFindingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void linear() 
    {
        PeakFinding peakFinding = new PeakFinding();
        peakFinding.setInput(new int[]{9, 6, 7, 7, 4, 3, 2, 1, 4, 5});
        int[] peaks = peakFinding.linear();
        Assert.assertArrayEquals(Arrays.toString(peaks), peaks, new int[]{0, 2, 3, 9});
    }
    
    @Test
    public void divideAndConquer()
    {
        //a[n/2] < a[n/2 − 1]
        PeakFinding peakFinding = new PeakFinding();
        peakFinding.setInput(new int[]{9, 6, 7, 7, 4, 3, 2, 1, 4, 5});
        Assert.assertEquals(2, peakFinding.divideAndConquer());
        
        peakFinding.setInput(new int[]{9, 8, 7, 7, 4, 3, 2, 1, 4, 5});
        Assert.assertEquals(0, peakFinding.divideAndConquer());
        
        //a[n/2] < a[n/2 + 1]
        peakFinding.setInput(new int[]{9, 6, 7, 1, 4, 5, 6, 8, 9, 10, 12});
        Assert.assertEquals(10, peakFinding.divideAndConquer());
        
        //n/2 position is a peak
        peakFinding.setInput(new int[]{1,2,3,4,5,6,5,4,3,2,1});
        Assert.assertEquals(5, peakFinding.divideAndConquer());
                
    }
}
