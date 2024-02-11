package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import exceptions.NoSuchIdException;

public class ExitCommand extends Command {
    private final Console console;

    public ExitCommand(Console console) {
        super("exit", ": завершить программу (без сохранения в файл).");
        this.console = console;
    }

    @Override
    public void execute(String[] args) throws NoSuchIdException {
        console.println("Программа завершена. До свидания!)))");
        System.exit(0);
    }
}
