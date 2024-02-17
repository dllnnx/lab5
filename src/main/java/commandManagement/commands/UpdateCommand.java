package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import commandManagement.ConsoleColor;
import exceptions.NoSuchIdException;
import managers.CollectionManager;
import objects.forms.PersonForm;

public class UpdateCommand extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public UpdateCommand(Console console, CollectionManager collectionManager) {
        super("update", " id: обновить значение элемента коллекции, id которого равен заданному.");
        this.console = console;
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(String[] args){
        try {
            if (args.length != 1) {
                console.printError("Неверное количество аргументов! Введено: " + args.length +
                        ", ожидалось: 1.");
            } else if (collectionManager.getCollectionSize() != 0){
                long id = Long.parseLong(args[0]);
                if (collectionManager.getById(id) != null) {
                    console.println(ConsoleColor.setConsoleColor(
                            "Обновление элемента Person, id = " + id + "...", ConsoleColor.CYAN));
                    collectionManager.removeById(id);
                    collectionManager.addElement(new PersonForm(console, collectionManager).build(id));
                    console.println(ConsoleColor.setConsoleColor(
                            "Элемент Person с id = " + id + " обновлен успешно!", ConsoleColor.GREEN));
                }
            } else if (collectionManager.getCollectionSize() == 0){
                console.printError("Коллекция пуста!");
            }
        } catch (NoSuchIdException e) {
            console.printError(e.toString());
        } catch (IllegalArgumentException e){
            console.printError("id должен быть типа long!");
        }
    }
}
