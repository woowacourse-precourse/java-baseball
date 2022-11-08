## 기능 요구사항

### 메인 기능
1부터 9까지 *서로 다른 수로 이루어진* 3자리의 수를 맞추는 게임 
- 같은 수와 같은 자리 = 스트라이크
- 같은 수지만 다른 자리 = 볼
- 같은 수가 전혀 없으면 = 낫싱

게임이 끝난 후 재시작(1) 또는 종료(2)

### 예외 사항
- 사용자가 잘못된 값을 입력하는 경우에는 IllegalArgumentException 발생

### 기능 구현 리스트
#### 유형별 기능 (main)
1. main은 두 개의 method로 구현되어 있다.
   1. gameProcess() : 숫자 야구 실행시키는 프로세스
   2. decideExit() : 숫자 야구 게임 종료 시 계속 진행 여부를 사용자로부터 입력받고 판별하는 프로세스

#### 유형별 기능 (입력)
1. API 사용한 입력 및 입력 조건 확인하기 - *checkInputCondition()*
   1. API 사용한 입력 - *Console.readLine()* - Application.java 기본 코드 구성
   2. 예외 발생시 IllegalArgumentException
2. 랜덤 숫자 생성 시 제공된 API 사용하기 - *createRandomNumber()*
   1. *Randoms.pickNumberInRange()* 사용
3. 게임이 끝난 이후 재시작 또는 종료에 맞게 동작하기
   1. 예외 발생하는 경우 - IllegalArgumentException 처리 - *checkExitCode()*

#### 유형별 기능 (연산 기능)
1. 숫자 포함 여부 파악
   1. 숫자 비교를 위해 integer -> List<Integer> - *convertIntegerIntoList()*
2. 스트라이크 갯수 파악하기
3. 볼 갯수 파악하기\
cf) 위 세 개의 검증이 하나의 로직으로 돌아감 -> *countBallsAndStrikes()*

#### 유형별 기능 (출력)
1. 스트라이크, 볼 갯수에 맞게 반환 문구 출력하기(ex.1볼 1스트라이크) - *getResultMessage()*
2. 정답인 경우에 해당하는 반환 문구 출력하기(3개의 숫자를 모두 맞히셨습니다! 게임 종료)

### 추가 요구사항
- indent는 depth 2까지만 허용한다.
- 3항 연산자를 사용하지 않는다.
- 함수가 단일 역할만을 책임지게 코드 구성(SRP)
- 테스트 코드로 확인한다.
- 입력과 난수 생성에 있어서는 제공되는 API 호출을 통해 구현할 것

### 코드 작성 시 주의사항
1. Java Code Convention을 지킬 것
2. 기능별 구현 및 테스트 케이스를 작성하고 commit 할 것


### Trouble Shooting
1. An illegal reflective access operation has occured
   1. 원인이 JDK 11 환경이라는 레퍼런스 존재
   2. 경고문 무시하기 위한 gradle 수정이 가능하나 미션 제약사항으로 생략

2. TDD(Test-Driven-Development)
   1. 대부분의 내부 함수는 private 접근 제한자를 두어 객체 지향과 격리성을 지켜야하나 Junit을 통한 test case 생성을 위해서는 public으로 접근이 가능하다.
   2. Junit의 창시자라고 할 수 있는 kent beck은 private 메소드를 테스트하지 말 것을 추천한다.
   3. 만약 private 메소드에 대한 test case 작성을 원할 시 Reflection을 사용할 수 있다.
   4. 이번 과제에 대해서는 Application.java 내부의 필드 값 변경(set)하는 메소드가 없으며 test case 작성을 위해 이번에는 public 접근 제한자를 사용하도록 하겠다.

3. JUnit
   1. Assertions.assertEquals : 두 개의 인자 값이 같은지 확인
   2. Assertions.assertArrayEquals : 두 배열의 값이 일치하게 들어있는지 (주소값 비교 x)
   3. assertThatThrownBy : 의도한 exception을 처리하는지 확인

4. Enum
   1. Result에 대한 response를 enum형식으로 표현하여 코드 명시성 확보
   2. 기존의 경우에 따른 Stringbuilder()를 통한 메세지 생성 대신 enum 클래스로 구현
   

### 추가 잡담 메모
1. 커밋 메세지 시작을 괜히 영어로 했다. 한글로 남길걸
2. 예외 상황을 생각하고 이에 대한 테스트 케이스를 작성하는 것이 쉽지 않다.
3. README.md 이쁘게 작성하는 방법을 알아봐야겠다.
