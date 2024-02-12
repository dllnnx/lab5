package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import managers.CollectionManager;
import objects.Person;

import java.util.Collection;

public class ShowCommand extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public ShowCommand(Console console, CollectionManager collectionManager) {
        super("show", ": вывести в стандартный поток вывода все элементы коллекции в строковом представлении.");
        this.console = console;
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(String[] args) {
        if (args.length != 0){
            console.printError("Для этой команды не требуются аргументы!");
        }
        Collection<Person> collection = collectionManager.getCollection();
        if (collection == null || collection.isEmpty()){
            console.printError("Коллекция пуста!");
            return;
        }
        console.println(collection.toString());
    }
}
