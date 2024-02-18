package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import exceptions.NoSuchIdException;
import managers.CollectionManager;

public class MaxByNationalityCommand extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public MaxByNationalityCommand(Console console, CollectionManager collectionManager) {
        super("max_by_nationality", ": вывести любой объект из коллекции, значение поля nationality которого является максимальным.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args){
        if (args.length != 0){
            console.printError("Для этой команды не требуются аргументы!");
            return;
        }

        if (collectionManager.getCollectionSize() != 0) {
            console.println("Объект Person с максимальным значением поля nationality: ");
            console.println(collectionManager.maxByNationality().toString());
        } else {
            console.printError("Коллекция пуста!");
        }
    }
}
