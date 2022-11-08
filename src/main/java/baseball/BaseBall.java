package baseball;


public class BaseBall {
    private Computer computer;
    public BaseBall(Computer computer) {
        this.computer = computer;
    }

    public void init(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

}
