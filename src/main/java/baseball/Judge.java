package baseball;

public class Judge {
  private Computer computer;
  private Player player;

  public Judge(boolean progress){
    this.player = new Player(progress);
    this.computer = new Computer();
    System.out.println("숫자 야구 게임을 시작합니다.");
  }
}
