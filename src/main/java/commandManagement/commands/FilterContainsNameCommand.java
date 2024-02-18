package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import managers.CollectionManager;
import objects.Person;

import java.util.ArrayList;
import java.util.List;

public class FilterContainsNameCommand extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public FilterContainsNameCommand(Console console, CollectionManager collectionManager) {
        super("filter_contains_name", " name: вывести элементы, значение поля name которых содержит заданную подстроку.");
        this.console = console;
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(String[] args) {
        if (args.length != 1){
            console.printError("Неверное количество аргументов!");
        } else if (collectionManager.getCollectionSize() == 0){
            console.printError("Коллекция пуста!");
        } else {
            List<Person> people = collectionManager.filterContainsName(args[0]);
            console.println(people.toString());
        }
    }
}
