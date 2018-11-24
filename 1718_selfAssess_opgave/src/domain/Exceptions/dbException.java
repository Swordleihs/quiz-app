package domain.Exceptions;

public class dbException extends RuntimeException {
    public dbException(){
        super();
    }
    public dbException(String ex){
        super(ex);
    }
}
