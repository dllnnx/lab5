package managers;

import commandManagement.Printable;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс для обработки запуска программы.
 * @author dllnnx
 */
@RequiredArgsConstructor
public class RuntimeManager {
    private final Printable console;
    private final CommandManager commandManager;
    private final FileManager fileManager;


    /**
     * Запускает работу программы в интерактивном режиме (в стандартной консоли).
     */
    public void interactiveMode(){
        Scanner userScanner = ScannerManager.getUserScanner();
        fileManager.fillCollection();
        while (true){
            try {
                String userCommand = userScanner.nextLine().trim() + " ";
                this.launch(userCommand.split(" "));
            } catch (NoSuchElementException e){
                console.printError("Конец ввода... До свидания!))");
                System.exit(0);
            } catch (ArrayIndexOutOfBoundsException ignored){
            }
        }
    }

    /**
     * Запускает выполнение команды.
     * @param userCommand Введенная пользователем команда с аргументами
     */
    public void launch(String[] userCommand){
        if (userCommand[0].isBlank()) return;
        String[] args = Arrays.copyOfRange(userCommand, 1, userCommand.length);
        if (commandManager.getCommands().get(userCommand[0]) != null) {
            commandManager.addToHistory(userCommand[0]);
            commandManager.execute(userCommand[0], args);
        } else {
            console.printError("Такой команды нет!( Попробуйте еще раз!)).");
        }
    }
}
