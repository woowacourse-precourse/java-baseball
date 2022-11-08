package baseball;

public class BaseballGame {

    private static BaseballGameInputFilter inputFilter = new BaseballGameInputFilter();

    public String getInputNumbers(){
        return inputFilter.readNumbers();
    }

}
