package managers;

import java.util.Scanner;

/**
 * Синглтон-класс для хранения сканера программы
 */
public class ScannerManager {
    public static Scanner userScanner = new Scanner(System.in);

    public static Scanner getUserScanner(){
        return userScanner;
    }
}
