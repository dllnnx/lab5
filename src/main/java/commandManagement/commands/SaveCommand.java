package commandManagement.commands;

import commandManagement.Command;
import exceptions.NoSuchIdException;
import managers.FileManager;

public class SaveCommand extends Command {
    private final FileManager fileManager;

    public SaveCommand(FileManager fileManager) {
        super("save", ": сохранить коллекцию в файл.");
        this.fileManager = fileManager;
    }

    @Override
    public void execute(String[] args) throws NoSuchIdException {
        fileManager.saveObjects();
    }
}
