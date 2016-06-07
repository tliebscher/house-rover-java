package com.lernoscio.rover.environment;

/**
 *  Location is an interface for 3-dimensional areas that have  
 *  a name, an understanding of boundaries and can be directional. 
 *  In a Location you can turn and move.
 */

public interface Location {

    public String toString();
    
    public String getName();
    
    public boolean isWithin(final Coordinates coordinates);

    public boolean isFacing(final Coordinates position, final Direction direction);
}