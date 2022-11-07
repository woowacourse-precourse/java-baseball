package baseball;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.*;

class baseball {
	
	Scanner number = new Scanner(System.in);
	List<Integer> tmp_List = new ArrayList<>(3);
	List<Integer> correct = new ArrayList<>(3);
	//int inputnum;
	
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
		System.out.println(correct);
	}
	
	/*
	 * void getInputNum() {
	 * 
	 * inputnum = Integer.valueOf(Console.readLine()); }
	 */
	
	int repeat_game(){
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int n = number.nextInt();
		return n;
	}
	
	void get_user_input_num() {
	    
		tmp_List.clear();
		System.out.println("숫자를 입력해주세요 : ");
		int n = number.nextInt();
		if(n > 999 || n < 100){
			throw new IllegalArgumentException("자리수를 확인해주세요");
		}
		
		int user_num = n;

		int one = user_num / 100;
		int two = user_num / 10 % 10;
		int three = user_num % 10;
		
		for(int cipher = 0; cipher < 3; cipher++) {
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
		compare();
		while(!result()){
				get_user_input_num();
				compare();
			}
		}while(repeat_game() == 1);
	}
	
	boolean result() {
		int cnt = 0;
		
		for(int cipher = 0; cipher < 3; cipher++) {
			if(tmp_List.get(cipher) == correct.get(cipher)) {
				cnt++;
			}
		}
		if(cnt == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			tmp_List.clear();
			correct.clear();
			return true;
		}
		return false;
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
    baseball baseball_game = new baseball();
    }
}