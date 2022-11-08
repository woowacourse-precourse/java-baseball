# 기능목록 작성

---

## 🔘 전체 과정
- main() 에서 플레이게임()
    - 컴퓨터는 숫자를 정한다.
    - `숫자 야구 게임을 시작합니다.` 출력
    - for 문 3자리 다 맞힐 때 까지 `숫자를 입력해주세요 :` 출력
        - guessNumber 숫자 입력.
        - 세자리숫자유효성검사()
        - 결과검사()
        - 결과출력
    - 3자리 다 맞히면 `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.` 을 출력,  게임 종료 선택

---
## 🔘 메서드 분리
### 1. playGame
* [x] 숫자 생성
* [x] while
   1. 숫자 입력 받기
   2. 숫자 체크
   3. 정답이면 종료 
* [x] 애플리케이션 종료 여부 선택

### 2. generateNumber
* [x] 3자리 랜덤 숫자 정하기

### 3. getPlayerAnswer
* [x] Console.readLine 으로 입력받기 
* [x] String 형태로 return

### 4. StringToIntegerList
* [x] string 문자열을 List<Integer> 형태로 변경

### 5. validateNumber
* [x] 3자리 수
* [x] 중복 불가
* [x] 1이상 9이하의 숫자만 가능

### 6. countStrikeBall
* [x] Strike와 ball의 개수를 count하는 함수
* [x] 결과 출력 
  * 스트라이크
  * 볼
  * 낫싱
  * if (3스트라이크이면 출력하고, 게임종료)

### 7. getResult
* [x] 결과 메시지 출력 후 정답여부를 boolean 으로 return 하는 함수

### 8. restartGame
* [x] 재시작(1), 앱 종료(2)를 입력받는다.
