package baseball;


public class BaseBall {
    private Computer computer;
    private Player player;
    public BaseBall(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void init(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        player.input();
    }

}
