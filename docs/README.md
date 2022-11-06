* Random API를 사용, 컴퓨터가 1-9까지 다른 수로 이루어진 3자리 숫자 생성
  * static 메서드에  저장

* 게임 플레이어 3개의 숫자 확인
  * 0을 포함할 경우 false 리턴하는 hasZero 메서드 생성
  * 중복숫자 포함할 경우 false 리턴하는 hasDuplicates 생성
  * 3자리 숫자가 아닐경우 false 리턴하는 isNumberInRange 생성
  * 3개의 메서드를 합친 isNumberValid 메서드 생성

* Console API를 사용, 게임 플레이어가 3가지의 임의의 수 입력
  * 플레이어가 입력한 3자리 숫자를 순서대로 리스트에 저장후 리턴하는 breakInteger 메서드 생성
  * isNumberValid 메서드 사용, false 리턴할 경우 IllegalArgumentException 발생

* 스트라이크 & 볼 카운트 확인
  * StrikeNumbers 메서드 생성
  * ballNumbers 메서드 생성
  * printScore 메서드 생성

* gameStart 메서드 생성
  * do-while loop 사용, printScore 메서드가 true를 리턴할때까지 반복
  * printScore 메서드가 false를 리턴하면 플레이어에게 새로운 게임 시작 메세지 프린트
  * restart 변수 생성, 값이 1일 동안에는 gameStart 메서드 반복