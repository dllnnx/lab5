package managers;

import commandManagement.Printable;
import exceptions.NoSuchIdException;

import java.io.EOFException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RuntimeManager {
    private final Printable console;
    private final CommandManager commandManager;

    public RuntimeManager(Printable console, CommandManager commandManager) {
        this.console = console;
        this.commandManager = commandManager;
    }

    public void interactiveMode(){
        Scanner userScanner = ScannerManager.getUserScanner();
        while (true){
            try {
                String userCommand = userScanner.nextLine().trim() + " ";
                this.launch(userCommand.split(" "));
                commandManager.addToHistory(userCommand.split(" ")[0]);
            } catch (NoSuchElementException e){
                console.printError("Ой, кажется, Вы ввели что-то не то... До свидания!");
                System.exit(0);
            } catch (ArrayIndexOutOfBoundsException ignored){
            }
        }
    }

    public void launch(String[] userCommand){
        if (userCommand[0].isEmpty()) return;
        String[] args = Arrays.copyOfRange(userCommand, 1, userCommand.length);
        if (commandManager.getCommands().get(userCommand[0]) != null) {
            commandManager.execute(userCommand[0], args);
        } else {
            console.printError("Такой команды нет!( Попробуйте еще раз!)).");
        }
    }
}
