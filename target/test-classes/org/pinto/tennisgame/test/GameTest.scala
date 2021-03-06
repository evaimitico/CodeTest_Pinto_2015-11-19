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
  
  test("After 2 point ball by player2, score is love - thirty") {
    (1 to 2).foreach( x => sut.pointBall(2))
    assertResult("love - thirty")(sut.score)
  }
  
  test("After 3 point ball by player2, score is love - forty") {
    (1 to 3).foreach( x => sut.pointBall(2))
    assertResult("love - forty")(sut.score)
  }
  
  test("After 3 point ball by player2 and 2 by player1, score is thirty - forty") {
    sut.pointBall(2)
    sut.pointBall(2)
    sut.pointBall(1)
    sut.pointBall(1)
    sut.pointBall(2)
    assertResult("thirty - forty")(sut.score)
  }
  
  test("point ball can be smashed only by player1 and player2"){
    sut.pointBall(3)
    sut.pointBall(0)
    assertResult("love - love")(sut.score)
  }
  
  test("deuce when 3 point each"){
    (1 to 3).foreach( x => sut.pointBall(2))
    (1 to 3).foreach( x => sut.pointBall(1))
    assertResult("deuce")(sut.score)
    sut.pointBall(1)
    sut.pointBall(2)
    assertResult("deuce")(sut.score)    
  }
  
  test("advantage when 1 point gap and  more than 3 point each"){
    (1 to 3).foreach( x => sut.pointBall(2))
    (1 to 3).foreach( x => sut.pointBall(1))
    sut.pointBall(2)
    assertResult("advantage player 2")(sut.score)
    sut.pointBall(1)
    assertResult("deuce")(sut.score) 
    sut.pointBall(1)
    assertResult("advantage player 1")(sut.score)
    
  }
  
  test("player with at least 4 points and 2 point of gap wins"){
    val winMsg = "player 2 won"
    (1 to 3).foreach( x => sut.pointBall(2))
    (1 to 3).foreach( x => sut.pointBall(1))
    sut.pointBall(2)
    assert(sut.score != winMsg)
    sut.pointBall(2)
    assertResult(winMsg)(sut.score)
  }
  
   test("player can win with 4 pointball"){
    (1 to 4).foreach( x => sut.pointBall(2))
    assertResult("player 2 won")(sut.score)
  }
  
   
  test("After game won, no more pointBall allowed"){
    (1 to 4).foreach( x => sut.pointBall(2))
    val thrown = intercept[Exception] {
      sut.pointBall(2)
    }
    assert(thrown.getMessage === "Game Over")
    
  }
}