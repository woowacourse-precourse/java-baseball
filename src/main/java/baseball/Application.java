package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.*;

/*camp.nextstep.edu.missionutils에서 제공하는 Randoms 
 * 및 Console API를 사용하여 구현해야 한다.*/

class baseball {
	
	int user_num;
	Scanner number = new Scanner(System.in);
	Scanner repeat_Yes = new Scanner(System.in);
	int repeat;
	int result_num;
	List<Integer> tmp_List = new ArrayList<>(3);
	List<Integer> correct = new ArrayList<>(3);
	
	baseball(){
		System.out.println("숫자 야구 게임을 시작합니다.");
		game();
	}
	
	void getrandomNum() {
		while (correct.size() < 3) {
		    int randomNumber = Randoms.pickNumberInRange(1, 9);
		    if (!correct.contains(randomNumber)) {
		        correct.add(randomNumber);
		    }
		}
	}

	
	int repeat_game(){
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return repeat_Yes.nextInt();
	}
	
	void get_user_input_num() {
		System.out.println("숫자를 입력해주세요 : "); //get_user_input_num 구현완료
		user_num = number.nextInt();
		
		int one = user_num / 100;
		int two = user_num / 10 % 10;
		int three = user_num % 10;

		
		int cipher;
		
		for(cipher = 0; cipher < 3; cipher++) {
			if(cipher == 0) {
				tmp_List.add(cipher, one);
			}
			else if(cipher == 1) {
				tmp_List.add(cipher, two);
			}
			else if(cipher == 2) {
				tmp_List.add(cipher, three);
			}
		}
	}
	
	void game() {
		do {
		
		getrandomNum();
		get_user_input_num();
		do {
		compare();
		}while(result());
		
		//System.out.println("숫자를 모두 맞히셨습니다! 게임 종료");
		}while(repeat_game() == 1);
		
	}
	
	boolean result() {
		//random사용해서 정답과 비교수를 compare로 넘김
		result_num = 713;
		user_num = 713;
		return true;
		

		
	}
	
	void compare() {
		int ball = 0;
		int strike = 0;
		int cipher;
		for(cipher = 0; cipher < 3; cipher++ ) {
			if(tmp_List.get(cipher) == correct.get(cipher)) {
				strike++;
			}
			
			else if(tmp_List.contains(correct.get(cipher))) {
				ball++;
			}
			
		}
		System.out.println("result : " + correct);
		System.out.println(tmp_List);
		if(ball > 0 && strike > 0) {
			System.out.println(ball + "볼 " + strike + "스트라이크");
		}else if(ball > 0 && strike < 1) {
			System.out.println(ball +"볼");
		}else if(ball < 1 && strike > 0) {
			System.out.println(strike +"스트라이크");
		}else if(ball < 1 && strike < 1) {
			System.out.println("낫싱");
		}
	}
	
}




public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	//야구게임
    baseball baseball_game = new baseball();

    }
}

