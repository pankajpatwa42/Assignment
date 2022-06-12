package RockPaperScissors;

import java.io.IOException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Rock Paper Scissors Game");
        System.out.println("Enter your name");
        Scanner scan=new Scanner(System.in);
        String username=scan.next();

        int score=0;
        while (true)
        {
       	 String winner="No winner ";
   		 String message="Both choose same";
   		 
   	     String rockCustomMessage = "The rock smashes the scissor";
   	     String scissorsCustomMessage = "Scissors cuts paper";
   	     String paperCustomMessage = "Paper wraps rock";
       	 System.out.println("Enter any one of the following \n1.Rock \n2.Paper \n3.Scissors");
            String userChoice=scan.next().toLowerCase(Locale.ROOT);
            Random r=new Random();
            int i=r.nextInt(3)+1;
            String computerChoice="";
            if(i==1)
            {
           	 computerChoice="rock";
            }
            else if(i==2)
            {
           	 computerChoice="paper";
            }
            else if(i==3)
            {
           	 computerChoice="scissors";
            }
            System.out.println("computer choose "+computerChoice);
            
            if((!userChoice.equals("rock")) && (!userChoice.equals("paper")) && (!userChoice.equals("scissors"))){
           	 System.out.println("Invalid Move !!!!!!");
            }
            
            if( computerChoice.equals( "rock" ) && userChoice.equalsIgnoreCase( "scissors" ) ){
	            winner = "Computer";
	            message = rockCustomMessage;
	            System.out.println(winner+" won " +" \n"+message);

	        }else if( userChoice.equalsIgnoreCase( "rock" ) && computerChoice.equals( "scissors" ) ){
	            winner = "User";
	            score++;
	            message = rockCustomMessage;
	            System.out.println(winner+ " won "+" "+message);

	        }
            if( computerChoice.equals( "scissors" ) && userChoice.equalsIgnoreCase( "paper" ) ){
 	            winner = "Computer";
 	            message = scissorsCustomMessage;
	            System.out.println(winner+ " won " +" "+message);

 	        }else if( userChoice.equalsIgnoreCase( "scissors" ) && computerChoice.equals( "paper" ) ){
 	            winner = "User";
 	            score++;
 	            message = scissorsCustomMessage;
	            System.out.println(winner + " won "+" "+message);
 	        }
            if( computerChoice.equals( "paper" ) && userChoice.equalsIgnoreCase( "rock" ) ){
 	            winner = "Computer";
 	            message = scissorsCustomMessage;
	            System.out.println(winner + " won "+" "+message);

 	        }else if( userChoice.equalsIgnoreCase( "paper" ) && computerChoice.equals( "rock" ) ){
 	            winner = "User";
 	            score++;
 	            message = paperCustomMessage;
	            System.out.println(winner + " won "+" "+message);
	            }else if(userChoice.equals(computerChoice)) 
	            {
		            System.out.println(winner + " won "+" "+message);

	            }
	       
            System.out.println("\nDo you want to continue? Y/N");    
  	       String c=scan.next();
 	             
  	     if(!c.equals("n") || (c.equals("y")))
         {
            System.out.println("Invalid.........");
            System.out.println("Please Enter Y or N...");
            c=scan.next();
            break;
          }else
        	  break;
 	         
          }  

}
