package baseball.model;

public class UserTerminate {
    private String inputString;
    private Integer terminate;

    public UserTerminate(String inputString){
        this.inputString = inputString;
    }

    public Integer getTerminate(){
        return this.terminate;
    }

    public void convertStringToInteger(){
        this.terminate = Integer.parseInt(this.inputString);
    }
}
