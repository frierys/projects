package com.ge.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GEPassportTest {

    GEPassport testEngine;

    @Before
    public void setUp() {
        testEngine = new GEPassport("0001");
    }

    @Test
    public void toStringTest() {
        assertEquals("GEPassport SN: 0001", testEngine.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(testEngine.takeoffThrust / testEngine.dryWeight, testEngine.thrustToWeightRatio(), 0.01);
    }

    @Test
    public void serviceLifeRemainingTest() {
        testEngine.setFlightHours(30_000);
        assertEquals(20_000, testEngine.serviceLifeRemaining(), 0.01);
    }

	@Test
    public void maxServiceLifeTest() {
        testEngine.setFlightHours(30_000);
        assertEquals(50_000, testEngine.maxServiceLife(), 0.01);
    }

    @Test
    public void hoursToNextRebuildTest() {

        testEngine.setFlightHours(40_000);
        assertEquals(0, testEngine.hoursToNextRebuild(), 0.01);
    }
}