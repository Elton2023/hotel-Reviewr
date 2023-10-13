package pakages.exceptionHandeling;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(){
        super("Sorry!!!!!!!!!!1Resource Not found :-(");
    }

    public ResourceNotFoundException(String message){
        super("Sorry!!!!!!!!!!1Resource Not found because"+message);

    }
}