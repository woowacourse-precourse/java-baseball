package baseball.view;

public class Console implements View{
    @Override
    public void initialStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void requestGuess() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void result() {

    }

    @Override
    public void end() {

    }

    @Override
    public void askRetry() {

    }
}
