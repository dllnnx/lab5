package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import exceptions.NoSuchIdException;
import managers.CommandManager;

import java.util.List;

public class HistoryCommand extends Command {
    private final Console console;
    private final CommandManager commandManager;

    public HistoryCommand(Console console, CommandManager commandManager) {
        super("history", ":  вывести последние 10 команд (без их аргументов).");
        this.console = console;
        this.commandManager = commandManager;
    }

    @Override
    public void execute(String[] args) throws NoSuchIdException {
        if (args.length != 0){
            console.printError("Для этой команды не требуются аргументы!");
        } else{
            List<String> history = commandManager.getCommandHistory();
            if (!history.isEmpty()){
                for (String command: history.subList(Math.max(0, history.size() - 10), history.size())){
                    console.println(command);
                }
            } else{
                console.println("Вы еще не ввели ни одной команды! :(((");
            }
        }
    }
}
