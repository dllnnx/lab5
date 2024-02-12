package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import commandManagement.ConsoleColor;
import exceptions.NoSuchIdException;

public class ExitCommand extends Command {
    private final Console console;

    public ExitCommand(Console console) {
        super("exit", ": завершить программу (без сохранения в файл).");
        this.console = console;
    }

    @Override
    public void execute(String[] args) throws NoSuchIdException {
        console.println(ConsoleColor.setConsoleColor("Программа завершена. До встречи!)))", ConsoleColor.PURPLE));
        System.exit(0);
    }
}
