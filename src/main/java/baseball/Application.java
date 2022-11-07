package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
	static int start = 1;
	static String startMessage = "숫자 야구 게임을 시작합니다.";
	static String inputMessage = "숫자를 입력해주세요 : ";
	static List<Integer> computer = new ArrayList<>();
	static List<Integer> inputList = new ArrayList<>();
	static String inputNumber = "";
	static boolean inputCheck = false;
	static boolean exceptionCheck = false;
	static int strike = 0;
	static int ball = 0;
	
    public static void main(String[] args) {
    	// 게임 시작 메시지 출력.
		gameStart();
		
    	while(start==1) {
	    	// 랜덤 수 발생
    		computer = makeComputer();
    		// 게임 실행 메서드
    		game();
    	}
    	
    	
    }
    
    // 게임 시작 출력 메서드
    public static void gameStart() {
    	System.out.println(startMessage);
    }
    
    // 컴퓨터 수 생성 메서드
    public static List<Integer> makeComputer() {
    	
    	List<Integer> list = new ArrayList<>();
    	
    	while (list.size() < 3) {
    	    int randomNumber = Randoms.pickNumberInRange(1, 9);
    	    
    	    if (!list.contains(randomNumber)) {
    	    	list.add(randomNumber);
    	    }
    	}
    	
    	return list;
    }
    
    //게임 실행 메서드
    public static void game() {
    	ball = 0;
		strike = 0;
		
    	// 사용자 입력 메서드
    	while(strike!=3) {
    		
    		inputNumber = inputNumber();
    		
    		exceptionCheck = checkException();
    		
    		if(exceptionCheck) {
    			//두 수 비교 메서드
    			ball = 0;
    			strike = 0;
    			compare(computer,inputNumber);
    		}
    		else {
    			throw new IllegalArgumentException();
    		}
    		
    		resultPrint(ball, strike);
    	}
    }
    
    // 사용자 입력 메서드
    public static String inputNumber() {
    	
    	System.out.print(inputMessage);
    	
    	String s = Console.readLine();
    	
    	return s;
    }
    
    // 예외 발생 확인 메서드
    public static boolean checkException() {
    	if(inputNumber.length()==3&&!inputNumber.contains("0")&&checkType(inputNumber)&&checkDiff(inputNumber)) {
    		return true;
    	}else
    		return false;
    }
    
    // 정수 입력 확인
    public static boolean checkType(String inputNumber) {
    	
    	char[] arr = inputNumber.toCharArray();
    	boolean check = true;
    	
    	for(int i=0;i<arr.length;i++) {
    		if(!Character.isDigit(arr[i])) check = false;
    	}
    	
    	if(check)
    		return true;
    	else
    		return false;
    }
    // 다른 숫자 3개로 이루어져 있는지 확인
    public static boolean checkDiff(String inputNumber) {
    	char[] arr = inputNumber.toCharArray();
    	Map<Character,Object> inputMap = new HashMap<>();
    	
    	for(int i=0;i<arr.length;i++) {
    		inputMap.put(arr[i],"");
    	}
    	
    	if(inputMap.size()!=3)return false;
    	else return true;
    }
    // 컴퓨터 수와 사용자 수 비교
    public static void compare(List<Integer> computer, String inputNumber) {
    	char[] arr = inputNumber.toCharArray();
    	for(int i=0;i<arr.length;i++) {
    		if(computer.indexOf(Character.getNumericValue(arr[i]))==i) {
    			strike+=1;
    		}else if(computer.contains(Character.getNumericValue(arr[i])))
    			ball+=1;
    		}
    }
    
    // 결과 출력 메서드
    public static void resultPrint(int ball, int strike) {
    	
    	if(strike==0&&ball==0) {
    		System.out.println("낫싱");
    	}
    	else if(strike<3&&ball==0) {
    		System.out.println(strike + "스트라이크");
    	}
    	else if(strike==0&&ball!=0) {
    		System.out.println(ball + "볼");
    	}
    	else if(strike==3) {
    		start = successMessage();
    	}
    	else {
    		System.out.println(ball+"볼"+" "+strike + "스트라이크");
    	}
    }
    
    // 3스트라이크 출력 및 게임 재시작 메서드
    public static int successMessage() {
    	int coin = 0;
    	System.out.println(strike+"스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		coin = Integer.parseInt(Console.readLine());
		return coin;
    }
    
}
