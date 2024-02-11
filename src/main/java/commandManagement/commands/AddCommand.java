package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import managers.CollectionManager;
import objects.forms.PersonForm;

/**
 * Команда add {element}: добавить новый элемент в коллекцию
 */
public class AddCommand extends Command {
    private final Console console;
    private final CollectionManager collectionManager;
    public AddCommand(Console console, CollectionManager collectionManager){
        super("add", " {element}: добавить новый элемент в коллекцию.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        console.println("Создание элемента Person...");
        collectionManager.addElement(new PersonForm(console).build());
        console.println("Объект Person создан успешно!");
        // добавить обработку ошибок
    }
}
