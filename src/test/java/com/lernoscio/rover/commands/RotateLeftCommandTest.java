package com.lernoscio.rover.commands;

import com.lernoscio.rover.Rover;
import com.lernoscio.rover.commands.RotateLeftCommand;
import com.lernoscio.rover.environment.Coordinates;
import com.lernoscio.rover.environment.Direction;
import com.lernoscio.rover.environment.Room;
import org.junit.Assert;
import org.junit.Test;

public class RotateLeftCommandTest {

    @Test
    public void testThatRotateLeftCommandRotatesRoverLeft() {
        //Given
        RotateLeftCommand command = new RotateLeftCommand();
        Room room = new Room("A",5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        Rover rover = new Rover(room, startingPosition, Direction.N);

        //When
        command.execute(rover);

        //Then
        Assert.assertEquals("A 1 2 W", rover.currentLocation());
    }

}
