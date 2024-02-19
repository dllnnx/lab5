package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import commandManagement.ConsoleColor;
import managers.CollectionManager;

/**
 * Команда clear. Очищает коллекцию
 * @author dllnnx
 */
public class ClearCommand extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public ClearCommand(Console console, CollectionManager collectionManager) {
        super("clear", ": очистить коллекцию.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполнить команду
     */
    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            console.printError("Для этой команды не требуются аргументы!");
            return;
        }
        if (collectionManager.getCollectionSize() == 0){
            console.printError("Коллекция уже пуста!");
            return;
        }

        collectionManager.clearCollection();
        console.println(ConsoleColor.setConsoleColor("Коллекция успешно очищена!", ConsoleColor.GREEN));
    }
}
