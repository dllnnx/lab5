package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import commandManagement.ConsoleColor;
import exceptions.NoSuchIdException;
import managers.CollectionManager;

/**
 * Команда remove_by_id. Удаляет элемент из коллекции по его id.
 * @author dllnnx
 */
public class RemoveByIdCommand extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public RemoveByIdCommand(Console console, CollectionManager collectionManager) {
        super("remove_by_id", " id: удалить элемент из коллекции по его id.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполнить команду
     * @param args аргумент команды
     */
    @Override
    public void execute(String[] args) {
        try {
            if (args.length != 1) {
                console.printError("Неверное количество аргументов! Введено: " + args.length +
                        ", ожидалось: 1.");
                return;
            }
            if (collectionManager.getCollectionSize() != 0) {
                long id = Long.parseLong(args[0]);
                collectionManager.removeById(id);
                console.println(ConsoleColor.setConsoleColor
                        ("Удаление элемента с id = " + id + " произошло успешно!", ConsoleColor.GREEN));

            } else console.printError("Коллекция пуста!");
        } catch (NoSuchIdException e){
            console.printError(e.toString());
        } catch (IllegalArgumentException e){
            console.printError("id должен быть типа long!");
        }
    }
}
