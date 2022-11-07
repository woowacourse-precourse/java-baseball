package abstracts;

import baseball.Constants.Status;

/**
 * "만약 숫자 야구 게임 뿐만 아니라 여러 미니게임을 가진 게임팩을 만든다면 어떻게 해야할까?"
 * 라는 생각으로, 쉽게 확장할 수 있도록 하기 위해 작성된 추상클래스입니다.
 */
public abstract class Game {


    protected Status status;
    protected String gameName;


    public Status getStatus() {
        return this.status;
    }
    public String getGameName() {
        return this.gameName;
    }

    protected void setStatus(Status status) {
        this.status = status;
    }


    public abstract void initialize();
    public abstract void terminate();
    public abstract boolean operate(String input);

}
