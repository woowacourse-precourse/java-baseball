package baseball;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.*;


public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
		Computer computer = new Computer();
		int restartOrEnd = 0;

		while (true){
			if (restartOrEnd==1) computer=new Computer();
			System.out.print("숫자를 입력해주세요 : ");
			User user = new User();

			Match match = new Match(computer,user);
			restartOrEnd = match.play();

			if (restartOrEnd==2) break;
		}


    }
}
