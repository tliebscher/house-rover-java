package com.lernoscio.rover.environment;

/**
 *  Stair is a named object that has an understanding of boundaries,
 *  connected rooms and is uni-directional.
 *  On a stair you can only move forward.
 *  If you are facing a stair and move forward, you change onto the stair.
 *  Turning on a stair is initially not supported. Attempts to turn will be ignored.
 */

import java.util.Map;
import java.util.HashMap;

public class Stair implements Location {

    private Coordinates bottomLeftCoordinates = new Coordinates(0, 0);
    private Coordinates topRightCoordinates = new Coordinates(0, 0);

    private Coordinates entryAt;
    private Coordinates exitAt;

    private Room entryRoom;
    private Room exitRoom;
    private Direction direction;
    private String name;

    public Stair(final String name, final int steps, final Direction direction,
        final Room entryRoom, final Coordinates entryAt,
        final Room exitRoom, final Coordinates exitAt)
        throws IllegalArgumentException
    {
        if ((null == name) || ("" == name)) {
            throw new IllegalArgumentException("You must specify a name");
        }
        if (null == direction) {
            throw new IllegalArgumentException("You must specify a direction");
        }
        if (null == entryRoom) {
            throw new IllegalArgumentException("You must specify a from-room");
        }
        if (null == exitRoom) {
            throw new IllegalArgumentException("You must specify a to-room");
        }

        this.name = name;
        this.direction = direction;
        this.entryRoom = entryRoom;
        this.entryAt = entryAt;
        this.exitRoom = exitRoom;
        this.exitAt = exitAt;

        // setting dimension
        if (Direction.N == direction) {
            this.topRightCoordinates = this.topRightCoordinates.newCoordinatesFor(0,steps);
        } else if (Direction.S == direction) {
            this.bottomLeftCoordinates = this.bottomLeftCoordinates.newCoordinatesFor(0,0-steps);
        } else if (Direction.E == direction) {
            this.topRightCoordinates = this.topRightCoordinates.newCoordinatesFor(steps,0);
        } else if (Direction.W == direction) {
            this.bottomLeftCoordinates = this.bottomLeftCoordinates.newCoordinatesFor(0-steps,0);
        } else {
            throw new IllegalArgumentException("Unsupported direction");
        }
    }

    @Override
    public String toString() {
        return this.entryRoom.toString() + " " + this.entryAt.toString() + " " + this.direction;
    }

    public String getName() {
        // @TODO refactor, unused
        return this.name;
    }

    public Location getExit() {
        return (Location)this.exitRoom;
    }

    public Coordinates getExitCoordinates() {
        return this.exitAt;
    }

    public boolean isWithin(final Coordinates coordinates) {
        return this.bottomLeftCoordinates.isOutsideBounds(coordinates) && this.topRightCoordinates.isWithinBounds(coordinates);
    }

    public boolean isFacing(final Coordinates position, final Direction direction) {
        return (this.entryAt.equals(position) && (direction == this.direction));
    }

}