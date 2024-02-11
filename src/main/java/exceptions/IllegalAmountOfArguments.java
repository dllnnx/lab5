package exceptions;

public class IllegalAmountOfArguments extends RuntimeException{
    @Override
    public String toString() {
        return "Неверное количество аргументов!";
    }
}
