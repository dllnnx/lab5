package objects.forms;

import commandManagement.*;
import managers.ScriptManager;

import java.util.function.Predicate;


/**
 * Абстрактный класс для формирования объектов классов пользователем.
 * @param <T> Класс формируемого объекта
 * @author dllnnx
 */
public abstract class Form<T> {
    private final Printable console;
    private final UserInput scanner;

    public Form(Printable console) {
        this.console = (Console.isFileMode()) ? new FileConsole() : console;
        this.scanner = (Console.isFileMode()) ? new ScriptManager() : new ConsoleInput();
    }


    /**
     * Формирует объекта класса
     * @return Объект класса
     */
    public abstract T build();

    /**
     * Формирует объект типа String из пользовательского ввода
     * @param type Название поля, для которого формируется объект
     * @param extraInf Дополнительные ограничения на объект
     * @param validator Валидатор для формируемого объекта
     * @param errMessage Сообщение об ошибке
     * @return Сформированная строка
     */
    public String askString(String type, String extraInf, Predicate<String> validator, String errMessage){
        while (true) {
            try {
                console.println("Введите " + type + extraInf + ": ");
                String input = scanner.nextLine().trim();
                if (!validator.test(input)) throw new IllegalArgumentException();
                return input;
            } catch (IllegalArgumentException e){
                console.printError(type + " должно быть типа String!" + errMessage);
            }
        }
    }

    /**
     * Формирует объект класса Enum из пользовательского ввода
     * @param values Возможные значения объекта
     * @param enumName Название класса формируемого объекта
     * @param validator Валидатор для формируемого объекта
     * @return Сформированный объект Enum
     */
    public Enum askEnum(Enum[] values, String enumName, Predicate<String> validator){
        while(true) {
            console.println("Возможные " + enumName + ": ");
            for (Enum value: values){
                console.println(value.toString());
            }

            console.println("Введите " + enumName + ": ");
            String input = scanner.nextLine().trim();
            try{
                if (!validator.test(input)) throw new IllegalArgumentException();
                for (Enum value: values){
                    if (value.toString().equals(input.toUpperCase())){
                        return value;
                    }
                }
                console.printError("Такого значения нет в списке! :(( Попробуйте еще раз: ");
            } catch (IllegalArgumentException e){
                console.printError("Значение этого поля не может быть null :(( Попробуйте еще раз: ");
            }
        }
    }

    /**
     * Формирует число типа Integer из пользовательского ввода
     * @param type Название поля, для которого формируется объект
     * @param extraInf Дополнительные ограничения на объект
     * @param validator Валидатор для формируемого объекта
     * @param errMessage Сообщение об ошибке
     * @return Сформированное число
     */
    public Integer askInteger(String type, String extraInf, Predicate<Integer> validator, String errMessage) {
        while (true) {
            console.println("Введите " + type + extraInf + ": ");
            String input = scanner.nextLine().trim();
            try {
                Integer num = Integer.parseInt(input);
                if (!validator.test(num)) throw new IllegalArgumentException();
                return num;
            } catch (IllegalArgumentException e) {
                console.printError(type + " должно быть числом типа Integer!" + errMessage);
            }
        }
    }

    /**
     * Формирует число типа float из пользовательского ввода
     * @param type Название поля, для которого формируется объект
     * @param extraInf Дополнительные ограничения на объект
     * @param validator Валидатор для формируемого объекта
     * @param errMessage Сообщение об ошибке
     * @return Сформированное число
     */
    public Float askFloat(String type, String extraInf, Predicate<Float> validator, String errMessage) {
        while (true) {
            console.println("Введите " + type + extraInf + ": ");
            String input = scanner.nextLine().trim();
            try {
                Float num = Float.parseFloat(input);
                if (!validator.test(num)) throw new IllegalArgumentException();
                return num;
            } catch (IllegalArgumentException e) {
                console.printError(type + " должна быть числом типа Float!" + errMessage);
            }
        }
    }

    /**
     * Формирует число типа double из пользовательского ввода
     * @param type Название поля, для которого формируется объект
     * @param extraInf Дополнительные ограничения на объект
     * @param validator Валидатор для формируемого объекта
     * @param errMessage Сообщение об ошибке
     * @return Сформированное число
     */
    public Double askDouble(String type, String extraInf, Predicate<Double> validator, String errMessage) {
        while (true) {
            console.println("Введите " + type + extraInf + ": ");
            String input = scanner.nextLine().trim();
            try {
                Double num = Double.parseDouble(input);
                if (!validator.test(num)) throw new IllegalArgumentException();
                return num;
            } catch (IllegalArgumentException e) {
                console.printError(type + " должна быть числом типа Float!" + errMessage);
            }
        }
    }

}
