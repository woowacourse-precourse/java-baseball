# 미션 - 숫자 야구

## 기능 목록
- controller 
    - ❌게임 진행하는 메소드 (newGame)
    - ❌게임 재시작하는 메소드 (restartGame)
- dealer
    - ✅게임 진행 확인용 boolean 필드 (isGameGoing)
    - ✅서로 다른 3자리 수가 담길 List 필드 (threeDifferentNumbers)
    - ✅서로 다른 3자리 수를 생성하고 불러오는 메소드 (getNewThreeDifferentNumbers)
- player
    - ✅서로 다른 3자리 수가 담길 List 필드 (threeDifferentNumbers)
    - ✅서로 다른 3자리 수를 불러오는 메소드 (createThreeDifferentNumbers)
        - ✅입력값의 유효성을 검사하는 메소드 (checkInput)
        - ✅입력값을 각각의 자릿수로 나누는 메소드 (splitToDigits)
- calculator
    - ✅스트라이크가 담길 Integer 필드 (strike)
    - ✅볼이 담길 Integer 필드 (ball)
    - ✅스트라이크와 볼이 담길 List 필드 (Scores)
    - ✅점수를 불러오는 메소드 (getScores)
        - ✅dealer와 player의 숫자를 비교하는 메소드 (countBallAndStrike)
- resultViewer (static)
  - ✅스트라이크 개수가 담길 Integer 필드 (strikeCount)
  - ✅볼 개수가 담길 Integer 필드 (ballCount)
  - ✅calculator의 점수를 받아 메시지를 출력하는 메소드 (printOut)
      - ✅calculator의 점수를 받을 Stringbuilder 로컬 변수 (message)
      - ✅볼 개수를 반환하는 메소드 (getBallMessage)
      - ✅공백을 출력하는 메소드 (getSpace)
      - ✅스트라이크 개수를 반환하는 메소드 (getStrikeMessage)
      - ✅‘낫싱’을 반환하는 메소드 (getNothingMessage)