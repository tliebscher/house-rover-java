package com.lernoscio.rover;

/**
 *  A class that represents the core entity Rover.
 *  A rover is deployed in an initial location, facing
 *  direction and coordinates. Hence object initialization
 *  takes those parameters. It also exposes a contract
 *  to rest of the world to receive commands to move
 *  or rotate. Amidst all of that the state of rover is
 *  encapsulated and hidden. Rover has methods with verbs
 *  that represents action it can do.
 */

import com.lernoscio.rover.commands.ICommand;
import com.lernoscio.rover.parser.StringCommandParser;
import com.lernoscio.rover.environment.Coordinates;
import com.lernoscio.rover.environment.Location;
import com.lernoscio.rover.environment.Direction;
import com.lernoscio.rover.environment.Room;
import com.lernoscio.rover.environment.Door;

import java.util.List;
public class Rover {

    private Location currentLocation;
    private Coordinates currentCoordinates;
    private Direction currentDirection;

    public Rover(final Location location, final Coordinates coordinates, final Direction direction) {
        this.currentLocation = location;
        this.currentCoordinates = coordinates;
        this.currentDirection = direction;
    }

    public String currentLocation() {
        return currentLocation.toString() + " " + currentCoordinates.toString() + " " + currentDirection.toString();
    }

    public void turnRight() {
        this.currentDirection = this.currentDirection.right();
    }

    public void turnLeft() {
        this.currentDirection = this.currentDirection.left();
    }

    public void move() {
        // if rover is in a room
        if (Room.class == currentLocation.getClass()) {
            // if facing door calculate new room & coordinates
            Room currentRoom = (Room)currentLocation;
            if (currentRoom.isFacingDoor(currentCoordinates, currentDirection)) {
                Door door = currentRoom.getDoor(currentCoordinates, currentDirection);
                Location newLocation = door.getExit();
                Coordinates newCoordinates = door.getExitCoordinates();
                currentLocation = newLocation;
                currentCoordinates = newCoordinates;
                return;
            }
        }

        // calculate new position in current room
        Coordinates positionAfterMove = currentCoordinates.newCoordinatesFor(currentDirection.stepSizeForXAxis(), currentDirection.stepSizeForYAxis());
        if (currentLocation.isWithin(positionAfterMove))
            currentCoordinates = positionAfterMove;
        // ignore command if rover hits wall
    }

    public void run(final String commandString) {
        List<ICommand> roverCommands = new StringCommandParser(commandString).toCommands();
        for (ICommand command : roverCommands) {
            command.execute(this);
        }
    }
}