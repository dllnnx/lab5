package commandManagement.commands;

import commandManagement.*;
import exceptions.IllegalAmountOfArguments;
import managers.CommandManager;
import managers.ScriptManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ExecuteScriptCommand extends Command{
    private final Console console;
    private final CommandManager commandManager;
    private final ScriptManager scriptManager;

    public ExecuteScriptCommand(Console console, CommandManager commandManager, ScriptManager scriptManager) {
        super("execute_script", " file_name: считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        this.console = console;
        this.commandManager = commandManager;
        this.scriptManager = scriptManager;
    }

    @Override
    public void execute(String[] args) {
        try {
            if (args.length != 1) {
                console.printError("Неверное количество аргументов! Ожидалось: 1, введено: "
                + args.length + ".");
                return;
            }
            console.println(ConsoleColor.setConsoleColor("Путь получен успешно!", ConsoleColor.GREEN));
            String filePath = args[0];

            Console.setFileMode(true);
            ScriptManager.addFile(filePath);
            for (String line = scriptManager.nextLine(); !line.isBlank(); line = scriptManager.nextLine()){
                String[] command = line.split(" ");
                commandManager.addToHistory(command[0]);
                if (command[0].isBlank()) return;
                if (command[0].equals("execute_script")){
                    if (ScriptManager.isRecursive(command[1])){
                        console.printError("Найдена рекурсия! Повторно вызывается файл " +
                                new File(command[1]).getAbsolutePath());
                        continue;
                    }
                }

                console.println(ConsoleColor.setConsoleColor("Выполнение команды " + command[0] + "...",
                        ConsoleColor.CYAN));
                if (commandManager.getCommands().get(command[0]) != null) {
                    commandManager.execute(command[0], Arrays.copyOfRange(command, 1, command.length));
                } else {
                    console.printError("Такой команды нет!( Попробуйте еще раз!)).");
                }
                if (command[0].equals("execute_script")) {
                    Console.setFileMode(true);

                }
            }
            ScriptManager.popFile();

        } catch (FileNotFoundException e) {
            console.printError("Такой файл не найден((");
        } catch (NoSuchElementException ignored){
        }
        Console.setFileMode(false);
    }

}
