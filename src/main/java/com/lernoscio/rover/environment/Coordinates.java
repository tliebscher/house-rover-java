package com.lernoscio.rover.environment;

/**
 *  An object that represent a x and y coordinate.
 *  It is immutable, to reflect that a position cannot
 *  be modified, only a new one can be obtained using
 *  one as reference. Additionally it exposes behavior
 *  to check if another coordinate is outside or within
 *  bounds from 0,0 to current coordinate.
 */

public class Coordinates {

    private int xCoordinate;
    private int yCoordinate;

    public Coordinates(final int xCoordinate, final int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Coordinates newCoordinatesFor(final int xCoordinateStepValue, final int yCoordinateStepValue) {
            return new Coordinates(this.xCoordinate + xCoordinateStepValue, this.yCoordinate + yCoordinateStepValue);
    }

    @Override
    public String toString() {
        StringBuffer coordinateOutput = new StringBuffer();
        coordinateOutput.append(xCoordinate);
        coordinateOutput.append(" ");
        coordinateOutput.append(yCoordinate);
        return coordinateOutput.toString();
    }

    public boolean equals(Coordinates coordinates) {
        return ((coordinates.xCoordinate == this.xCoordinate) && (coordinates.yCoordinate == this.yCoordinate));
    }

    public boolean isWithinBounds(final Coordinates coordinates) {
        return isXCoordinateWithinBounds(coordinates.xCoordinate) && isYCoordinateWithinBounds(coordinates.yCoordinate);
    }

    public boolean isOutsideBounds(final Coordinates coordinates) {
        return isXCoordinateInOutsideBounds(coordinates.xCoordinate) && isYCoordinateInOutsideBounds(coordinates.yCoordinate);
    }

    private boolean isXCoordinateInOutsideBounds(final int xCoordinate) {
        return xCoordinate >= this.xCoordinate;
    }

    private boolean isYCoordinateInOutsideBounds(final int yCoordinate) {
        return yCoordinate >= this.yCoordinate;
    }

    private boolean isXCoordinateWithinBounds(final int xCoordinate) {
        return xCoordinate <= this.xCoordinate;
    }

    private boolean isYCoordinateWithinBounds(final int yCoordinate) {
        return yCoordinate <= this.yCoordinate;
    }

}