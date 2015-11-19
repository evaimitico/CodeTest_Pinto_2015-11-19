package org.pinto.tennisgame.test

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.pinto.tennisgame.Game
import org.scalatest.BeforeAndAfter
 
@RunWith(classOf[JUnitRunner])
class GameTest extends FunSuite with BeforeAndAfter {
  var sut : Game = new Game;
  
  before {
    sut = new Game()
  }
  
  test("dummy") {
    val game = new Game()
  }
  
  test("Initial game score should be love - love") {
    assertResult("love - love")(sut.score)
  }
  
  test("After point ball by player1, score is fifteen - love") {
    sut.pointBall(1)
    assertResult("fifteen - love")(sut.score)
  }
  
  
  test("After point ball by player2, score is love - fifteen") {
    sut.pointBall(2)
    assertResult("love - fifteen")(sut.score)
  }
}