package com.lernoscio.rover.environment;

import com.lernoscio.rover.environment.Coordinates;
import com.lernoscio.rover.environment.Room;
import org.junit.Assert;
import org.junit.Test;

public class RoomTest {

    @Test
    public void coordinateWithinBoundsIsIdentified() {
        //Given
        Room room = new Room("A",5,5);

        //When
        Coordinates coordinates = new Coordinates(5, 0);

        //Then
        Assert.assertTrue(room.isWithin(coordinates));
    }

    @Test
    public void positiveXCoordinateOutsideBoundsIsIdentified() {
        //Given
        Room room = new Room("A",5,5);

        //When
        Coordinates coordinates = new Coordinates(6, 0);

        //Then
        Assert.assertFalse(room.isWithin(coordinates));
    }

    @Test
    public void negativeXCoordinateOutsideBoundsIsIdentified() {
        //Given
        Room room = new Room("A",5,5);

        //When
        Coordinates coordinates = new Coordinates(-1, 0);


        //Then
        Assert.assertFalse(room.isWithin(coordinates));
    }

    @Test
    public void positiveYCoordinateOutsideBoundsIsIdentified() {
        //Given
        Room room = new Room("A",5,5);

        //When
        Coordinates coordinates = new Coordinates(0, 6);


        //Then
        Assert.assertFalse(room.isWithin(coordinates));
    }

    @Test
    public void negativeYCoordinateOutsideBoundsIsIdentified() {
        //Given
        Room room = new Room("A",5,5);

        //When
        Coordinates coordinates = new Coordinates(0, -1);


        //Then
        Assert.assertFalse(room.isWithin(coordinates));
    }
}
