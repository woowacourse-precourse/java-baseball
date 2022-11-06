### 우테코 2주차 기능 목록

---
컴퓨터가 서로 다른 임의의 수 3개를 선택하는 기능
* 함수명 : `setComputer`
* parameter : void
* return : List (computer)

<br>

사용자가 입력한 값이 예외적인지 판별하는 기능
* 예외의 정의
    * 중복된 숫자
    * 1~9까지가 아닌 숫자 (0이나 10 같은 수)
    * 3자리 미만이거나 이상의 숫자
* 함수명 : `checkUserHasException`
* parameter : List (user)
* return : void

<br>

스트라이크와 볼의 개수를 세어주는 기능
* 안에서 isStrike 와 isBall 사용
* '낫싱', '몇 볼 몇 스트라이크', '3스트라이크'를 해당 메소드 안에서 출력
* 함수명 : `countStrikeBall`
* parameter : List (user), List (computer)
* return : boolean 
  * user가 정답을 맞추면 true
  * user가 정답을 맞추지 못하면 false 

<br>

사용자가 입력한 값이 볼인지 판별하는 기능
* 함수명 : `isBall`
* parameter : List(computer), int(user), int(userIndex) 
* return : int
  * ball이면 ball의 개수를 count할 수 있도록 1 리턴
  * ball이 아니라면 0 리턴

<br>

사용자가 입력한 값이 스트라이크인지 판별하는 기능
* 함수명 : `isStrike`
* parameter : List(computer), int(user), int(userIndex)
* return : int
  * strike면 strike의 개수를 count할 수 있도록 1 리턴
  * strike가 아니라면 0 리턴

<br>

입력값이 1인지 판별하는 기능
* 함수명 : `isValueToStopGame`
* parameter : int
* return : boolean


