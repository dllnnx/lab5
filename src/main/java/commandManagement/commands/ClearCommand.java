package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import commandManagement.ConsoleColor;
import managers.CollectionManager;

public class ClearCommand extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public ClearCommand(Console console, CollectionManager collectionManager) {
        super("clear", ": очистить коллекцию.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (collectionManager.getCollectionSize() != 0) {
            collectionManager.clearCollection();
            console.println(ConsoleColor.setConsoleColor("Коллекция успешно очищена!", ConsoleColor.GREEN));
        } else {
            console.printError("Коллекция уже пуста!");
        }
    }
}
