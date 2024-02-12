package exceptions;

public class NoSuchIdException extends RuntimeException{

    @Override
    public String toString() {
        return "Нет элемента с таким id в коллекции!";
    }
}
