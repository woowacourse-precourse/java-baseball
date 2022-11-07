## 🔑- 기능 구현 목록
- <y> 컴퓨터의 숫자 1부터 9까지 서로 다른 임의의 수 3개를 생성한다.   - NumberGenerator.generateRandomNumbers()
- <y> 컴퓨터의 숫자와 플레이어의 숫자를 비교하여 일치하는 숫자가 몇개 있는지 판단한다   - JudgeLogic.countSameNumbers()
- <y> 컴퓨터의 숫자와 플레이어의 숫자가 자리와 그 숫자가 일치하는지 판단한다.       - JudgeLogic.isSameNumber()  
- <y> 최종 결과 스코어를 계산한다.                         - ResultMaker.compare()
- <y> 스트라이크 카운트를 구한다.                        - ResultMaker.getStrikeCount()
- <y> 볼 카운트를 구한다.                             - ResultMaker.getBallCount()
- <y > 사용자가 입력한 값의 존재 여부 파악하는 기능 추가          - Application.validateEmpty()
- <y > 3자리의 숫자를 입력했는지 판단하는 기능추가                  -Application.validateSize()
- <y > 사용자가 각각 자리의 숫자를 1~9의 범위안에서 입력했는지 검사하는 기능추가          - Application.validateNumber()
- <y > 중복된 숫자를 입력했는 지 검사하는 기능 추가          - Application.validateOverlap()
- <y > 사용자로부터 숫자를 입력받아 리스트를 생성한다.          - Application.getPlayerNumbers()

