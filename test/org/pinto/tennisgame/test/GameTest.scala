package org.pinto.tennisgame.test

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.pinto.tennisgame.Game
 
@RunWith(classOf[JUnitRunner])
class GameTest extends FunSuite {
  
  test("dummy") {
    val sut = new Game()
  }
  
  test("Initial game score should be love love") {
    val sut = new Game()
    assertResult("love, love")(sut.score)
  }
}