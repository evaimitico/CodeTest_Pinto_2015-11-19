

package org.pinto.tennisgame

class Game {
   
   var _scores = Array(0,0) 
   val scoreNames = Array("love","fifteen","thirty","forty")
   
   def score = {
     this.scoreNames(this._scores(0)) + " - " + 
           this.scoreNames(this._scores(1))
   }
   
   def pointBall(player: Int) = {
     player match{
       case 1|2 => this._scores(player-1) += 1
       case _ => Unit
     }
     Unit
   }
}