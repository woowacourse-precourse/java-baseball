[1단계] 
값을 포장하는 Ball 클래스 작성. 3개의 값을 갖는 Balls를 이용할 것인데, 각 값을 Ball이라는 클래스로 감싸서 예외처리를 해준다.
* 1부터 9까지의 숫자가 들어오기 때문에 minimumNumber와 maximumNumber 상수를 정한다.
* 값을 벗어나면 IllegalArgumentException을 발생시킨다.

[2단계] 
3개의 Ball을 갖는 Balls 클래스를 작성한다. 일급콜렉션으로 만들어 예외처리와 결과를 판정하는 메서드를 작성한다.
* 예외처리
  * 3개의 값이 들어오는지 확인한다.
  * 3개의 값이 모두 다른지 확인한다.
* hasSameValue()
  * Balls 클래스 balls이 Ball 클래스 ball을 입력받아 balls에 ball과 같은 값이 있는지 확인한다.
* inSamePosition()
  * Balls 클래스 balls이 position과 Ball 클래스 ball을 받았을 때, 위치가 같은지 확인한다.

[3단계]
판정 STRIKE, BALL을 갖는 enum 클래스인 Judgement를 작성한다.
Balls에 play라는 method를 작성하는데, 다음의 로직을 따라 Judgement를 반환한다.
* hasSameValue()와 inSamePosition()을 통과하면 STRIKE를 반환
* hasSameValue()를 통과하고 inSamePosition()을 통과하지 못하면 BALL을 반환

[4단계]
결과를 관리하는 클래스 Result를 작성한다. strike와 ball을 instance variable로 가지며
결과를 출력하는 메서드 showResult()를 가진다.
* 0볼 0스트라이크일 때 -> "낫싱"
* 1볼 1스트라이크일 때 -> "1볼 1스트라이크"
* 3볼 0스트라이크일 때 -> "3볼"
* 3스트라이크일 때 -> "3스트라이크"

[5단계]
Appplication 작성