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
import com.lernoscio.rover.environment.Stair;

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

    public void turnAround() {
        this.currentDirection = this.currentDirection.turn();
    }

    public void move() {
        // if rover is in a room
        if (Room.class == currentLocation.getClass()) {
            Room currentRoom = (Room)currentLocation;

            // if facing door calculate new room & coordinates
            if (currentRoom.isFacingDoor(currentCoordinates, currentDirection)) {
                Location newLocation = currentRoom.getDoorExit(currentCoordinates, currentDirection);
                Coordinates newCoordinates = currentRoom.getDoorExitCoordinates(currentCoordinates, currentDirection);
                currentLocation = newLocation;
                currentCoordinates = newCoordinates;
                return;
            }

            // if facing stair calculate stair & coordinates
            if (currentRoom.isFacingStair(currentCoordinates, currentDirection)) {
                Location newLocation = currentRoom.getStair(currentCoordinates, currentDirection);
                Coordinates newCoordinates = currentRoom.getStairStartingCoordinates(currentCoordinates, currentDirection);
                currentLocation = newLocation;
                currentCoordinates = newCoordinates;
                return;
            }
        }

        if (Stair.class == currentLocation.getClass()) {
            Stair currentStair = (Stair)currentLocation;

            // if facing door calculate new room & coordinates
            if (currentStair.isFacingRoom(currentCoordinates, currentDirection)) {
                Location newLocation = currentStair.getExit(currentCoordinates, currentDirection);
                Coordinates newCoordinates = currentStair.getExitCoordinates(currentCoordinates, currentDirection);
                currentLocation = newLocation;
                currentCoordinates = newCoordinates;
                return;
            }
        }

        // calculate new position in current location
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