package commandManagement.commands;

import commandManagement.Command;
import managers.CommandManager;
import commandManagement.Console;

/**
 * Команда help. Выводит справку по доступным командам.
 * @author dllnnx
 */
public class HelpCommand extends Command {
    private final CommandManager commandManager;
    private final Console console;
    public HelpCommand(Console console, CommandManager commandManager){
        super("help", ": вывести справку по доступным командам.");
        this.console = console;
        this.commandManager = commandManager;
    }

    /**
     * Выполнить команду
     */
    @Override
    public void execute(String[] args) {
        if (args.length != 0){
            console.printError("Для этой команды не требуются аргументы!");
            return;
        }

        commandManager.getCommands().forEach((commandName, command) -> console.println(command.toString()));
    }
}
