package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static int strike=0,ball=0;
    public static int gameSwitch=1;
    public static ArrayList<Integer> opponentNumber=new ArrayList<Integer>();
    public static ArrayList<Integer> playerNumber=new ArrayList<Integer>();

    public static void pickRandomNumber(){
        opponentNumber.clear();
        while (opponentNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!opponentNumber.contains(randomNumber)) {
                opponentNumber.add(randomNumber);
            }
        }
    }

    public static void inputPlayerNumber(){
        playerNumber.clear();
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumber=Console.readLine();

        //입력한 문자열이 세자리 수가 아닐 경우
        if(inputNumber.length()!=3){
            throw new IllegalArgumentException();
        }
        else{
            for(int i=0;i<3;++i){
                if(inputNumber.charAt(i)<'1' || inputNumber.charAt(i)>'9'){
                    throw new IllegalArgumentException();
                }
            }
        }

        for(int i=0;i<3;++i){
            playerNumber.add(inputNumber.charAt(i)-'0');
        }
    }

    public static void result(){
        strike=0;
        ball=0;
        for(int i=0;i<3;++i){
            if(opponentNumber.contains(playerNumber.get(i)) && opponentNumber.get(i)==playerNumber.get(i)){
                strike+=1;
            }
            else if(opponentNumber.contains(playerNumber.get(i)) && opponentNumber.get(i)!=playerNumber.get(i)){
                ball+=1;
            }
        }

        if(ball>0 && strike>0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
        else if(ball==0 && strike>0){
            System.out.println(strike+"스트라이크");
        }
        else if(ball>0 && strike==0){
            System.out.println(ball+"볼");
        }
        else{
            System.out.println("낫싱");
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(gameSwitch==1){
            pickRandomNumber();	

            while(strike<3){
                inputPlayerNumber();
                result();	
            }

            strike=0;
            ball=0;

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameSwitch=Integer.parseInt(Console.readLine());
            if(gameSwitch!=1 && gameSwitch!=2){
                throw new IllegalArgumentException();
            }
        }
    }
}
