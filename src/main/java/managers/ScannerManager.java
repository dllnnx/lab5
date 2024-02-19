package managers;

import lombok.Getter;

import java.util.Scanner;

/**
 * Класс для хранения стандартного сканера для программы.
 * @author dllnnx
 */
public class ScannerManager {
    @Getter
    public static Scanner userScanner = new Scanner(System.in);

}
