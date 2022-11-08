package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Computer {
    private ArrayList<Integer> computerNumberList; // 컴퓨터 숫자(서로 다른 임의의 숫자 세 개)를 담고 있는 Arraylist
    private int strikeCount; // 플레이어가 입력한 숫자의 대한 결과 중 스트라이크 개수
    private int ballCount; // 플레이어가 입력한 숫자의 대한 결과 중 볼 개수

    public Computer() // 객체 생성 시, 자동으로 컴퓨터 숫자가 정해짐
    {
        generateComputerNumberList();
    }

    private void generateComputerNumberList() // 무작위로 컴퓨터 숫자 정함
    {
        ArrayList<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        this.computerNumberList = numberList;
    }

    public int countStrike(ArrayList<Integer> input) // 스트라이크 개수 파악
    {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (input.get(i) == computerNumberList.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int countBall(ArrayList<Integer> input) // 볼 개수 파악
    {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (input.contains(computerNumberList.get(i)) && input.get(i) != computerNumberList.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public void setStrikeCount(int strikeCount) // 스트라이크 개수 설정
    {
        this.strikeCount = strikeCount;
    }

    public void setBallCount(int ballCount) // 볼 개수 설정
    {
        this.ballCount = ballCount;
    }

    public void printResult() // 플레이어가 입력한 숫자에 대한 결과 출력
    {
        String result="";
        if(ballCount !=0){
            result+=Integer.toString(ballCount)+"볼 ";
        }
        if(strikeCount!=0){
            result+=Integer.toString(strikeCount)+"스트라이크";
        }
        else if(ballCount ==0 && strikeCount==0){
            result+="낫싱";
        }
        System.out.println(result);
    }

    public boolean endGame() // 게임이 끝났는지 확인
    {
        if(strikeCount==3){
            return true;
        }
        return false;
    }
}
