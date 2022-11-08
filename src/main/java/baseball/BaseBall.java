package baseball;


import camp.nextstep.edu.missionutils.Console;

public class BaseBall {
    private Computer computer;
    private Player player;
    public BaseBall(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void init() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean flag;
        System.out.println(computer.getNumber());
        do {
            player.input();
            flag = computer.printResult(player.getNumber());
        } while (flag);

        askRestart();
    }

    private void askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String flag = Console.readLine();
        if(flag.equals("1")){
            BaseBall newGame = new BaseBall(new Computer(), player);
            newGame.init();
        } else if (flag.equals("2")) {
            return;
        }else{
            throw new IllegalArgumentException("Answer with 1 or 2");
        }
    }

}
