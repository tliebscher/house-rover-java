package com.lernoscio.rover.environment;

import com.lernoscio.rover.environment.Coordinates;
import com.lernoscio.rover.environment.Room;
import org.junit.Assert;
import org.junit.Test;

public class StairTest {

    @Test
    public void coordinateFacingStairIsIdentified() {
        //Given
        Room entryRoom = new Room("A",5,5);
        Room exitRoom = new Room("B",4,4);
        String name = "AB";
        int steps = 10;
        Direction stairDirection = Direction.S;
        Coordinates entryRoomStairCoordinates = new Coordinates(2,0);
        Coordinates exitRoomStairCoordinates = new Coordinates(2,3);
        Stair stair = new Stair(name,steps,stairDirection,entryRoom,entryRoomStairCoordinates,exitRoom,exitRoomStairCoordinates);

        //When
        Coordinates coordinates = new Coordinates(2,0);
        Direction direction = Direction.S;

        //Then
        Assert.assertTrue(stair.isFacing(coordinates, direction));
    }

    @Test
    public void coordinateNotAtStairIsIdentified() {
        //Given
        Room entryRoom = new Room("A",5,5);
        Room exitRoom = new Room("B",4,4);
        String name = "AB";
        int steps = 10;
        Direction stairDirection = Direction.S;
        Coordinates entryRoomStairCoordinates = new Coordinates(2,0);
        Coordinates exitRoomStairCoordinates = new Coordinates(2,3);
        Stair stair = new Stair(name,steps,stairDirection,entryRoom,entryRoomStairCoordinates,exitRoom,exitRoomStairCoordinates);

        //When
        Coordinates coordinates = new Coordinates(3,3);
        Direction direction = Direction.S;

        //Then
        Assert.assertFalse(stair.isFacing(coordinates, direction));
    }

    @Test
    public void directionNotFacingStairIsIdentified() {
        //Given
        Room entryRoom = new Room("A",5,5);
        Room exitRoom = new Room("B",4,4);
        String name = "AB";
        int steps = 10;
        Direction stairDirection = Direction.S;
        Coordinates entryRoomStairCoordinates = new Coordinates(2,0);
        Coordinates exitRoomStairCoordinates = new Coordinates(2,3);
        Stair stair = new Stair(name,steps,stairDirection,entryRoom,entryRoomStairCoordinates,exitRoom,exitRoomStairCoordinates);

        //When
        Coordinates coordinates = new Coordinates(2,0);
        Direction direction = Direction.N;

        //Then
        Assert.assertFalse(stair.isFacing(coordinates, direction));
    }

    @Test
    public void exitRoomIsReturned() {
        //Given
        Room entryRoom = new Room("A",5,5);
        Room exitRoom = new Room("B",4,4);
        String name = "AB";
        int steps = 10;
        Direction stairDirection = Direction.S;
        Coordinates entryRoomStairCoordinates = new Coordinates(2,0);
        Coordinates exitRoomStairCoordinates = new Coordinates(2,3);
        Stair stair = new Stair(name,steps,stairDirection,entryRoom,entryRoomStairCoordinates,exitRoom,exitRoomStairCoordinates);

        //When

        //Then
        Assert.assertEquals(stair.getExit(), exitRoom);
    }

    @Test
    public void exitCoordinatesAreReturned() {
        //Given
        Room entryRoom = new Room("A",5,5);
        Room exitRoom = new Room("B",4,4);
        String name = "AB";
        int steps = 10;
        Direction stairDirection = Direction.S;
        Coordinates entryRoomStairCoordinates = new Coordinates(2,0);
        Coordinates exitRoomStairCoordinates = new Coordinates(2,3);
        Stair stair = new Stair(name,steps,stairDirection,entryRoom,entryRoomStairCoordinates,exitRoom,exitRoomStairCoordinates);

        //When

        //Then
        Assert.assertEquals(stair.getExitCoordinates(), exitRoomStairCoordinates);
    }

    @Test
    public void coordinateWithinBoundsIsIdentified() {
        //Given
        Room entryRoom = new Room("A",5,5);
        Room exitRoom = new Room("B",4,4);
        String name = "AB";
        int steps = 10;
        Direction stairDirection = Direction.S;
        Coordinates entryRoomStairCoordinates = new Coordinates(2,0);
        Coordinates exitRoomStairCoordinates = new Coordinates(2,3);
        Stair stair = new Stair(name,steps,stairDirection,entryRoom,entryRoomStairCoordinates,exitRoom,exitRoomStairCoordinates);

        //When
        Coordinates coordinates = new Coordinates(0,-3);

        //Then
        Assert.assertTrue(stair.isWithin(coordinates));
    }

    @Test
    public void xCoordinateOutsideBoundsIsIdentified() {
        //Given
        Room entryRoom = new Room("A",5,5);
        Room exitRoom = new Room("B",4,4);
        String name = "AB";
        int steps = 10;
        Direction stairDirection = Direction.S;
        Coordinates entryRoomStairCoordinates = new Coordinates(2,0);
        Coordinates exitRoomStairCoordinates = new Coordinates(2,3);
        Stair stair = new Stair(name,steps,stairDirection,entryRoom,entryRoomStairCoordinates,exitRoom,exitRoomStairCoordinates);

        //When
        Coordinates coordinates = new Coordinates(1,0);

        //Then
        Assert.assertFalse(stair.isWithin(coordinates));
    }

    @Test
    public void negativeXCoordinateOutsideBoundsIsIdentified() {
        //Given
        Room entryRoom = new Room("A",5,5);
        Room exitRoom = new Room("B",4,4);
        String name = "AB";
        int steps = 10;
        Direction stairDirection = Direction.S;
        Coordinates entryRoomStairCoordinates = new Coordinates(2,0);
        Coordinates exitRoomStairCoordinates = new Coordinates(2,3);
        Stair stair = new Stair(name,steps,stairDirection,entryRoom,entryRoomStairCoordinates,exitRoom,exitRoomStairCoordinates);

        //When
        Coordinates coordinates = new Coordinates(-1,0);

        //Then
        Assert.assertFalse(stair.isWithin(coordinates));
    }

    @Test
    public void positiveYCoordinateOutsideBoundsIsIdentified() {
        //Given
        //Given
        Room entryRoom = new Room("A",5,5);
        Room exitRoom = new Room("B",4,4);
        String name = "AB";
        int steps = 10;
        Direction stairDirection = Direction.S;
        Coordinates entryRoomStairCoordinates = new Coordinates(2,0);
        Coordinates exitRoomStairCoordinates = new Coordinates(2,3);
        Stair stair = new Stair(name,steps,stairDirection,entryRoom,entryRoomStairCoordinates,exitRoom,exitRoomStairCoordinates);

        //When
        Coordinates coordinates = new Coordinates(0,1);

        //Then
        Assert.assertFalse(stair.isWithin(coordinates));
    }

    @Test
    public void negativeYCoordinateOutsideBoundsIsIdentified() {
        //Given
        Room entryRoom = new Room("A",5,5);
        Room exitRoom = new Room("B",4,4);
        String name = "AB";
        int steps = 10;
        Direction stairDirection = Direction.S;
        Coordinates entryRoomStairCoordinates = new Coordinates(2,0);
        Coordinates exitRoomStairCoordinates = new Coordinates(2,3);
        Stair stair = new Stair(name,steps,stairDirection,entryRoom,entryRoomStairCoordinates,exitRoom,exitRoomStairCoordinates);

        //When
        Coordinates coordinates = new Coordinates(0,-11);

        //Then
        Assert.assertFalse(stair.isWithin(coordinates));
    }
}
