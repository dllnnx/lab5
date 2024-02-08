package commandManagement.commands;

import commandManagement.Command;
import managers.CommandManager;
import commandManagement.Console;

public class Help extends Command {
    private CommandManager commandManager;
    private Console console;
    public Help(Console console, CommandManager commandManager){
        super("help", "вывести справку по доступным командам.");
        this.console = console;
        this.commandManager = commandManager;
    }
    @Override
    public void execute() {
        commandManager.getCommands().
                forEach((commandName, command) -> console.println(command.toString()));
    }
}
