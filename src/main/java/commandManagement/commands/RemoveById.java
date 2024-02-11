package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import exceptions.NoSuchIdException;
import managers.CollectionManager;

public class RemoveById extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public RemoveById(Console console, CollectionManager collectionManager) {
        super("remove_by_id", " id: удалить элемент из коллекции по его id");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws NoSuchIdException {
        try {
            if (args.length != 1) {
                console.printError("Неверное количество аргументов!");
            } else if (collectionManager.getCollectionSize() != 0) {
                long id = Long.parseLong(args[0]);
                if (collectionManager.getById(id) != null) {
                    collectionManager.removeById(id);
                    console.println("Удаление элемента с id = " + id + " произошло успешно!");
                }
            } else if (collectionManager.getCollectionSize() == 0 ){
                console.printError("Коллекция пуста!");
            }
        } catch (NoSuchIdException e){
            console.printError(e.toString());
        } catch (IllegalArgumentException e){
            console.printError("id должен быть типа long!");
        }
    }
}
