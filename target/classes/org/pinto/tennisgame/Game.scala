

package org.pinto.tennisgame

class Game {
   
   var _scores = Array(0,0) 
   val scoreNames = Array("love","fifteen","thirty","forty")
   
   def score = {
     this._scores match{
       case Array(3,3) => "deuce"
       case Array(x,y) if x >= 3 && y >= 3 && (x-y).abs == 1 => "advantage " + leaderPlayer
       case Array(x,y) if (x >= 4 || y >= 4) && (x-y).abs >= 2 => leaderPlayer + " won"
       case _ => scoreDescription(this._scores(0)) + " - " + 
           scoreDescription(this._scores(1))
     }
   }
   
   private def scoreDescription(x:Int) = this.scoreNames(x)
   
   private def leaderPlayer = if(this._scores(0) > this._scores(1)) "player 1" else "player 2"
   
   def pointBall(player: Int) = {
     player match{
       case 1|2 => this._scores(player-1) += 1
       case _ => Unit
     }
     Unit
   }
}