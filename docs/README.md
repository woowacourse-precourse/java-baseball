## **아래 규칙을 최대한 만족하기**

1. 객체지향 생활체조 원칙 9가지
2. Java conventions
3. Git commit conventions
4. clean code
5. test code
6. unit test naming



## **구현 기능 목록**

1. 게임

	1. 숫자 야구 게임을 시작합니다. 출력 (단, 연속으로 이어진 게임에서는 출력 X)

	2. 컴퓨터에서 랜덤값 Random 지정
		Random 값은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 활용

	  3. 입력값 받기

		입력값은 사용자가 입력하는 값 :  `camp.nextstep.edu.missionutils.Console`의 `readLine()` 사용 

		입력값 wrapper class 로 받아서 예외 처리 하기

		- 3자리의 수를 입력받는지 확인
		- 1~9까지 서로 다른 수를 입력받는지 확인
		- 1~9 까지 값 입력 받는지 확인
		- 정상 값 : getInput 메서드를 통해 값 추출
		- 잘못된 값 : throw new IllegalArgumentException(); 으로 예외처리 

	  4. 입력값 3값을 상대방(컴퓨터)의 수와 비교

	       1. 반복문을 통해 3자리 탐색하여 같은 자리에 같은 값이 있는지 카운트
	       	- 카운트 값 '0' 이면 출력 x
	       	
	       	- 카운트 값 '1~2' : '카운트 값' + 스트라이크 출력
	       	
	       	- 카운트 값 '3'   : "3스트라이크  \n 3개의 숫자를 모두 맞히셨습니다! 게임 종료"
	       	
	         2. 반복문을 통해 3자리 탐색하여 다른 자리에 같은 값이 있는지 카운트
	       	  - 카운트 값 '0' 이면 출력 x
	       	
	       	- 카운트 값 '1~3' : '카운트 값' + 볼 출력
	       	
	       	- 출력값이 없는 경우 '낫싱' 출력
	
	  5. 4번에서 게임이 끝난경우 "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력
	
	       - "1" 입력시 게임 다시 시작
	
	       - "2" 입력시 게임 종료

