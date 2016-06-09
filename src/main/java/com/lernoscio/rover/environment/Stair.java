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
    private Coordinates startingCoordinates;
    private Coordinates endingCoordinates;

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
            this.topRightCoordinates = this.topRightCoordinates.newCoordinatesFor(0,steps-1);
            this.startingCoordinates = this.bottomLeftCoordinates;
            this.endingCoordinates = this.topRightCoordinates;
        } else if (Direction.S == direction) {
            this.bottomLeftCoordinates = this.bottomLeftCoordinates.newCoordinatesFor(0,1-steps);
            this.startingCoordinates = this.topRightCoordinates;
            this.endingCoordinates = this.bottomLeftCoordinates;
        } else if (Direction.E == direction) {
            this.topRightCoordinates = this.topRightCoordinates.newCoordinatesFor(steps-1,0);
            this.startingCoordinates = this.bottomLeftCoordinates;
            this.endingCoordinates = this.topRightCoordinates;
        } else if (Direction.W == direction) {
            this.bottomLeftCoordinates = this.bottomLeftCoordinates.newCoordinatesFor(1-steps,0);
            this.startingCoordinates = this.topRightCoordinates;
            this.endingCoordinates = this.bottomLeftCoordinates;
        } else {
            throw new IllegalArgumentException("Unsupported direction");
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        // @TODO refactor, unused
        return this.name;
    }

    public Location getEntry() {
        return (Location)this.entryRoom;
    }

    public Location getExit() {
        return (Location)this.exitRoom;
    }

    public Location getExit(final Coordinates position, final Direction direction) {
        if (this.endingCoordinates.equals(position) && (direction == this.direction)) {
            return this.exitRoom;
        } else if (this.startingCoordinates.equals(position) && (direction == this.direction.turn())) {
            return this.entryRoom;
        }
        else {
            return null;
        }
    }

    public Coordinates getEntryCoordinates() {
        return this.entryAt;
    }

    public Coordinates getExitCoordinates() {
        return this.exitAt;
    }

    public Coordinates getExitCoordinates(final Coordinates position, final Direction direction) {
        if (this.endingCoordinates.equals(position) && (direction == this.direction)) {
            return this.exitAt;
        } else if (this.startingCoordinates.equals(position) && (direction == this.direction.turn())) {
            return this.entryAt;
        }
        else {
            return null;
        }
    }

    public Coordinates getStartingCoordinates() {
        return this.startingCoordinates;
    }

    public boolean isWithin(final Coordinates coordinates) {
        return this.bottomLeftCoordinates.isOutsideBounds(coordinates) && this.topRightCoordinates.isWithinBounds(coordinates);
    }

    public boolean isFacing(final Coordinates position, final Direction direction) {
        return (this.entryAt.equals(position) && (direction == this.direction));
    }

    public boolean isFacingRoom(final Coordinates position, final Direction direction) {
        return ((this.endingCoordinates.equals(position) && (direction == this.direction)) ||
                (this.startingCoordinates.equals(position) && (direction == this.direction.turn())));
    }

    public Direction getDirection() {
        return this.direction;
    }
}