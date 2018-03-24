package com.ge.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GE90Test {

    GE90 testEngine;

    @Before
    public void setUp() {
        testEngine = new GE90("0001");
    }

    @Test
    public void toStringTest() {
        assertEquals("GE90 SN: 0001", testEngine.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(testEngine.takeoffThrust / testEngine.dryWeight, testEngine.thrustToWeightRatio(), 0.01);
    }

    @Test
    public void serviceLifeRemainingTest() {
        testEngine = new GE90("0001", 30_000, 1 );
        assertEquals(70_000, testEngine.serviceLifeRemaining(), 0.01);
    }

	@Test
    public void maxServiceLifeTest() {
        testEngine = new GE90("0001", 30_000, 1 );
        assertEquals(100_000, testEngine.maxServiceLife(), 0.01);
    }

    @Test
    public void hoursToNextRebuildTest() {

        testEngine = new GE90("0001", 60_000, 2 );
        assertEquals(15_000, testEngine.hoursToNextRebuild(), 0.01);

        testEngine = new GE90("0001", 80_000, 3 );
        assertEquals(0, testEngine.hoursToNextRebuild(), 0.01);
    }
}