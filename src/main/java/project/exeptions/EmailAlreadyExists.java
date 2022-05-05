package project.exeptions;

public class EmailAlreadyExists extends Exception {

    public EmailAlreadyExists(String msg){
        super(msg);
    }
}
