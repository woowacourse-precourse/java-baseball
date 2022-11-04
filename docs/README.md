[1단계] 
공이 두 개 주어졌을 때, 각 공은 값을 가지고 있다. 공 하나의 값이 같으면 Ball or Strike이고 다르면 Nothing이다.
   * ex1) Ball(1)과 Ball(2)는 다르기 때문에 Nothing이다.
   * ex2) Ball(1)과 Ball(1)은 같기 때문에 SameValue이다. 후에 Ball or Strike 판정을 받는다.
<br>
[2단계] player의 공 3개와 computer의 공 3개를 비교한다. 결과를 관리하는 class를 만든다. 공3개를 (공1, 공2, 공3)이라고 하면
   * ex1) computer (1,2,3) player(4,5,6)은 같은 값이 없으므로 낫싱이다.
   * ex2) computer (1,2,3) player(2,1,4)는 두 개의 값이 같지만 모두 위치가 다르므로 2볼이다.
   * ex3) computer (1,2,3) player(1,3,2)는 값이 모두 같지만 하나만 위치까지 맞기 때문에 1스트라이크 2볼이다.
   * ex4) computer (1,2,3) player(1,2,3)은 값과 위치가 모두 같으므로 3스트라이크이다.
<br>
[3단계] application 구축
   * 작성중