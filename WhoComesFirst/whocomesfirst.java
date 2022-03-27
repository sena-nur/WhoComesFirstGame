// Senanur KÖSE 190315060 1st Ed.
package question2;
public class Question2 {
    public static void main(String[] args) {
        String player1 = "Player A"; //First player name
        String player2 = "Player B"; //Second player name
        System.out.println(player1 + " and " + player2 + " will play a game. Who will start the game will be determined randomly soon...\n");
        String firstTurn = GetFirstTurn(player1, player2);//Set first turn
        System.out.println(firstTurn + " will roll the first dice.");
        StartGame(player1, player2, firstTurn);//Initialize game
    }
    public static void StartGame(String player1, String player2, String firstturn)
    {   //I create int values of step nums, roll dice nums, current point nums and turn value for two players.
        int stepNum1=0, stepNum2=0, rollDiceNum1=0, rollDiceNum2=0, currentPoint1=0, currentPoint2=0, turn=0;
        System.out.println(player1 +" and " + player2 +" are ready. The game begins!");
        System.out.println();
        if(firstturn.equals(player1))
        {   //If firstturn's value equals with player1 set turn=1, else turn=2
            turn = 1;
        }
        else
        {
            turn = 2;
        }
        while((currentPoint1 < 100) && (currentPoint2 < 100)) //The game will continue as long as any point does not exceed 100.
        {   //If the turn to play is player 1
            if(turn == 1)
            {
                int dicerolled = RollDice(); //Create random value for roll dice
                System.out.println(player1 +" rolls dice : " + dicerolled);
                rollDiceNum1++; //I increase the value of int after roll dice
                System.out.println(player1 + " goes " + dicerolled + " steps forward");
                stepNum1 += dicerolled; //I add the value of the dice rolled to step num
                currentPoint1 += dicerolled; //I change current point value after moving
                System.out.println(player1 + " is at " + currentPoint1 + ". point");
                if(HasTwoDigits(currentPoint1))
                {
                    if(IsPrime(currentPoint1)) //If current point has two digits and prime number
                    {
                        System.out.println(currentPoint1 + " is prime number so " + player1 + " goes 1 step back");
                        currentPoint1--;
                        System.out.println(player1 + " is at " + currentPoint1 + ". point");
                        stepNum1++;
                    }
                    else if(currentPoint1 % 10 == 0) //If current point has two digits and divisible by 10
                    {
                        System.out.println(currentPoint1 + " is divisible by 10 so " + player1 + " goes 2 steps forward");
                        currentPoint1+=2;
                        System.out.println(player1 + " is at " + currentPoint1 + ". point");
                        stepNum1+=2;
                    }
                }
                turn=2; //Set turn to other player
                System.out.println();
            }
            else
            {   //If the turn to play is player 2
                int dicerolled = RollDice(); //Create random value for roll dice
                System.out.println(player2 +" rolls dice : " + dicerolled);
                rollDiceNum2++; //I increase the value of int after roll dice
                System.out.println(player2 + " goes " + dicerolled + " steps forward");
                stepNum2 += dicerolled; //I add the value of the dice rolled to step num
                currentPoint2 += dicerolled; //I change current point value after moving
                System.out.println(player2 + " is at " + currentPoint2 + ". point");
                if(HasTwoDigits(currentPoint2))
                {   
                    if(IsPrime(currentPoint2)) //If current point has two digits and prime number
                    {
                        System.out.println(currentPoint2 + " is prime number so " + player2 + " goes 1 step back");
                        currentPoint2--; //I decrease the current point value by one because of going 1 step back
                        System.out.println(player2 + " is at " + currentPoint2 + ". point");
                        stepNum2++; //Because of going 1 step back, I increase the step num by one
                    }
                    else if(currentPoint2 % 10 == 0) //If current point has two digits and divisible by 10
                    {
                        System.out.println(currentPoint2 + " is divisible by 10 so " + player2 + " goes 2 steps forward");
                        currentPoint2+=2; //I increase the current point value by two because of going 2 steps forward
                        System.out.println(player2 + " is at " + currentPoint2 + ". point");
                        stepNum2+=2; //Because of going 2 steps forward, I increase the step num by two
                    }
                }
                turn=1; //Set turn to other player
                System.out.println();
            }
        }
        if(currentPoint1>=100)
        {   //If first player is winner
            System.out.println(player1 + " WIN THE GAME !");
            System.out.println(player1 + " is at " + currentPoint1 + ". point");
            System.out.println("The dice was rolled " + (rollDiceNum1 + rollDiceNum2) + " times totally.");
            System.out.println(player1 + " finished the game in " + stepNum1 + " steps.");
        }
        else
        {   //If second player is winner
            System.out.println(player2 + " WIN THE GAME !");
            System.out.println(player2 + " is at " + currentPoint2 + ". point");
            System.out.println("The dice was rolled " + (rollDiceNum1 + rollDiceNum2) + " times totally.");
            System.out.println(player2 + " finished the game in " + stepNum2 + " steps.");
        }
        System.out.println();
    }
    public static String GetFirstTurn(String player1, String player2)
    {   //I set the player who will start to game firstly. I created random int 0 or 1
        int firstturn = (int)(Math.random()*2);
        if(firstturn == 0)
        {   //If int value is 0, first player starts to this game 
            return player1;
        }
        else
        {   //If int value is 1, second player starts to this game 
            return player2;
        }
    } 
    public static int RollDice()
    {   //I created number between 1-6
        int num = (int)(Math.random()*6) + 1;
        return num;
    }
    public static boolean HasTwoDigits(int num)
    {   //If the number is located between 10 and 99 return true, else return false
        if(num >= 10 && num<= 99)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean IsPrime(int num)
    {   //If the number less than 2 or has divisor different than 1 and itself, return false, else return true
        boolean isPrime=true;
        if(num < 2)
        {
            isPrime = false;
        }
        else
        {
            for(int i=2;i<=num/2;i++)
            {
                if(num % i == 0)
                {   //If I find divisor, I set bool value to false and break from loop.
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }
}