package com.lernoscio.rover.environment;

import com.lernoscio.rover.environment.Coordinates;
import com.lernoscio.rover.environment.Room;
import org.junit.Assert;
import org.junit.Test;

public class DoorTest {

    @Test
    public void coordinateFacingDoorIsIdentified() {
        //Given
        Room entryRoom = new Room("A",5,5);
        Room exitRoom = new Room("B",4,4);
        Coordinates entryRoomDoorCoordinates = new Coordinates(2,0);
        Coordinates exitRoomDoorCoordinates = new Coordinates(2,3);
        Door door = new Door("AB",Direction.S,entryRoom,entryRoomDoorCoordinates,exitRoom,exitRoomDoorCoordinates);

        //When
        Coordinates coordinates = new Coordinates(2, 0);
        Direction direction = Direction.S;

        //Then
        Assert.assertTrue(door.isFacing(coordinates, direction));
    }

    @Test
    public void coordinateNotAtDoorIsIdentified() {
        //Given
        Room entryRoom = new Room("A",5,5);
        Room exitRoom = new Room("B",4,4);
        Coordinates entryRoomDoorCoordinates = new Coordinates(2,0);
        Coordinates exitRoomDoorCoordinates = new Coordinates(2,3);
        Door door = new Door("AB",Direction.S,entryRoom,entryRoomDoorCoordinates,exitRoom,exitRoomDoorCoordinates);

        //When
        Coordinates coordinates = new Coordinates(3,3);
        Direction direction = Direction.S;

        //Then
        Assert.assertFalse(door.isFacing(coordinates, direction));
    }

    @Test
    public void directionNotFacingDoorIsIdentified() {
        //Given
        Room entryRoom = new Room("A",5,5);
        Room exitRoom = new Room("B",4,4);
        Coordinates entryRoomDoorCoordinates = new Coordinates(2,0);
        Coordinates exitRoomDoorCoordinates = new Coordinates(2,3);
        Door door = new Door("AB",Direction.S,entryRoom,entryRoomDoorCoordinates,exitRoom,exitRoomDoorCoordinates);

        //When
        Coordinates coordinates = new Coordinates(2,0);
        Direction direction = Direction.N;

        //Then
        Assert.assertFalse(door.isFacing(coordinates, direction));
    }

    @Test
    public void exitRoomIsReturned() {
        //Given
        Room entryRoom = new Room("A",5,5);
        Room exitRoom = new Room("B",4,4);
        Coordinates entryRoomDoorCoordinates = new Coordinates(2,0);
        Coordinates exitRoomDoorCoordinates = new Coordinates(2,3);
        Door door = new Door("AB",Direction.S,entryRoom,entryRoomDoorCoordinates,exitRoom,exitRoomDoorCoordinates);

        //When

        //Then
        Assert.assertEquals(door.getExit(), exitRoom);
    }

    @Test
    public void exitCoordinatesAreReturned() {
        //Given
        Room entryRoom = new Room("A",5,5);
        Room exitRoom = new Room("B",4,4);
        Coordinates entryRoomDoorCoordinates = new Coordinates(2,0);
        Coordinates exitRoomDoorCoordinates = new Coordinates(2,3);
        Door door = new Door("AB",Direction.S,entryRoom,entryRoomDoorCoordinates,exitRoom,exitRoomDoorCoordinates);

        //When

        //Then
        Assert.assertEquals(door.getExitCoordinates(), exitRoomDoorCoordinates);
    }
}
