package commandManagement.commands;

import commandManagement.Command;
import commandManagement.Console;
import commandManagement.ConsoleColor;

/**
 * Команда exit. Завершает программу без сохранения в файл.
 * @author dllnnx
 */
public class ExitCommand extends Command {
    private final Console console;

    public ExitCommand(Console console) {
        super("exit", ": завершить программу (без сохранения в файл).");
        this.console = console;
    }

    /**
     * Выполнить команду
     */
    @Override
    public void execute(String[] args){
        if (args.length != 0){
            console.printError("Для этой команды не требуются аргументы!");
            return;
        }

        console.println(ConsoleColor.setConsoleColor("Программа завершена. До встречи!)))", ConsoleColor.PURPLE));
        System.exit(0);
    }
}
