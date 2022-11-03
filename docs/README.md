# 기능 목록
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
#### 1. (List) makeNumber
1. 매개변수
   - 없음
2. 변수
   - (List) computerNumberList : 랜덤 숫자를 담기 위한 리스트 변수 
   - (int) randomNumber : Randoms.pickNumberInRange 를 통해 생성될 랜덤 숫자 저장할 변수
3. 구현
   - computerNumberList 의 size가 3일 때 까지 randomNumber를 생성해 add한다.
   - 이미 있는 값은 add하지 않는다. (서로 다른 3개 숫자)
   - computerNumberList 반환
#### 2. (void) printStarting
1. 매개변수
    - 없음
2. 변수
    - 없음
3. 구현
    - "숫자 야구 게임을 시작합니다." 출력
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
#### 2. (boolean) checkNumber
1. 매개변수
   - (int) userNumber
2. 변수
   - (boolean) result
3. 구현
   - userNumber가 1~9의 숫자로 이루어졌는지 확인
   - 맞으면 true, 틀리면 false 반환
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
#### 5. (void) checkBall
1. 매개변수
   - (List) computerNumberList
   - (List) userNumberList
2. 변수
   - (int) ball
3. 구현
   - 매개변수로 받은 두 리스트를 비교해 다른자리, 동일숫자면 ball 개수 증가
     - !! userNumberList 에 동일 숫자 있는 경우 고려 필요
   - ball 반환

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