package managers;

import commandManagement.Printable;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

@RequiredArgsConstructor
public class RuntimeManager {
    private final Printable console;
    private final CommandManager commandManager;
    private final FileManager fileManager;


    public void interactiveMode(){
        Scanner userScanner = ScannerManager.getUserScanner();
        fileManager.fillCollection();
        while (true){
            try {
                String userCommand = userScanner.nextLine().trim() + " ";
                this.launch(userCommand.split(" "));
                commandManager.addToHistory(userCommand.split(" ")[0]);
            } catch (NoSuchElementException e){
                console.printError("Конец ввода... До свидания!))");
                System.exit(0);
            } catch (ArrayIndexOutOfBoundsException ignored){
            }
        }
    }

    public void launch(String[] userCommand){
        if (userCommand[0].isBlank()) return;
        String[] args = Arrays.copyOfRange(userCommand, 1, userCommand.length);
        if (commandManager.getCommands().get(userCommand[0]) != null) {
            commandManager.execute(userCommand[0], args);
        } else {
            console.printError("Такой команды нет!( Попробуйте еще раз!)).");
        }
    }
}
