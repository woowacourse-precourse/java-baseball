## 개요

________

0. 상수와 메세지
    - 매직넘버를 최대한 상수로 정의해서 숫자의 의도 나타내기
    - 메세지를 상수로 지정해서 메세지 수정이 쉽게하기
1. 랜덤 숫자 뽑기
    - 중복없이 랜덤으로 범위 안의 3개의 숫자 뽑기
2. 숫자 받기
    - 입력받은 숫자의 에러를 체크하고 여러 특징을 담아 두는 클래스
    - 길이, 입력된 문자의 코드 체크
        1. UserNumber
            - 입력받은 숫자의 중복여부도 체크하기
            - 볼/스트라이크을 리턴하는 메서드도 구현
        2. Restart
3. 게임
    - 숫자 뽑기, 숫자받기 메서드로 숫자 야구를 하는 클래스
    - 메세지를 출력하거나 입력을 받는 역할을 수행
4. 어플리케이션
    - 게임의 반복, 게임의 재시작 여부등을 체크하는 역할을 수행
----------------------------------
## 구현

________________________

### **ConstantAndMessage**
숫자 길이 3, 최소숫자 1, 최대숫자 9, 허용된 숫자 1~9, 재시작 숫자 1, 끝내기 숫자 2를 상수로 저장하고 
스트라이크, 볼, 낫싱, 게임 시작, 끝 메세지 등을 String형으로 상수로 저장

### **NonDuplicateRandomNumber**
- 메서드

| 메서드명            | 기능                                 |
|-----------------|------------------------------------|
| makingNumbers() | 중복되지 않는 3개의 숫자를 List\<Integer>로 리턴 |

--------------------------------------
### **NumberInput**
추상 클래스로 사용자가 입력한 숫자를 관리하는 클래스에 상속
- 필드

| 객체                             | 기능                         |
|--------------------------------|----------------------------|
| List<Integer> _inputNumber_    | 유저의 숫자 입력을 List형태로 담아 두는 곳 |
| int _inputLength_              | 숫자 입력의 길이                  |
| List<Integer> _allowedNumbers_ | 입력으로 허용되는 숫자를 담아두는 곳       |
- 메서드

| 메서드명                    | 기능                                                     |
|-------------------------|--------------------------------------------------------|
| **NumberInput**(String) | 생성자로 String형태로 받은 입력을 List로 변환해 _inputNumber_ 에 저장     |
| **checkingLength**()    | _inputNumber_ 의 길이가   _inputLength_ 와 비교해 같지않으면 에러발생   |
| **checkingNumbers**()   | _inputNumber_ 의 숫자가 _allowedNumbers_ 에 없는 숫자일 경우 에러 발생 |
| **makingError**()       | 호출시 IllegalArgumentException을 발생시킴                     |
| **errorChecking**();    | 에러 체크 메서드를 모두 호출하는 메서드                                 |
---------------------------
### **User**
야구 게임 중 유저의 입력을 관리하는 클래스, **NumberInput**을 상속
- 메서드

| 메서드명                       | 기능                                                                                    |
|----------------------------|---------------------------------------------------------------------------------------|
| **User**(String)           | _inputLength_ 를 3으로 _allowedNumbers_ 에 1~9를 담고 입력받은 String을 List로  _inputNumber_ 에 담음 |
| **errorChecking**()        | **checkingLength** **checkingNumbers** **checkingDuplication** 을 호출해 길이, 중복, 범위를 체크함  |
| **checkingDuplication**()  | _inputNumber_ 의 중복을 체크하고 중복이 있으면 에러를 발생시킴                                             |
| **strike**(List\<Integer>) | 인자로 받은 List와 _inputNumber_ 를 비교하여 스트라이크를 int로 리턴                                      |
| **ball**(List\<Integer>)   | 인자로 받은 List와 _inputNumber_ 를 비교하여 볼을 int로 반환                                          |
-------------------------------------------
### **Restart**
재시작 여부를 체크하는 숫자를 관리하는 클래스, **NumberInput**을 상속
- 메서드

| 메서드명                | 기능                                                                                    |
|---------------------|---------------------------------------------------------------------------------------|
| **Restart**(String) | _inputLength_ 를 1으로 _allowedNumbers_ 에 1,2를 담고 입력받은 String을 List로  _inputNumber_ 에 담음 |
| **wantTerminate**() | 종료 희망 숫자와 inputNumber의 첫번째 숫자가 동일하면 true를 반환                                          |
| **errorChecking**() | **checkingLength**() **checkingNumbers**()를 호출해 길이, 범위를 체크                            |

### **NumberBaseBallGame**
숫자 야구를 진행하는 클래스
- 필드

| 객체                        | 기능                 |
|---------------------------|--------------------|
| int _strike_              | 스트라이크 카운터          |
| int _ball_                | 볼 카운터              |
| List\<Integer> _computer_ | 컴퓨터의 숫자를 list로 담아둠 |

- 메서드

| 메서드명                                   | 기능                                                                                           |
|----------------------------------------|----------------------------------------------------------------------------------------------|
| **NumberBaseBallGame**(List<\Integer>) | 생성자이며 받은 인자를 _computer_ 에 저장하고 _strike_ 와 _ball_ 을 모두 0 으로 초기화                               |
| **playGame**()                         | _strike_ 가 3이 될때 까지 계속 반복하며 **getUserNumber**() **printMessage**()를 호출하며 반복 종료시 종료 메세지 출력    |
| **getUserNumber**()                    | 입력받은 숫자를 인자로 User 클래스를 생성하고 .**errorChecking**()으로 에러 상황 확인 후 **compareUserAndComputer**()호출 |
| **compareUserAndComputer**(User)       | **User**객체의 **Ball**(List) ,**Strike**(List) 메서드에 _computer_ 를 인자로 호출하여 _strike_ _ball_ 설정   |
| **printMessage**()                     | 모든 출력 메서드를 호출하고 공백, 개행을 해줌                                                                   |
| **printNothing**()                     | *strike* 와 *ball* 모두 0일 경우  "낫싱"을 출력                                                         |
| **printBall**()                        | *ball*이 1이상일 경우 _ball_ 과 "볼"을 출력                                                             |
| **printStrike**()                      | *strike*가 1이상일 경우 _strike_ 와 "스트라이크"을 출력                                                     |

### **Application**
1. 게임 시작 메세지를 출력하고 반복문을 시작한다.
2. computer에 NonDuplicateRandomNumber.makingNumbers()을 이용해 만들어진 3개의 랜덤 숫자를 담는다.
3. computer를 인자로 game 이라는 NumberBaseBallGame객체를 만든다.
4. game.playGame()을 호출하고 재시작 여부를 묻는 메세지를 호출한다.
5. Restart객체를 readLine 메서드로 받은 입력을 생성자의 인자로 restart를 생성한다.
6. restart의 errorChecking()을 활용해 에러를 확인하고 wantTerminate()가 true면 반복문을 종료한다.
7. false라면 2. 로 돌아간다.


