package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Input_Output {
    List<Integer> computer = new ArrayList<>();
    List<Integer> Scan = new ArrayList<>();
    String End_Number;

    public void Computer_RandomNumber() {//컴퓨터 랜덤 숫자 생성

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))//List에 숫자가 없으면 추가
                computer.add(randomNumber);
        }
    }

    public void User_enter() {//유저 숫자 입력
        String Number = Console.readLine();
        int a = Integer.parseInt(Number);

        for (int i = 1; i < Number.length() + 1; i++) {//랜덤숫자가 저장된 리스트형태로 변환
            Scan.add(a % 10);
            a /= 10;
        }

        Collections.reverse(Scan);
    }

    public void User_File_Check()//사용자 입력 중 예외 사항 체크
    {
        if(Scan.size()>3)
            throw new IllegalArgumentException();

    }

    public void Ending_Enter()
    {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        End_Number=Console.readLine();

    }
}
