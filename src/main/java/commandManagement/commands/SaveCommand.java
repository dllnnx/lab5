package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import exceptions.NoSuchIdException;
import managers.FileManager;

/**
 * Команда save. Сохраняет коллекцию в файл.
 * @author dllnnx
 */
public class SaveCommand extends Command {
    private final FileManager fileManager;
    private final Console console;

    public SaveCommand(FileManager fileManager, Console console) {
        super("save", ": сохранить коллекцию в файл.");
        this.fileManager = fileManager;
        this.console = console;
    }

    /**
     * Выполнить команду
     */
    @Override
    public void execute(String[] args){
        if (args.length == 0){
            fileManager.saveObjects();
        } else console.printError("Для этой команды не требуются аргументы!");
    }
}
