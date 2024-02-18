package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import commandManagement.ConsoleColor;
import managers.CollectionManager;

public class RemoveFirstCommand extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public RemoveFirstCommand(Console console, CollectionManager collectionManager) {
        super("remove_first", ": удалить первый элемент из коллекции.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            if (collectionManager.getCollectionSize() != 0) {
                collectionManager.removeFirst();
                console.println(ConsoleColor.setConsoleColor(
                        "Первый элемент коллекции успешно удален!", ConsoleColor.GREEN));
            } else {
                console.printError("Коллекция пуста!");
            }
        } else console.printError("Для этой команды не требуются аргументы!");
    }
}
