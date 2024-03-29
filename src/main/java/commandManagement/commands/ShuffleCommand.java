package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import commandManagement.ConsoleColor;
import managers.CollectionManager;

/**
 * Команда shuffle. Перемешивает элементы коллекции в случайном порядке.
 * @author dllnnx
 */
public class ShuffleCommand extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public ShuffleCommand(Console console, CollectionManager collectionManager) {
        super("shuffle", ": перемешать элементы коллекции в случайном порядке.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполнить команду
     */
    @Override
    public void execute(String[] args){
        if (args.length != 0){
            console.printError("Для этой команды не требуются аргументы!");
            return;
        }

        if (collectionManager.getCollectionSize() != 0) {
            collectionManager.shuffle();
            console.println(ConsoleColor.setConsoleColor("Коллекция успешно перемешана!", ConsoleColor.GREEN));
        } else {
            console.printError("Коллекция пуста!");
        }
    }
}
