package objects.forms;

import commandManagement.*;

import java.util.function.Predicate;


public abstract class Form<T> {
    private final Printable console;
    private final UserInput scanner;

    public Form(Printable console) {
        this.console = (Console.isFileMode()) ? new FileConsole() : console;
        this.scanner = new ConsoleInput(); // добавить сканер с файлов
    }

    public abstract T build();

    public String askString(String type, Predicate<String> validator, String errMessage){
        while (true) {
            try {
                console.println("Введите " + type + ": ");
                String input = scanner.nextLine().trim();
                if (!validator.test(input)) throw new IllegalArgumentException();
                return input;
            } catch (IllegalArgumentException e){
                console.printError(type + " должно быть типа String!" + errMessage);
            }
        }
    }

    public Enum askEnum(Enum[] values, String enumName, Predicate<T> validator){ // дописать валидатор на инвалидформ
        while(true) {
            console.println("Возможные " + enumName + ": ");
            for (Enum value: values){
                console.println(value.toString());
            }

            console.println("Введите " + enumName + ": ");
            String input = scanner.nextLine().trim();
            try{
                for (Enum value: values){
                    if (value.toString().equals(input.toUpperCase())){
                        return value;
                    }
                }
            } catch (IllegalArgumentException e){
                console.printError("Такого значения нет в списке!");
                // if (Console.isFileMode()) дописать ошибку в файле
            }
        }
    }

    public Integer askInteger(String type, Predicate<Integer> validator, String errMessage) {
        while (true) {
            console.println("Введите " + type + ": ");
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

    public Float askFloat(String type, Predicate<Float> validator, String errMessage) {
        while (true) {
            console.println("Введите " + type + ": ");
            String input = scanner.nextLine().trim();
            try {
                Float num = Float.parseFloat(input);
                if (!validator.test(num)) throw new IllegalArgumentException(); // дописать инвалид форм
                return num;
            } catch (IllegalArgumentException e) {
                console.printError(type + " должна быть числом типа Float!" + errMessage);
            }
        }
    }

    public Double askDouble(String type, Predicate<Double> validator, String errMessage) {
        while (true) {
            console.println("Введите " + type + ": ");
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
