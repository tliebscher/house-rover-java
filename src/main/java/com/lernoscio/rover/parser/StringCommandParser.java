package com.lernoscio.rover.parser;

import com.lernoscio.rover.commands.ICommand;
import com.lernoscio.rover.commands.MoveCommand;
import com.lernoscio.rover.commands.RotateLeftCommand;
import com.lernoscio.rover.commands.RotateRightCommand;

import java.util.*;

public class StringCommandParser {

    public static final String BY_EACH_CHARACTER = "";
    public static final int START_INDEX = 1;

    private static Map<String, ICommand> stringToCommandMap = new HashMap<String, ICommand>() {{
        put("L", new RotateLeftCommand());
        put("R", new RotateRightCommand());
        put("M", new MoveCommand());
    }};

    private String commandString;

    public StringCommandParser(final String commandString) {
        this.commandString = commandString;
    }

    public List<ICommand> toCommands() {
        if(isNullOrEmpty(commandString)) return new ArrayList<ICommand>();
        return buildCommandsList(commandString);
    }

    private List<ICommand> buildCommandsList(final String commandString) {
        List<ICommand> commands = new ArrayList<ICommand>();

        for(String commandCharacter : commandCharactersFrom(commandString)) {
            ICommand mappedCommand = lookupEquivalentCommand(commandCharacter.toUpperCase());
            commands.add(mappedCommand);
        }

        return commands;
    }

    private boolean isNullOrEmpty(final String commandString) {
        return (null == commandString || commandString.trim().length() == 0);
    }

    private String[] commandCharactersFrom(final String commandString) {
        return commandString.split(BY_EACH_CHARACTER);
    }

    private ICommand lookupEquivalentCommand(final String commandString) {
        return stringToCommandMap.get(commandString);
    }

}
