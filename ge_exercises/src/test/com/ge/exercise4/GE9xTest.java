package com.ge.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GE9xTest {

    GE9x testEngine;

    @Before
    public void setUp() {
        testEngine = new GE9x("0001");
    }

    @Test
    public void toStringTest() {
        assertEquals("GE9x SN: 0001", testEngine.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(testEngine.takeoffThrust / testEngine.dryWeight, testEngine.thrustToWeightRatio(), 0.01);
    }

    @Test
    public void serviceLifeRemainingTest() {
        testEngine = new GE9x("0001", 130_000, 4 );
        assertEquals(50_000, testEngine.serviceLifeRemaining(), 0.01);
    }

	@Test
    public void maxServiceLifeTest() {
        testEngine = new GE9x("0001", 130_000, 4 );
        assertEquals(180_000, testEngine.maxServiceLife(), 0.01);
    }

    @Test
    public void hoursToNextRebuildTest() {

        testEngine = new GE9x("0001", 130_000, 4 );
        assertEquals(20_000, testEngine.hoursToNextRebuild(), 0.01);

        testEngine = new GE9x("0001", 160_000, 5 );
        assertEquals(0, testEngine.hoursToNextRebuild(), 0.01);
    }
}