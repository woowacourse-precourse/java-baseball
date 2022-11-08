package baseball;

public class BaseballGame {

    private static BaseballGameInputFilter inputFilter = BaseballGameInputFilter.getInstance();


    public String getInputNumbers(){
        return inputFilter.readNumbers();
    }

}
