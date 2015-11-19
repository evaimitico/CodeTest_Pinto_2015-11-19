

package org.pinto.tennisgame

class Game {
   
   var player1Score :Int = 0
   var player2Score :Int = 0
   val scoreNames = Array("love","fifteen","thirty","forty")
   
   def score = {
     this.scoreNames(this.player1Score) + " - " + 
           this.scoreNames(this.player2Score)
   }
   
   def pointBall(player: Int) = {
     if(player == 1) 
        this.player1Score += 1
     else
        this.player2Score += 1
     Unit
   }
}