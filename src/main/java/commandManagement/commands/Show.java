package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import managers.CollectionManager;
import models.Person;

import java.util.Collection;

public class Show extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public Show(Console console, CollectionManager collectionManager) {
        super("show", ": вывести в стандартный поток вывода все элементы коллекции в строковом представлении.");
        this.console = console;
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(String[] args) {
        Collection<Person> collection = collectionManager.getCollection();
        if (collection == null || collection.isEmpty()){
            console.printError("Коллекция пуста!");
            return;
        }
        console.println(collection.toString());
    }
}
