package RockPaperScissors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
	
	private static int highscore=0;
    static File file;
    static FileOutputStream fos=null;
    static FileInputStream fr=null;

    public static void writeData(Properties p)
    {
		try {
			fos = new FileOutputStream(file,true);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
   	 try {
			p.store(fos ,null);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
   	 
}

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Rock Paper Scissors Game");
        System.out.println("=========================");
//    	System.out.println("Highest Score "+highscore);

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
 	             
  	     if(c.equalsIgnoreCase("n"))
         {
        	 break;
         }
 	         
          }  
        file = new File("C://Users//PANKAJ//eclipse-workspace//Git//config.properties");
    	Properties p = new Properties();
    	p.setProperty(username,String.valueOf(score));
    	writeData(p);
    	
    	FileInputStream fr = new FileInputStream("C://Users//PANKAJ//eclipse-workspace//Git//config.properties");
    	Properties pr = new Properties();
    	pr.load(fr);
    	
    	String s = pr.getProperty("HighScore");
    	fr.close();
    	int convert_s = Integer.parseInt(s);
    	
    	if(highscore<score)
    	{
    		if(convert_s>highscore) {
    			
    		highscore = score;
    		System.out.println(highscore);
    		p.setProperty("HighScore", String.valueOf(score));
    		p.store(fos, null);
    		fos.close();
    		}
    		}
    	highscore = Integer.parseInt(pr.getProperty("HighScore"));
    	System.out.println(highscore);

    }
}