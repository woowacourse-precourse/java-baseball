### 기능 목록
1. 컴퓨터의 수를 랜덤으로 정하는 기능
- 라이브러리 참고 Randoms의 pickNumberInRange() 활용
2. 사용자의 수를 입력받는다. System.in, Scanner
- 라이브러리 참고 Console의 readLine() 활용
- 숫자의 개수가 3이 아닌지 판단하는 기능(숫자개수판단) : user의 크기가 3인지 아닌지 체크
- 숫자가 아닌 문자가 있는지 판단하는 기능(숫자인지판단) : user의 각 요소가 1이상 9이하인지 체크
- 같은 수가 있는지 판단하는 기능(중복숫자판단) 
- 있다면 IllegalArgumentExceptin 발생시켜 애플리케이션 종료
3. 컴퓨터와 사용자를 비교하는 기능
- 같은 수(int sameNumber)가 있는지 체크하는 기능.(숫자비교)
- 있다면 자리가 일치하는지 체크하는 기능.(같은숫자자리비교)
- 볼, 스트라이크, 낫싱 출력 기능
- int strike = 일치하는 자리수. int ball = sameNumber - strike
- 일치하는 자리수(strike)가 3이라면, 게임종료
4. 게임 재시작/종료 정하는 기능 (int RestartOrExit(int number) {})
- "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요" 출력
- 