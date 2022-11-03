package baseball;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	/* 
    	 * 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
    	 * 3항 연산자를 쓰지 않는다.
    	 * indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
			예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
			힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
    	 */
    	// 서로 다른 3자리수   
       	System.out.println("숫자 야구 게임을 시작합니다.");
       	getUserNumbers();
    }   
    public static int getUserNumbers() {
    	String StringUserAnotherNumbers;
    	Pattern patternOnlyOneToNine;
    	boolean isuserNumberChecking=true;    	
    	boolean isAnotherNumberCheck;
    	while(isuserNumberChecking) {
    		isuserNumberChecking=false;
			System.out.print("숫자를 입력해주세요 : ");
	    	StringUserAnotherNumbers = camp.nextstep.edu.missionutils.Console.readLine(); // 라이브러리    	  
	    	patternOnlyOneToNine = Pattern.compile("^[1-9]*$");
	    	Matcher matchPattern = patternOnlyOneToNine.matcher(StringUserAnotherNumbers);   
	    	char[] charFromUserNumbers=new char[StringUserAnotherNumbers.length()];
	    	for(int userNums=0; userNums<StringUserAnotherNumbers.length(); userNums++) {
	    		charFromUserNumbers[userNums]=StringUserAnotherNumbers.charAt(userNums);
	    	}
	    	for(int charNumbers=0; charNumbers<charFromUserNumbers.length; charNumbers++) {
	    		if(charNumbers!=StringUserAnotherNumbers.indexOf(StringUserAnotherNumbers.charAt(charNumbers))) isuserNumberChecking=true;	    		
	    	}
	    	if(!matchPattern.find()) {
	    		System.out.println("숫자만 입력해주세요."); 
	    		isuserNumberChecking=true;
	    	}else if(StringUserAnotherNumbers.length()>3 || StringUserAnotherNumbers.length()<3) {
	    		System.out.println("숫자를 3개 입력해야함");
	    		isuserNumberChecking=true;
	    	}else if(isuserNumberChecking) {
	    		System.out.println("서로 다른 숫자로 입력해야함");	    		
	    	} 
    	}
    	return 0;
    }
}
