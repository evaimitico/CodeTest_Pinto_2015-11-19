

package org.pinto.tennisgame

class Game {
   
   var player1Score :Int = 0
   var player2Score :Int = 0
   
   def score = {
     var ret:String = "love - love"
     if(this.player1Score > 0)
         ret = "fifteen - love"
     ret
   }
   
   def pointBall(player: Int) = {
     if(player == 1) 
        this.player1Score += 1
     else
        this.player2Score += 1
     Unit
   }
}