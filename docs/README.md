### 📌 기능 리스트업
💡 구현 기능 <br> 🚫 예외 사항
- ```스트라이크``` : number & position
- ```볼``` : number & !position
- ```낫싱``` : !number & !position 

1. 컴퓨터가 ```서로 다른 임의의 수``` 3개 선택
   - 💡 ```Randoms.pickNumberInRange``` 으로 랜덤 값(List Integer Type) 추출
     - addRandomNumber() 에서 값을 리스트에 넣고, initComputerNumber()에서 반환


2. 사용자가 (컴퓨터가 생각하고 있는) ```서로 다른``` 3개의 숫자를 입력
   - 💡 잘못된 값 입력시 종료 : ```IllegalArgumentException``` 발생후 프로그램 종료
     - handleException()
   - 🚫 입력 값이 String Type 의 숫자가 아닌 경우 : readLine()의 리턴값 String
     - isAllNumeric()
   - 🚫 값이 3개가 아닌 경우 = 문자열의 길이가 3이 아닌 경우
     - inValidLength()
   - 💡 String Type의 숫자 값을 하나씩 쪼개어 List Integer Type으로 만드는 기능
     - stringToList()
   - 🚫 값의 범위가 1 ~ 9가 아닌 경우 = (값의 범위가 1 ~ 9가 아니고, 숫자가 아닌 값)
     - isInvalidRange()
   - 🚫 서로 다른 값이 아닌 경우
     - deduplicated() 으로 중복 제거 리스트를 반환해 checkDuplicate() 중복 요소 유무 확인


3. 컴퓨터는 사용자 숫자에 대한 결과 출력 : ```스트라이크, 볼, 낫싱```
   - ~~결과 값을 저장할 2자리 수의 List 생성~~
   - 스트라이크, 볼 변수를 만들고 값을 받을 수 있는 getter 생성
     - getStrike(), getBall()
   - 💡 ```List(컴퓨터 랜덤 값) List(사용자 입력 값)```의 같은 자리 값을 확인하는 기능
     - checkStrike()
     - 사용자 숫자에 맞는 결과값을 strike + 1 갱신한다.
   - 💡 ```List(컴퓨터 랜덤 값)``` 에 사용자 번호와 같은 번호를 포함하는지 확인
     - checkBall()
   - ```스트라이크``` : number & position, 숫자가 같고 + 같은 위치
   - ```볼``` : number & !position, 숫자가 같고 + 다른 위치
   - ```낫싱``` : 스트라이크와 볼이 없는 경우
   - 💡 스트라이크와 볼의 값에 중복이 있는 경우 어떻게 처리할 것인가?
     - ~~sameNumber : 같은 숫자의 개수 확인~~
     - ~~samePosition : 같은 위치의 숫자 개수 확인~~
     - ~~List(samePosition, sameNumber - samePosition)~~
     - getBall() = ```this.ball - this.strike```
     - 💡 스트라이크와 볼이 0이면 ```낫싱``` 아니면 스트라이크, 볼 출력
       - getScore()


4. 이 과정을 반복해 3개의 숫자를 모두 맞히면 게임 종료
   - 💡 스트라이크 점수가 3이면, 게임 종료
     - stopGame()
   - 💡 아니면, 2번으로 되돌아간다.
     - stopProgram()

    
5. 게임 종료 후, ```게임 다시 시작(1)```, ```프로그램 종료(2)```가 가능하다.
   - 💡 1, 2가 아닌 다른 값이 입력된 경우(1,2가 아니고, 숫자가 아닌 값)
     - checkExecution()
   - ```게임 다시 시작``` 이 입력되면 1번(컴퓨터 랜덤 값 초기화)으로 or 2번으로 돌아가기? 
     - 🚫 isInvalidInput() : 잘못된 값 입력시 ```IllegalArgumentException``` 발생 프로그램 종료

     - 이전에 입력한 123의 값의 결과값 : 1볼 1스트라이크
     - 새 게임에서 입력한 123의 결과 값이 : 1볼
     - 서로 다르기 때문에 컴퓨터 랜덤 값 초기화가 이루어졌다는 것을 볼 수 있다.
   - 💡 ```게임 다시 시작``` 이 입력되면 1번으로 돌아간다.
     - restartGame()
   - 💡 ```프로그램 종료``` 이 입력되면 프로그램을 종료한다.
     - stopProgram()
```text
숫자를 입력해주세요 : 123
1볼 1스트라이크
...
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
```



### 📌 라이브러리 
- ```camp.nextstep.edu.missionutils``` 사용
- ```Randoms.pickNumberInRange(start, end)``` : Random 값 추출
  - return 값 start + 0부터 (end - start + 1)까지의 랜덤한 숫자
  - ex. (1, 9) : start + next(9) 1부터 9까지의 랜덤한 숫자
- ```validateRange(start, end)``` : 유효한 범위 체크
  - start보다 end가 클 수 없다. : validateRange(9, 1)
  - end는 Integer.MAX_VALUE보다 클 수 없다. : validateRange(1, MAX)
  - start와 end의 차이 값이 너무 크면 안된다. : end - start >= MAX
```java
public static int pickNumberInRange(final int startInclusive, final int endInclusive) {
        validateRange(startInclusive, endInclusive);
        return startInclusive + defaultRandom.nextInt(endInclusive - startInclusive + 1);
}
```
- ```Console.readLine()``` : String type / 사용자의 입력 값
```java
public static String readLine() {
    return getInstance().nextLine();
}
```


