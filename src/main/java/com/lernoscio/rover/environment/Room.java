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

public class Room implements Location {

    private String name = "noname";
    private HashMap<String, Door> doors = new HashMap<String, Door>();
    private Direction direction = null;
    private Coordinates bottomLeftCoordinates = new Coordinates(0, 0);
    private Coordinates topRightCoordinates = new Coordinates(0, 0);

    public Room(final String name, final int topRightXCoordinate, final int topRightYCoordinate) {
        this.name = name;
        this.topRightCoordinates = this.topRightCoordinates.newCoordinatesFor(topRightXCoordinate, topRightYCoordinate);
    }

    public void addDoor(final Door door) {
        doors.put(door.toString(), door);
    }

    public Door getDoor(final Coordinates coordinates, final Direction direction) {
        String key = this.name + " " + coordinates.toString() + " " + direction.toString();
        return (Door)doors.get(key);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isWithin(final Coordinates coordinates) {
        return this.bottomLeftCoordinates.isOutsideBounds(coordinates) && this.topRightCoordinates.isWithinBounds(coordinates);
    }

    public boolean isFacing(final Coordinates position, final Direction direction) {
        // as a room is directionless return always false
        // @TODO refactor
        return false;
    }

    public boolean isFacingDoor(final Coordinates position, final Direction direction) {
        for (Door door: doors.values()) {
            if (door.isFacing(position, direction))
                return true;
        }
        return false;
    }

    public boolean isFacingStair(final Coordinates position, final Direction direction) {
        // @TODO implementation
        return false;
    }
}