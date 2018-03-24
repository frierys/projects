package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GEPassport {
    private static final Logger logger = LogManager.getLogger(GEPassport.class);

    private static final String ENGINE_MODEL = GEPassport.class.getSimpleName();
    private final String serialNumber;

    public final int maxNumRebuilds = 0;
    public final double flightHoursBeforeRebuild = 50_000;
    public final double dryWeight = 4_505;
    public final double wetWeight = 5_230;
    public final double takeoffThrust = 20_650;

    private double flightHours;
    private int numRebuilds;

    public GEPassport(String serialNumber, double flightHours, int numRebuilds) {
        this.serialNumber = serialNumber;
        this.flightHours = flightHours;
        this.numRebuilds = numRebuilds;
    }

    public GEPassport(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    public GEPassport(String serialNumber) {
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
