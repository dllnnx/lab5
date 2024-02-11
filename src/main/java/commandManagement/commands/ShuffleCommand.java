package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import exceptions.IllegalAmountOfArguments;
import exceptions.NoSuchIdException;
import managers.CollectionManager;

public class ShuffleCommand extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public ShuffleCommand(Console console, CollectionManager collectionManager) {
        super("shuffle", ": перемешать элементы коллекции в случайном порядке.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws NoSuchIdException {
        try {
            if (collectionManager.getCollectionSize() != 0) {
                collectionManager.shuffle(args);
                console.println("Коллекция успешно перемешана!");
            } else {
                console.printError("Коллекция пуста!");
            }
        } catch (IllegalAmountOfArguments e){
            console.printError(e.toString());
        }
    }
}
