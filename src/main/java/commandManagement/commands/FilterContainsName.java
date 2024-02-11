package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import exceptions.NoSuchIdException;
import managers.CollectionManager;
import models.Person;

import java.util.ArrayList;

public class FilterContainsName extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public FilterContainsName(Console console, CollectionManager collectionManager) {
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
            ArrayList<Person> people = collectionManager.filterContainsName(args[0]);
            console.println(people.toString());
        }
    }
}
