package baseball.Output;


public class OutputManager implements OutputManageable{
    @Override
    public void output(String message) {
        System.out.print(message);
    }
}
