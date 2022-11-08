
## 📄 기능 목록
1. Application.java
   - main : application 동작
   
2. InputException.java : 사용자각 잘못된 값을 입력한 경우 발생, 이후 어플리케이션은 종료
   - inputEmptyException() : 입려값 없을 경우 발생 
   - inputHasSameCharException() : 문장에 중복된 문자가 있을 경우 발생
   - inputNotThreeNumberException() : 길이가 3이 아니고 입력값이 숫자가 아닐 경우 발생 
   - inputNotOneOrTwoException() : 입력값이 1이나 2가 아닐 때 발생
   
3. PlayNumberBaseballGame.java : 숫자야구놀이 전체 기능
   - playNumberBaseballOneGame() : 숫자야구 게임 한번 진행 
   - setRandomNumberOfComputer() : 컴퓨터의 수 (랜덤)
   - getInputNumbersOfPlayer() : 플레이어의 답변 입력 받음 
   - compareNumbersBetweenComputerAndPlayer() : 컴퓨터와 플레이어의 숫자 비교 
     - isThreeStrike() : 3스트라이크인가요? (boolean)
     - isStrike() : 스트라이크인가요? (boolean)
     - isBall() : 볼인가요? (boolean)
     - outputResultComparisonOfNumbers() : 숫자끼리 비교한 결과 출력
   - isRetry() : 재시작 하겠습니까? (boolean)
   
4. GameProgressLine.java : 게임 진행 문구 집합

---
##  💡 기타 내용 정리
### enum type

---
##  🤔 소감

