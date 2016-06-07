package com.lernoscio.rover.environment;

/**
 *  Room is a named object that has an understanding of boundaries,
 *  doors and stairs connected to it and is multi-directional.
 *  In a room you can turn and move forward.
 *  If you are facing a door, you can change the room.
 *  If you are facing a stair, you can move up or down on it depending
 *  of its direction.
 */

import java.util.Map;
import java.util.HashMap;

public class Door implements Location {

    private Coordinates bottomLeftCoordinates = new Coordinates(0, 0);
    private Coordinates topRightCoordinates = new Coordinates(0, 0);

    private Coordinates entryAt;
    private Coordinates exitAt;

    private Room entryRoom;
    private Room exitRoom;
    private Direction direction;
    private String name;

    public Door(final String name, final Direction direction,
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
        return false;
    }

    public boolean isFacing(final Coordinates position, final Direction direction) {
        return (this.entryAt.equals(position) && (direction == this.direction));
    }

}