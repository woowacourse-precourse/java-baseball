# 기능 목록
## 기능 목록 업데이트
## MVC pattern 적용
- 기존 작성 기능 목록은 MVC pattern 적용 못한 목록으로, 리펙토링 중 MVC pattern 적용 위해 기능 목록 수정
## 구현방법
1. 난수 생성 - Model
2. User 입력한 숫자 저장 - Model
3. User 입력 숫자 유효성 확인 - Model
4. 난수, User 입력 숫자로 strike, Ball 판단 - Model
5. 결과 출력 - View
6. 게임 종료 판단, 계속 진행시 2~5 반복 - Model
7. 게임 종료시 프로그램 재시작 여부 User 입력, 프로그램 종료 여부 판단 - Model
8. 결과 출력 - View

- 게임 시작
1. Application 에서 Controller 통해 Computer, User 객체 만듦

## MVC Pattern
1. Model 
   - (기존) Computer 클래스: 난수 생성, 저장 및 가공. (다른 기능 삭제)
     - 생성자, makeNumberList, addNumberIfNotList
   - (기존) User 클래스: User 입력 숫자 저장, 가공 및 유효성 확인. (다른 기능 삭제)
     - inputGameNumber(inputNumber), checkType, makeError(errorControl), checkNumber, numberToList
     - (추가) inputEndNumber
   - (추가) Game 클래스: 난수, User 입력 숫자로 Strike, Ball 계산, 게임 종료 및 프로그램 종료 판단. Computer, User 객체 만들어 숫자 받음.
     - checkStrike, checkBall
     - (추가) 생성자, inputGameData, updateGameData, getStrike, getBall, checkStrikeAndBall, inputEndGameData, keepGame
2. View
   - (추가) OutputView 클래스: 모든 출력 함수 구현, 항상 출력되는 문구는 final String 으로 관리
     - printStarting, printResult
     - (추가) printKeepGame, printEndGame, printInput
3. Controller
   - (추가) GameController: 생성자를 통해 Game, OutputView 객체 생성해 데이터 전달 및 출력하는 함수 구현
     - (추가)생성자, gameStart, keepGame, endGame
---

## 구현 방법
1. 컴퓨터에서 만든 숫자, 사용자가 입력하는 숫자를 클래스 생성을 통해 객체화한다.
2. 스트라이크, 볼 개수를 판단하는 메서드는 사용자 클래스에 메서드로 구현한다.
   1. 숫자를 리스트에 넣어 하나씩 전달받아 인덱스를 자릿수 정보로 활용한다.
   2. 숫자와 인덱스가 같으면 스트라이크, 숫자는 같지만 자릿수가 다르면 볼 로 판단한다
3. 결과를 출력하는 메서드를 생성한다.
4. 게임 재시작을 판단하는 메서드를 생성한다.

# 클래스
## class Computer
1. 매개변수
   - 없음
2. 변수
   - (List) computerNumberList : 컴퓨터에서 만든 숫자를 담을 리스트 

### <생성자>
#### Computer
1. 매개변수
   - 없음
2. 변수
   - 없음
3. 구현
   - printStarting 호출 
   - 클래스 변수 computerNumberList를 makeNumber 메서드 호출해 업데이트
### <메서드>
#### 1. (List) makeNumberList
1. 매개변수
   - 없음
2. 변수
   - (List) computerNumberList : 랜덤 숫자를 담기 위한 리스트 변수 
   - (int) randomNumber : Randoms.pickNumberInRange 를 통해 생성될 랜덤 숫자 저장할 변수
3. 구현
   - computerNumberList 의 size가 3일 때 까지 randomNumber를 생성~~해 add한다~~.
   - ~~이미 있는 값은 add하지 않는다. (서로 다른 3개 숫자)~~
   - addNumberIfNotList 호출해 computerNumberList 업데이트
   - computerNumberList 반환
#### 2. (void) printStarting
1. 매개변수
    - 없음
2. 변수
    - 없음
3. 구현
    - "숫자 야구 게임을 시작합니다." 출력
#### (추거) 3. (List) addNumberIfNotList
1. 매개변수
   - (List) computerNumberList : 리스트에 숫자 있는지 판단 위해 받는 리스트
   - (int) randomNumber : 리스트에 숫자 있는지 판단 위해 받는 int형 변수
2. 변수
   - 없음
3. 구현
   - computerNumberList에 randomNumber가 없으면 추가.
   - computerNumberList 반환
4. 추가 사유
    - makeNumberList 메서드의 기능을 줄이기 위해 기존 makeNumberList 메서드 기능을 분리
---

## class User
1. 매개변수
   - 없음
2. 변수
   - (List) computerNumberList : Computer로 만들어진 숫자 리스트를 저장할 변수
   - (boolean) keepGame = true : 게임을 계속하는지 확인하기 위한 변수
### <생성자>
#### User
1. 매개변수
   - (List) computerNumberList : computer에서 생성한 숫자를 받음.
2. 변수
   - 없음
3. 구현
   - 매개변수로 받은 값을 this.computerNumberList에 저장.
### <메서드>
#### 1. (int) inputNumber
1. 매개변수
   - 없음
2. 변수
      - (int) userNumber : 사용자가 입력한 숫자를 담을 변수
3. 구현
   - "숫자를 입력해주세요 : " 출력
   - Console.readLine() 으로 숫자를 받아 userNumber에 저장
   - userNumber 반환
#### (추가) 10. (boolean) checkType
1. 매개변수
   - (Object) userNumber
2. 변수
   - 없음
3. 구현
   - userNumber가 숫자면 ~~int형으로 변환 후 반환~~ true 반환
   - 아니면 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료, false 반환
#### (추가) 9.(void) errorControl
1. 매개변수
   - 없음
2. 변수
   - 없음
3. 구현
   - IllegalArgumentException를 발생시킴
   - catch문에서 프로그램 종료(?)
#### 2. (boolean) checkNumber
1. 매개변수
   - (int) userNumber
2. 변수
   - (boolean) result
3. 구현
   - userNumber가 1~9의 숫자로 이루어졌는지 확인
   - 맞으면 true, 틀리면 ~~false 반환~~ errorControl 발생, false 반환
#### 3. (List) numberToList
1. 매개변수
   - (int) userNumber
2. 변수
   - (List) userNumberList : 숫자를 리스트로 반환해 받을 변수
3. 구현
   - 숫자를 리스트로 변환. 100의자리부터 1개씩 꺼내 리스트에 넣는다.
   - userNumberList 반환
#### 4. (int) checkStrike
1. 매개변수
   - (List) computerNumberList
   - (List) userNumberList
2. 변수
   - (int) strike
3. 구현
   - 매개변수로 받은 두 리스트를 비교해 동일자리, 동일숫자면 strike 개수 증가
   - strike 반환
#### 5. (int) checkBall
1. 매개변수
   - (List) computerNumberList
   - (List) userNumberList
   - (추가)(int) strike
2. 변수
   - (int) ball
3. 구현
   - 매개변수로 받은 두 리스트를 비교해 ~~다른자리,~~ 동일숫자를 가지고 있으면 ball 개수 증가
     - !! userNumberList 에 동일 숫자 있는 경우 고려 필요 (해결 완료)
   - ball-strike 반환

#### 6. (void) printResult
1. 매개변수
   - (int) strike
   - (int) ball
2. 변수
   - 없음
3. 구현
   - 스트라이크, 볼의 개수를 출력
   - 스트라이크가 3이면 "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 출력 후 keepOrNot 호출
#### 7. (void) keepOrNot
1. 매개변수
   - 없음
2. 변수
   - (int) endOrNot : 게임을 종료시킬지 입력하는 값을 저장
3. 구현
   - "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력
   - Console.readLine()으로 받은 숫자를 endOrNot에 저장
   - 숫자가 1이면 keepGame 에 true, 2면 keepGame에 false 넣음
   - 둘 다아니면 다시 수행 (or 프로그램 종료?)
#### 8. (void) main
1. 매개변수
   - (String[]) args
2. 변수
   - (int) userNumber : inputNumber 로 받을 숫자 담을 변수
   - (List) userNumberList : userNumber를 리스트로 변환한 것을 담을 변수
   - (int) strike = 0 : 스트라이크 개수 담을 변수
   - (int) ball = 0 : 볼 개수 담을 변수
3. 구현
   - inputNumber 호출해 userNumber 업데이트
   - (추가) checkType 로 입력한게 숫자인지 확인해 아니면 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
   - checkNumber로 숫자 체크해 false면 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
   - numberToList 호출해 userNumberList 업데이트
   - checkStrike, checkBall 호출해 strike, ball 업데이트
   - printResult 호출
---
## class Application
1. 매개변수
   - 없음
2. 변수
   - 없음
### <생성자>
- 없음
### <메서드>
#### 1. (void) main
1. 매개변수
   - (String[]) args
2. 변수
   - (List) computerNumberList : Computer 를 통해 만들어질 숫자 리스트
   - (User) user : user 객체
3. 구현
   - user 객체 생성
   - user.keepGame 이 true면 (while)
     - Computer 새로운 객체 만들어 computerNumberList 업데이트,
     - computerNumberList로 user객체 생성, user.main 호출