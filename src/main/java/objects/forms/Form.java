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

    public String askString(String type, Predicate<String> validator){
        while (true) {
            console.println("Введите " + type + ": ");
            String input = scanner.nextLine().trim();
            // добавить трай кэтч на инвалид форм
            return input;
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

    public Integer askInteger(String type, Predicate<Integer> validator) {
        while (true) {
            console.println("Введите " + type + ": ");
            String input = scanner.nextLine().trim();
            try {
                Integer num = Integer.parseInt(input);
                if (!validator.test(num)) throw new IllegalArgumentException(); // дописать инвалид форм
                return num;
            } catch (NumberFormatException e) {
                console.printError(type + " должно быть числом типа Integer!");
            } // дописать инвалид форм
        }
    }

    public Float askFloat(String type, Predicate<Float> validator) {
        while (true) {
            console.println("Введите " + type + ": ");
            String input = scanner.nextLine().trim();
            try {
                Float num = Float.parseFloat(input);
                if (!validator.test(num)) throw new IllegalArgumentException(); // дописать инвалид форм
                return num;
            } catch (NumberFormatException e) {
                console.printError(type + " должно быть числом типа Float!");
            } // дописать инвалид форм
        }
    }

    public Double askDouble(String type, Predicate<Double> validator) {
        while (true) {
            console.println("Введите " + type + ": ");
            String input = scanner.nextLine().trim();
            try {
                Double num = Double.parseDouble(input);
                if (!validator.test(num)) throw new IllegalArgumentException(); // дописать инвалид форм
                return num;
            } catch (NumberFormatException e) {
                console.printError(type + " должно быть числом типа Float!");
            } // дописать инвалид форм
        }
    }

}
