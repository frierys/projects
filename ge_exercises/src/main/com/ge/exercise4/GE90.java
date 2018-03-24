package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GE90 {
    private static final Logger logger = LogManager.getLogger(GE90.class);

    private static final String ENGINE_MODEL = GE90.class.getSimpleName();
    private final String serialNumber;

    public final int maxNumRebuilds = 3;
    public final double flightHoursBeforeRebuild = 25_000;
    public final double dryWeight = 14_502;
    public final double wetWeight = 15_100;
    public final double takeoffThrust = 81_070;

    private double flightHours;
    private int numRebuilds;

    public GE90(String serialNumber, double flightHours, int numRebuilds) {
        this.serialNumber = serialNumber;
        this.flightHours = flightHours;
        this.numRebuilds = numRebuilds;
    }

    public GE90(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    public GE90(String serialNumber) {
        this(serialNumber, 0.0);
    }

    public double getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(double flightHours) {
        this.flightHours = flightHours;
    }

    public double thrustToWeightRatio() {
        return takeoffThrust / dryWeight;
    }

    public String toString() {
        return ENGINE_MODEL + " SN: " + serialNumber;
    }

    public double hoursToNextRebuild()
    {
    	// If I have hit the max number of rebuilds, zero hours to next
    	// rebuild because maximum service life will have been reached
    	if ( numRebuilds == maxNumRebuilds )
    		return 0;
    				
    	// Otherwise, calculate hours between rebuilds
    	return ( flightHoursBeforeRebuild * ( numRebuilds + 1 ) ) - flightHours;
    }

    public double serviceLifeRemaining()
    {
    	return maxServiceLife() - flightHours;
    }
    
    public double maxServiceLife()
    {
    	return flightHoursBeforeRebuild * ( maxNumRebuilds + 1 );
    }
    
    /**
     * Convenience method added to ensure correct arithmetic when adding tests.
     * @return
     */
    public String servicabilityInfo()
    {
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append( "Service Information for " + toString() + "\n" );
    	sb.append( "Maximum flight hours between rebuilds: " + flightHoursBeforeRebuild + " hours\n" );
    	sb.append( "Hours to next rebuild: " + hoursToNextRebuild() + " hours\n" );
    	sb.append( "Number of hours flown: " + getFlightHours() + " hours\n" );
    	sb.append( "Service life remaining: " + serviceLifeRemaining() + " hours\n" );
    	sb.append( "Maximum service life: " + maxServiceLife() + " hours\n" );
    	sb.append( "Current number of rebuilds completed: " + this.numRebuilds + "\n" );
    	sb.append( "Maximum number of rebuilds allowed: " + maxNumRebuilds + "\n" );
    	sb.append( "Number of rebuilds remaining: " + ( maxNumRebuilds - numRebuilds ) + "\n" );
    	
    	return sb.toString();
    }
}
