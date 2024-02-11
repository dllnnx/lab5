package exceptions;

public class NoSuchIdException extends Exception{
    String msg = "Нет элемента с таким id в коллекции!";
    public NoSuchIdException() {
        super();
    }

    @Override
    public String toString() {
        return msg;
    }
}
