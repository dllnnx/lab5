package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import commandManagement.ConsoleColor;
import managers.CollectionManager;
import objects.forms.PersonForm;

/**
 * Команда update. Обновляет значение элемента коллекции, id которого равен заданному.
 * @author dllnnx
 */
public class UpdateCommand extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public UpdateCommand(Console console, CollectionManager collectionManager) {
        super("update", " id: обновить значение элемента коллекции, id которого равен заданному.");
        this.console = console;
        this.collectionManager = collectionManager;
    }


    /**
     * Выполнить команду
     * @param args аргумент команды
     */
    @Override
    public void execute(String[] args){
        try {
            if (args.length != 1) {
                console.printError("Неверное количество аргументов! Введено: " + args.length +
                        ", ожидалось: 1.");
                return;
            }
            if (collectionManager.getCollectionSize() == 0){
                console.printError("Коллекция пуста!");
                return;
            }

            long id = Long.parseLong(args[0]);
            if (collectionManager.getById(id) != null) {
                console.println(ConsoleColor.setConsoleColor(
                        "Обновление элемента Person, id = " + id + "...", ConsoleColor.CYAN));
                collectionManager.removeById(id);
                collectionManager.addElement(new PersonForm(console).build(id));
                console.println(ConsoleColor.setConsoleColor(
                        "Элемент Person с id = " + id + " обновлен успешно!", ConsoleColor.GREEN));
            } else {
                console.printError("Нет элемента с таким id в коллекции!");
            }
        } catch (IllegalArgumentException e){
            console.printError("id должен быть типа long!");
        }
    }
}
