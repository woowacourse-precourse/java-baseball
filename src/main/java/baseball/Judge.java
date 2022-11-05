package baseball;

public class Judge {
  private Computer computer;
  private Player player;

  public Judge(){
    this.player = new Player();
    this.computer = new Computer();
    System.out.println("숫자 야구 게임을 시작합니다.");
  }
}
