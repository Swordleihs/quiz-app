package domain.Exceptions;

public class DomainException extends RuntimeException {
    public DomainException(String s){
        super(s);
    }
    public DomainException(){
        super();
    }
}
