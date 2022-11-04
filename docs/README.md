# 요구사항 분석

### 사용자의 입력 처리하기
    - 게임 진행 중의 입력인지 / 게임 진행 후 입력인지 구분하기
    - 잘못된 입력이 들어오는 경우 예외 처리하기 

### 게임 결과에 따른 출력 처리하기
    - 게임이 성공적으로 종료된 경우(숫자를 맞춘 경우)
    - 게임이 비정상적으로 종료된 경우(에러가 발생한 경우)

### 게임 진행 관련
#### 게임 시작 전
      - 랜덤한 타깃 숫자 생성하기

#### 게임 도중
      - 사용자가 입력한 숫자와 타깃 숫자를 비교, 스트라이크 / 볼 개수 구하기
      - 사용자가 타깃 숫자와 같은 숫자를 입력한 경우, 게임 종료 단계로 이동
      - 예외 발생 시 게임 강제종료하기
  
#### 게임이 끝난 후
      - 게임을 다시 진행할 지 묻고, 종료 or 재실행하기
---

# 기능 구현에 필요한 인터페이스 정의 및 기능 체계화

## NumberForGame
### 게임에 사용되는 숫자의 검증과 비교 기능을 제공하는 인터페이스
    - 주어진 숫자가 유효한지 검증하는 기능(validateNumber)
    - 숫자 객체가 동일한지 비교하는 기능(getCompareResult)

## NumberGroupForGame
### 게임에 사용되는 숫자"들"의 검증과 비교 기능을 제공하는 인터페이스
    - 주어진 숫자들이 유효한지 검증하는 기능(validateNumberGroup)
    - 두 숫자 객체가 동일한지 비교해, 규칙에 따른 결과를 반환하는 기능(getCompareResult)

## InputReaderForGame
### 설정한 InputStream 으로부터 값을 받아오는 인터페이스
    - 숫자"들"을 받아오는 기능(readNumberGroup)
    - 게임 지속 여부를 받아오는 기능(readIntentionOfContinuingGame)

## OutputPrinterForGame
### 시스템으로부터 받은 값을 출력하는 인터페이스
    - 설정된 OutputStream으로 전달된 값을 출력 

## Game
### 한번의 게임 실행을 담당하는 인터페이스
    - 게임을 시작하는 기능(run)

## GameApplication
### 전체 게임 운영을 담당하는 인터페이스
    - 전체 게임 시스템을 운영하는 기능(execute)

## CompareResult -> 규칙이 변화하더라도, 데이터를 전달하는 형태는 크게 변하지 않을것으로 예상(Map)
### NumberGroup 간의 비교 결과를 담고있는 컨테이너 클래스
    - 비교 결과를 문자열 형태로 바꾸어주는 기능(toString)

## IntentionOfContinuingGame
### 게임을 계속 진행할지 여부를 저장하는 enum 객체
    - (CONTINUE / STOP)을 요소로 가짐
    - 사용자가 게임을 계속하기를 원하는지 확인하는 메서드(yes)
    - 사용자가 게임을 그만두기를 원하는지 확인하는 메서드(no)

## BaseballGameConfiguration
### Baseball 게임에 사용되는 객체들의 의존성 주입을 담당하는 객체

---

# 인터페이스 구현 클래스 목록

## NumberCompareResult
### 숫자의 비교 결과와 관련된 출력 / 일치 여부를 반환하는 기능을 제공
#### 정해진 문자열 형식으로 값을 반환하는 기능(toString)
    - 결과를 ([x 스트라이크 ][y 볼] | [낫싱])과 같은 형태로 구성된 문자열로 반환한다

#### 완벽하게 매칭되었는지 여부를 반환하는 기능(isEqual)
    - 완벽하게 일치한 경우에만 true, 그 외에는 false를 반환한다

## BaseballGameApplication
### 야구 게임 (재)실행과 관련된 기능을 제공
#### 새로운 BaseballGame 생성 기능
    - BaseballGame 객체를 생성하고, 실행함

#### 게임이 종료된 경우, 재진행 여부를 결정
    게임이 정상적으로 종료된 경우 -> 사용자로부터 재진행 여부를 입력받음
    - 1이 입력되면 게임을 다시 실행
    - 그 외의 값이 입력되는 경우 애플리케이션 종료
    
    게임이 비정상적으로 종료된 경우
    - 애플리케이션 종료

## BaseballGame
### 실제 야구 게임 운영과 관련된 기능을 제공
#### 랜덤한 타깃 숫자 생성하기(RandomNumberGenerator 사용)
    - 무작위 값을 입력받아 타깃 넘버를 생성

#### 사용자로부터 입력받은 숫자와 랜덤한 타깃 숫자의 비교 결과에 따른 동작 수행하기
    - InputReader를 통해 사용자가 입력한 숫자를 받아옴
    - 일치하는 경우, 종료 멘트 출력 후 게임 종료
    - 일치하지 않는 경우, 형식에 맞게 결과 출력 후 입력받기


## MissionInputReader
### InputReader 인터페이스 구현체
    - camp.nextstep.edu.missionutils.Console.readline() 메서드를 이용해 getUserInput을 구현

## TestInputReader
### InputReader 인터페이스 구현체
    - 원활한 테스트를 위해 static 메서드 & 실제 입력이 필요한 Console.readline()를 대체하기 위한 목적으로 사용
    - List<String>을 입력받아 readline() 수행 시 하나씩 반환

## RandomNumberGenerator
### 무작위 난수를 제공하는 인터페이스
#### 3자리 무작위 난수를 생성해 반환(generateRandomNumber)

## MissionInputReader
### InputReader 인터페이스 구현체
    - camp.nextstep.edu.missionutils.Randoms를 통해 무작위로 생성된 3자리 난수를 반환

## TestInputReader
### InputReader 인터페이스 구현체
    - 원활한 테스트를 위해 static 메서드인 Randoms.()를 대체하기 위한 목적으로 사용
    - List<String>을 입력받아 readline() 수행 시 하나씩 반환

# 인터페이스 구현 클래스 목록

## NumberForBaseballGame(Implementation)
### 게임에 사용되는 숫자의 검증과 비교 기능을 제공하는 인터페이스
#### 숫자 생성 간 유효성 검증 기능 (validateNumberFollowsRule)
#### 숫자 간 일치 여부 반환(equals)
    - 두 숫자가 일치하는 경우 true, 그 외에는 false를 반환한다.

## NumberGroupForBaseballGame
### 게임에 사용되는 숫자의 검증과 비교 기능을 제공
#### 숫자 생성 간 유효성 검증 기능 (validateNumberFollowsRule)
    - 입력 값은 숫자로만 구성되어야 한다 (checkNumberOnlyConsistOfDigits)   
    - 입력은 세자리 숫자로 이루어져야 한다 (checkNumberConsistOfThreeDigits)

