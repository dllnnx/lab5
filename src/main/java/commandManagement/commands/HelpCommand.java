package commandManagement.commands;

import commandManagement.Command;
import managers.CommandManager;
import commandManagement.Console;

public class HelpCommand extends Command {
    private final CommandManager commandManager;
    private final Console console;
    public HelpCommand(Console console, CommandManager commandManager){
        super("help", ": вывести справку по доступным командам.");
        this.console = console;
        this.commandManager = commandManager;
    }
    @Override
    public void execute(String[] args) {
        commandManager.getCommands().
                forEach((commandName, command) -> console.println(command.toString()));
    }
}
