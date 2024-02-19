package commandManagement;

import managers.ScannerManager;

import java.util.Scanner;

/**
 * Класс для ввода через стандартную консоль.
 * @author dllnnx
 */
public class ConsoleInput implements UserInput{
    /**
     * Текущий объект класса Scanner
     */
    private static final Scanner userScanner = ScannerManager.getUserScanner();

    /**
     * Считывает следующую строку ввода
     * @return Введенная строка
     */
    @Override
    public String nextLine() {
        return userScanner.nextLine();
    }
}
