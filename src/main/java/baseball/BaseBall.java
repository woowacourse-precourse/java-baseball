package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBall {
    public static final int NUMBER_LENGTH = 3;
    private Computer computer;
    private Player player;
    public BaseBall(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void init() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean flag;
        do {
            player.input();
            flag = printResult();
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

    private String buildResultSentence(int strike, int ball){
        StringBuilder sb = new StringBuilder();
        if(ball != 0){
            sb.append(ball).append("볼 ");
        }
        if(strike != 0){
            sb.append(strike).append("스트라이크");
        }
        if(ball == 0 && strike == 0){
            sb.append("낫싱");
        }
        return sb.toString().strip();
    }


    public boolean printResult() {
        int[] strikeAndBallCount = getStrikeAndBallCount(player.getNumber());
        int strike = strikeAndBallCount[0];
        int ball = strikeAndBallCount[1];

        if(strike == NUMBER_LENGTH){
            System.out.println(buildResultSentence(strike, ball));
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }else{
            System.out.println(buildResultSentence(strike, ball));
            return true;
        }
    }

    private int[] getStrikeAndBallCount(List<Integer> playerNumber) {
        int[] cnt = new int[2];
        for(int i=0; i<playerNumber.size(); i++){
            if(computer.getNumber().get(i) == playerNumber.get(i)){
                cnt[0]++;
            }else if(computer.getNumber().contains(playerNumber.get(i))){
                cnt[1]++;
            }
        }
        return cnt;
    }
}
