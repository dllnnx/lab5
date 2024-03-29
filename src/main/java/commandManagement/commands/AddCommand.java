package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import commandManagement.ConsoleColor;
import managers.CollectionManager;
import objects.forms.PersonForm;

/**
 * Команда add {element}. Добавляет новый элемент в коллекцию.
 * @author dllnnx
 */
public class AddCommand extends Command {
    private final Console console;
    private final CollectionManager collectionManager;
    public AddCommand(Console console, CollectionManager collectionManager){
        super("add", " {element}: добавить новый элемент в коллекцию.");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполнить команду
     * @param args аргументы команды
     */
    @Override
    public void execute(String[] args) {
        console.println(ConsoleColor.setConsoleColor("Создание элемента Person...", ConsoleColor.CYAN));
        collectionManager.addElement(new PersonForm(console).build());
        console.println(ConsoleColor.setConsoleColor("Объект Person создан успешно!", ConsoleColor.GREEN));
    }
}
