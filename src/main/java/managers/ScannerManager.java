package managers;

import lombok.Getter;

import java.util.Scanner;

/**
 * Синглтон-класс для хранения сканера программы
 */
public class ScannerManager {
    @Getter
    public static Scanner userScanner = new Scanner(System.in);

}
