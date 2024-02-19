package commandManagement;

import lombok.Getter;
import lombok.Setter;

/**
 * Класс для вывода в стандартную консоль.
 * @author dllnnx
 */
public class Console implements Printable{

    /**
     * Хранит состояние, в котором находится режим ввода
     */
    @Getter
    @Setter
    private static boolean fileMode = false;


    /**
     * Выводит аргумент в консоль
     * @param s аргумент для вывода
     */
    @Override
    public void print(String s) {
        System.out.print(s);
    }

    /**
     * Выводит аргумент в консоль с новой строки
     * @param s аргумент для вывода
     */
    @Override
    public void println(String s){
        System.out.println(s);
    }

    /**
     * Выводит ошибки в консоль
     * @param s ошибка для печати
     */
    @Override
    public void printError(String s) {
        System.out.println(ConsoleColor.setConsoleColor(s, ConsoleColor.RED));
    }
}
