package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import managers.CollectionManager;
import objects.Person;

import java.util.ArrayList;
import java.util.List;

public class FilterByHeightCommand extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public FilterByHeightCommand(Console console, CollectionManager collectionManager) {
        super("filter_by_height", " height: вывести элементы, значение поля height которых равно заданному.");
        this.console = console;
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(String[] args) {
        try {
            if (collectionManager.getCollectionSize() != 0) {
                int height = Integer.parseInt(args[0]);
                List<Person> people = collectionManager.getByHeight(height);
                if (!people.isEmpty()) {
                    console.println(people.toString());
                } else {
                    console.printError("Нет людей с таким ростом в коллекции!");
                }
            } else {
                console.printError("Коллекция пуста!");
            }
        } catch (IllegalArgumentException e){
            console.printError("Рост должен быть целочисленным!");
        }
    }
}
