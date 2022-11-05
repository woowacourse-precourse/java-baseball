## 🚀 기능 요구 사항

* 1-9사이의 랜덤숫자 3자리 수를 정한다.
    * Randoms API를 이용해서 구현한다.
    * Random 값 추출은 pickNumberInRange()를 활용한다.
    * 각각의 자리는 서로 다른 숫자여야한다.
* 3자리 수를 입력받는다.
    * Console.readLine()를 이용한다.
    * 3자리 수가 아니면 IllegalArgumentException 발생시킨다
    * 서로다른 수가 아니면 IllegalArgumentException 발생시킨다
* 입력된 값에 따라 힌트를 구분한다.
* 게임의 승패 유무를 판단한다.
* 게임 끝나면 재시작할 지 종료할 지를 출력한다.
    * Console.readLine()를 이용한다.
    * 1일때 게임을 계속한다.
    * 2일때 게임을 종료한다.
    * 나머지 입력값은 IllegalArgumentException 발생시킨다