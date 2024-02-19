package managers;

import commandManagement.UserInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Менеджер для работы с командой {@link commandManagement.commands.ExecuteScriptCommand}.
 * @author dllnnx
 */
public class ScriptManager implements UserInput{

    /**
     * Поле для хранения путей к запускаемым файлам
     */
    private static final ArrayDeque<String> pathQueue = new ArrayDeque<>();
    /**
     * Поле для хранения экземпляров сканеров
     */
    private static final ArrayDeque<Scanner> scanners = new ArrayDeque<>();

    /**
     * Добавляет файл в список запускаемых файлов
     * @param path Путь к файлу
     * @throws FileNotFoundException Выбрасывается, если файл не найден
     */
    public static void addFile(String path) throws FileNotFoundException {
        pathQueue.add(new File(path).getAbsolutePath());
        scanners.add(new Scanner(new File(path)));
    }

    /**
     * Проверяет, нет ли рекурсивного запуска скриптов
     * @param path Путь к проверяемому на рекурсию файлу
     * @return true, если запуск рекурсивный, иначе false
     */
    public static boolean isRecursive(String path){
        return pathQueue.contains(new File(path).getAbsolutePath());
    }

    /**
     * Удаляет файл из списка запускаемых файлов
     */
    public static void removeFile(){
        scanners.removeLast();
        pathQueue.removeLast();
    }

    /**
     * Считывает следующую строку ввода
     * @return Строка ввода если есть, "" иначе
     */
    @Override
    public String nextLine() {
        try{
            return scanners.getLast().nextLine();
        } catch (NoSuchElementException e){
            return "";
        }
    }
}
