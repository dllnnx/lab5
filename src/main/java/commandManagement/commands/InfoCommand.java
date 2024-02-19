package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import managers.CollectionManager;

/**
 * Команда info. Выводит в стандартный поток вывода информацию о коллекции.
 * @author dllnnx
 */
public class InfoCommand extends Command {
    private final CollectionManager collectionManager;
    private final Console console;

    public InfoCommand(Console console, CollectionManager collectionManager) {
        super("info", ": вывести в стандартный поток вывода информацию о коллекции.");
        this.collectionManager = collectionManager;
        this.console = console;
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
        console.println("Информация о коллекции: \n" +
                "Тип коллекции: " + collectionManager.getCollectionType() + "\n" +
                "Количество элементов: " + collectionManager.getCollectionSize() + "\n"  +
                "Дата инициализации: " + collectionManager.getInitializationTime()
        );
    }
}
