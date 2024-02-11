package exceptions;

public class NoSuchIdException extends RuntimeException{
    String msg = "Нет элемента с таким id в коллекции!";

    @Override
    public String toString() {
        return msg;
    }
}
