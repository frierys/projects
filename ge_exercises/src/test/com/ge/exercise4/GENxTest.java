package com.ge.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GENxTest {

    GENx testEngine;

    @Before
    public void setUp() {
        testEngine = new GENx("0001");
    }

    @Test
    public void toStringTest() {
        assertEquals("GENx SN: 0001", testEngine.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(testEngine.takeoffThrust / testEngine.dryWeight, testEngine.thrustToWeightRatio(), 0.01);
    }

    @Test
    public void serviceLifeRemainingTest() {
        testEngine = new GENx("0001", 30_000, 1 );
        assertEquals(70_000, testEngine.serviceLifeRemaining(), 0.01);
    }

	@Test
    public void maxServiceLifeTest() {
        testEngine = new GENx("0001", 30_000, 1 );
        assertEquals(100_000, testEngine.maxServiceLife(), 0.01);
    }

    @Test
    public void hoursToNextRebuildTest() {

        testEngine = new GENx("0001", 60_000, 3 );
        assertEquals(20_000, testEngine.hoursToNextRebuild(), 0.01);

        testEngine = new GENx("0001", 80_000, 4 );
        assertEquals(0, testEngine.hoursToNextRebuild(), 0.01);
    }
}