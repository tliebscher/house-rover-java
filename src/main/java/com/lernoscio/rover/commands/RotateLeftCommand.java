package com.lernoscio.rover.commands;

import com.lernoscio.rover.Rover;

public class RotateLeftCommand implements ICommand {

    @Override
    public void execute(final Rover rover) {
        rover.turnLeft();
    }

}
