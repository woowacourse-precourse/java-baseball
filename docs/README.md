# Flowchart
![image](image/flowchart.png)

# 기능 목록
- 서로 다른 임의의 수 3개 선택 후 리스트로 반환하는 메서드 (getRandomNumberList)
- 컴퓨터가 생성한 리스트와 사용자가 생성한 리스트를 비교, 반복하는 에서드 (start)
  - 사용자가 입력한 문자열이 유효하지 않다면 예외를 던지는 메서드 (checkValidString)
    - 문자열 3자리 확인 메서드 (isStringLengthThree)
    - 숫자 확인 메서드 (isNumber)
  - 유저가 입력한 문자열을 숫자 리스트로 반환하는 메서드 (getUserNumberList)
  - 볼 개수와 스트라이크 개수를 통해 결과 문자열을 반환하는 메서드 (getAnswerString)
    - 컴퓨터 리스트와 유저 리스트를 통해 볼 개수를 반환하는 메서드 (getBallCount)
      - 숫자가 볼인지 확인하는 메서드 (isBall)
    - 컴퓨터 리스트와 유저 리스트를 통해 스트라이크 개수를 반환하는 메서드 (getStrikeCount)
      - 숫자가 스트라이크인지 확인하는 메서드 (isStrike)
- 재시작 및 종료를 위한 입력을 확인하고 유효하지 않다면 예외를 던지는 메서드 (isReStart)
