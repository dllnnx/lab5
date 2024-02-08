package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import managers.CollectionManager;
import models.forms.PersonForm;

/**
 * Команда add {element}: добавить новый элемент в коллекцию
 */
public class Add extends Command {
    private Console console;
    private CollectionManager collectionManager;
    public Add(Console console, CollectionManager collectionManager){
        super("add", "добавить новый элемент в коллекцию.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        console.println("Создание элемента Person...");
        collectionManager.addElement(new PersonForm(console).build());
        console.println("Объект Person создан успешно!");
        // добавить обработку ошибок
    }
}
