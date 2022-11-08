package baseball;

import java.util.List;

public class Game {
    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            //게임에 필요한 객체 생성
            Computer computer = new Computer();
            User user = new User();

            // 컴퓨터 랜덤 변수 생성
            computer.setRandomComputerNumber();

            // 숫자 맞추기 시작
            progressGame(computer,user);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            user.setGameCoin();

            if (user.getGameCoin().equals("2")) break;
        }
    }

    public void progressGame(Computer computer, User user){
        while (true) {
            user.setUserNumber();

            // 맞춘다면 반복문 빠져나오기
            if (isComputerNumber(computer.getComputerNumber(),user.getUserNumber())) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public boolean isComputerNumber(List<Integer> computerNumber, List<Integer> userNumber){
        printHint(computerNumber,userNumber);
        return computerNumber.equals(userNumber);
    }

    public void printHint(List<Integer> computerNumber, List<Integer> userNumber){
        int strike=countStrike(computerNumber,userNumber);
        int ball=countBall(computerNumber,userNumber);

        if(ball >0 && strike > 0) System.out.println(ball + "볼 " + strike + "스트라이크");
        else if (ball > 0) System.out.println(ball +"볼");
        else if(strike > 0) System.out.println(strike + "스트라이크");
        else if(ball == 0 && strike ==0) System.out.println("낫싱");
    }

    public boolean checkStrike (List<Integer> computerNumber, int userNumber, int index){
        //같은 위치의 같은 값이면 strike
        return computerNumber.get(index).equals(userNumber);
    }

    public boolean checkBall(List<Integer> computerNumber, int userNumber, int index){
        //같은 위치에 있지 않으면서 computerNumber가 userNumber를 포함하고 있으면 ball
        return computerNumber.get(index).equals(userNumber) == false && computerNumber.contains(userNumber);
    }

    public int countStrike (List<Integer> computerNumber, List<Integer> userNumber){
        int strike=0;

        for(int index = 0 ; index < 3;index++){
            if(checkStrike(computerNumber,userNumber.get(index),index)){
                strike++;
            }
        }

        return strike;
    }

    public int countBall (List<Integer> computerNumber, List<Integer> userNumber){
        int ball=0;

        for(int index = 0 ; index < 3;index++){
            if (checkBall(computerNumber,userNumber.get(index),index)){
                ball++;
            }
        }

        return ball;
    }
}
