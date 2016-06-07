package com.lernoscio.rover.commands;

import com.lernoscio.rover.Rover;

public interface ICommand {

    public void execute(final Rover rover);

}
