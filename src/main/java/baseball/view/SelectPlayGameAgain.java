package baseball.view;

public class SelectPlayGameAgain extends View {
    private String response = "";

    @Override
    public void show() {
        this.response = readLine("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    @Override
    public String getResponse() {
        return this.response;
    }
}
