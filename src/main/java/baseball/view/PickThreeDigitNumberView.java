package baseball.view;

public class PickThreeDigitNumberView extends View{
    private String response = "";

    @Override
    public void show() {
        this.response = readLine("숫자를 입력해주세요");
    }

    @Override
    public String getResponse() {
        return this.response;
    }
}