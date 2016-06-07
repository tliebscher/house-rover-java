import com.lernoscio.rover.Rover;
import com.lernoscio.rover.environment.Coordinates;
import com.lernoscio.rover.environment.Direction;
import com.lernoscio.rover.environment.Room;
import com.lernoscio.rover.environment.Door;
import org.junit.Assert;
import org.junit.Test;

public class RoverTest {

    @Test
    public void canProvideCurrentLocationAsString() {
        //Given
        Room room = new Room("A",5,5);
        Coordinates startingPosition = new Coordinates(3,3);

        //When
        Rover rover = new Rover(room, startingPosition, Direction.N);

        //then
        Assert.assertEquals("A 3 3 N", rover.currentLocation());
    }

    @Test
    public void canRotateLeft() {
        //Given
        Room room = new Room("A",5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        Rover rover = new Rover(room, startingPosition, Direction.N);

        //When
        rover.turnLeft();

        //then
        Assert.assertEquals("A 1 2 W", rover.currentLocation());
    }

    @Test
    public void canRotateRight() {
        //Given
        Room room = new Room("A",5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        Rover rover = new Rover(room, startingPosition, Direction.N);

        //When
        rover.turnRight();

        //then
        Assert.assertEquals("A 1 2 E", rover.currentLocation());
    }

    @Test
    public void canMove() {
        //Given
        Room room = new Room("A",5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        Rover rover = new Rover(room, startingPosition, Direction.N);

        //When
        rover.move();

        //then
        Assert.assertEquals("A 1 3 N", rover.currentLocation());
    }

    @Test
    public void canRunCommandToRotateRight() {
        //Given
        Room room = new Room("A",5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        Rover rover = new Rover(room, startingPosition, Direction.N);

        //When
        rover.run("R");

        //then
        Assert.assertEquals("A 1 2 E", rover.currentLocation());
    }

    @Test
    public void canRunCommandToRotateLeft() {
        //Given
        Room room = new Room("A",5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        Rover rover = new Rover(room, startingPosition, Direction.N);

        //When
        rover.run("L");

        //then
        Assert.assertEquals("A 1 2 W", rover.currentLocation());
    }

    @Test
    public void canRunCommandToMove() {
        //Given
        Room room = new Room("A",5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        Rover rover = new Rover(room, startingPosition, Direction.N);

        //When
        rover.run("M");

        //then
        Assert.assertEquals("A 1 3 N", rover.currentLocation());
    }

    @Test
    public void canRunCommandWithMultipleInstructions() {
        //Given
        Room room = new Room("A",5,5);
        Coordinates startingPosition = new Coordinates(3,3);
        Rover rover = new Rover(room, startingPosition, Direction.E);

        //When
        rover.run("MMRMMRMRRM");

        //then
        Assert.assertEquals("A 5 1 E", rover.currentLocation());
    }

    @Test
    public void wontDriveBeyondWall() {
        //Given
        Room room = new Room("A",5,5);
        Coordinates startingPosition = new Coordinates(3,3);
        Rover rover = new Rover(room, startingPosition, Direction.N);

        //When
        rover.run("MMMMMMMMMMR");

        //then
        Assert.assertEquals("A 3 5 E", rover.currentLocation());
    }

    @Test
    public void canRunCommandAndStopInFrontOfDoor() {
        //Given
        Room room1 = new Room("X",5,5);
        Room room2 = new Room("Y",4,4);
        Coordinates room1DoorCoordinates = new Coordinates(2,0);
        Coordinates room2DoorCoordinates = new Coordinates(2,3);
        Door door = new Door("XY",Direction.S,room1,room1DoorCoordinates,room2,room2DoorCoordinates);
        room1.addDoor(door);
        room2.addDoor(door);
        Coordinates startingPosition = new Coordinates(3,3);
        Rover rover = new Rover(room1, startingPosition, Direction.N);

        //When
        rover.run("LMLMMM");

        //then
        Assert.assertEquals("X 2 0 S", rover.currentLocation());
    }

    @Test
    public void canRunCommandAndSwitchRooms() {
        //Given
        Room room1 = new Room("X",5,5);
        Room room2 = new Room("Y",4,4);
        Coordinates room1DoorCoordinates = new Coordinates(2,0);
        Coordinates room2DoorCoordinates = new Coordinates(2,3);
        Door door = new Door("XY",Direction.S,room1,room1DoorCoordinates,room2,room2DoorCoordinates);
        room1.addDoor(door);
        room2.addDoor(door);
        Coordinates startingPosition = new Coordinates(3,3);
        Rover rover = new Rover(room1, startingPosition, Direction.N);

        //When
        rover.run("LMLMMMM");

        //then
        Assert.assertEquals("Y 2 3 S", rover.currentLocation());
    }

}
