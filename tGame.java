import java.io.IOException;
import java.util.Scanner;
public class tGame {
		
	 public static void main(String[] args) {
		 String tryAgain = "y";
		 Scanner scan = new Scanner(System.in);
		 char[] Board = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8' };
		 splashScreen(scan);
		 do {
			 int winner = 0;
			 playerMakeMove(Board, scan);
			 
			
			System.out.println("Do you wan to play again? y/Y to continue. Anything else to quit");
			tryAgain = scan.nextLine();
			if(tryAgain.equals("y")|| tryAgain.equals("Y")) {
				resetGame(Board);
			}
		 }while(tryAgain.equals("y")|| tryAgain.equals("Y"));
		 
		 systemClear();
		
	 }
	 
	//displays game and developer’s information
		 public static String splashScreen(Scanner scan)
		 {
			 
			 String contChoice;
			 
			 System.out.println( "*****************************");
			 System.out.println( "*****************************");
			 System.out.println( "*****************************");
			 System.out.println( "******** Tic Tac Toe ********");
			 System.out.println( "******by Raiyan Bin Nasim****");
			 System.out.println( "*****************************");
			 System.out.println( "*****************************");
			 System.out.println( "*****************************");
			 
			 System.out.println("Press ENTER to contrinue! ");
				contChoice = scan.nextLine();
				systemClear();//functions to "clear" the screen.
				return contChoice;
			 

				
		 }
		 
		
		//reset the game when one concludes; this includes filling the array with vales 0-8
		 public static void resetGame(char[] Board) {
			 	Board[0] = '0';
		        Board[1] = '1';
		        Board[2] = '2';
		        Board[3] = '3';
		        Board[4] = '4';
		        Board[5] = '5';
		        Board[6] = '6';
		        Board[7] = '7';
		        Board[8] = '8';
		 }
		//display the grid after each player makes a move
		 public static void displayGrid(char[] Board) {
			 System.out.println(Board[0] + "|" + Board[1] + "|" + Board[2]);
			 System.out.println("-----");
			 System.out.println(Board[3] + "|" + Board[4] + "|" + Board[5]);
			 System.out.println("-----");
			 System.out.println(Board[6] + "|" + Board[7] + "|" + Board[8]);
			 
			 
		 }
		 
		 
		//prompts player to make a move, invokes validatePlayersMove, checkPositionAvailability
		 public static void playerMakeMove(char[] Board, Scanner scan) {
			 int turn = 1;
			 int winner = 0;
			 int gameMove = 0;
			 while(winner == 0 ) {
				 displayGrid(Board);
				 int userInput;
				 if(turn == 1) {
					 
					 userInput = validatePlayersMove(Board, scan);
					 Board[userInput] = 'H';
					 
					 
					 
					 winner = winCheck(Board);
					 
					 if (winner == 1 || winner ==2 || winner == 3) {
						 systemClear();
						 displayGrid(Board);
						 whoWon(winner);
						 
					 }else {
						 turn = 2;
						 
						 systemClear();
					 }
					 
				 }
				 else if(turn == 2 ) {
					 int computerMove = computerMakeMove(Board, gameMove);
					 
					 Board[computerMove] = 'C';
					 
					 winner = winCheck(Board);
					 
					 
					 if (winner == 1 || winner == 2 || winner == 3) {
						 systemClear();
						 displayGrid(Board);
						 whoWon(winner);
					 }else {
						 turn = 1;
						 systemClear();
						 
						 gameMove = gameMove + 1;
					 }
					 
				 }
				 
				 
			 }
		 }
		//validates that user entry X is such that 0<=X<=8
		 public static int validatePlayersMove(char[] Board, Scanner scan) {
			 int userInput;
			 String input;
			 System.out.println("It is the human's turn\r\n" + 
				 		"Give me your best move!");
			 input = scan.nextLine();
			
			while(input.length() != 1 || Character.isLetter(input.charAt(0)) || (input.charAt(0)- '0') > 8 || (input.charAt(0) - '0') < 0 || Board[input.charAt(0) - '0'] == 'H' || Board[input.charAt(0) - '0'] == 'C') {
				System.out.println("Not valid try again!");
				input = scan.nextLine();
			}
			
			userInput = input.charAt(0) - '0';
			return userInput;
		 }
		
		//check for a winning player
		 public static int winCheck(char[] Board) {
			 if (
						( Board[0] == 'H' && Board[1] == 'H' && Board[2] == 'H')
						|| (Board[3] == 'H' && Board[4] == 'H' && Board[5] == 'H')
						|| (Board[6] == 'H' && Board[7] == 'H' && Board[8] == 'H')

						|| (Board[0] == 'H' && Board[3] == 'H' && Board[6] == 'H')
						|| (Board[1] == 'H' && Board[4] == 'H' && Board[7] == 'H')
						|| (Board[2] == 'H' && Board[5] == 'H' && Board[8] == 'H')

						|| (Board[0] == 'H' && Board[4] == 'H' && Board[8] == 'H')
						|| (Board[2] == 'H' && Board[4] == 'H' && Board[6] == 'H')
						)
					{
						return 1;
					}
					else if (
						(Board[0] == 'C' && Board[1] == 'C' && Board[2] == 'C')
						|| (Board[3] == 'C' && Board[4] == 'C' && Board[5] == 'C')
						|| (Board[6] == 'C' && Board[7] == 'C' && Board[8] == 'C')

						|| (Board[0] == 'C' && Board[3] == 'C' && Board[6] == 'C')
						|| (Board[1] == 'C' && Board[4] == 'C' && Board[7] == 'C')
						|| (Board[2] == 'C' && Board[5] == 'C' && Board[8] == 'C')

						|| (Board[0] == 'C' && Board[4] == 'C' && Board[8] == 'C')
						|| (Board[2] == 'C' && Board[4] == 'C' && Board[6] == 'C')
						)
					{
						return 2;
					}
					else if (
						(Board[0] == 'C' || Board[0] == 'H')
						&& (Board[1] == 'C' || Board[1] == 'H')
						&& (Board[2] == 'C' || Board[2] == 'H')
						&& (Board[3] == 'C' || Board[3] == 'H')
						&& (Board[4] == 'C' || Board[4] == 'H')
						&& (Board[5] == 'C' || Board[5] == 'H')
						&& (Board[6] == 'C' || Board[6] == 'H')
						&& (Board[7] == 'C' || Board[7] == 'H')
						&& (Board[8] == 'C' || Board[8] == 'H')
						)
					{
						return 3;
					}
					else
						return 0;
		 }
		//check for a tie
		 public static void whoWon(int winner) {
			 

				if (winner == 1)
				{
					System.out.println("Congrats you won!");
				}
				else if (winner == 2)
				{
					System.out.println("C won!");
				}
				else if (winner == 3)
				{
					System.out.println( "Sorry! It is a tie :(");
				}
			 
		 }
		
		//used to make the move, in other words populate the array
		 public static int computerMakeMove(char[] Board, int gameMove) {
			 
			 String computerMove  = "0";
			 int move = 0;
			 
		 
			 if(gameMove == 0) {
				 if(Board[0] == 'H'|| Board[2] == 'H' || Board[6] == 'H'|| Board[8] == 'H' ) {
					  move  = 4; 
					 
				 }
				 
				 if( (Board[1] == 'H'|| Board[3] == 'H' || Board[5] == 'H'|| Board[7] == 'H' )) {
					 move  = 4; 
					 
				 }
				 
				 if((Board[computerMove.charAt(0) - '0'] != 'H' || Board[computerMove.charAt(0) - '0'] != 'C') && (Board[4] == 'H')) {
					 move = 0;
				 }
			 }
			 
			 if(gameMove > 0) {
				    
				    
				         //consider the move for winning for the computer and the move for blocking for human first so 
				         //it becomes the priority for the computer move
				         
				         //if the human makes a dumb move and forgets to block the computer from winning, 
				         //the following if and else-if statements will check and make the last move for the computer to win 
				         if (  (Board[2] == 'C' && Board[1] == 'C' && Board[0] == '0') || (Board[3] == 'C' && Board[6] == 'C' && Board[0] == '0')
				      || (Board[4] == 'C' && Board[8] == 'C' && Board[0] == '0'))
				      {
				      move = 0;
				      }
				         
				         else if ((Board[0] == 'C' && Board[8] == 'C' && Board[4] == '4') || (Board[2] == 'C' && Board[6] == 'C' && Board[4] == '4')
				         || (Board[1] == 'C' && Board[7] == 'C' && Board[4] == '4') || (Board[5] == 'C' && Board[3] == 'C' && Board[4] == '4'))
				      {
				      move = 4;
				      }
				         else if ((Board[0] == 'C' && Board[1] == 'C' && Board[2] == '2') || (Board[4] == 'C' && Board[6] == 'C' && Board[2] == '2')
				         || (Board[5] == 'C' && Board[8] == 'C' && Board[2] == '2'))
				      {
				        	 move = 2;
				      }    
				         else if ((Board[2] == 'C' && Board[4] == 'C' && Board[6] == '6') || (Board[3] == 'C' && Board[0] == 'C' && Board[6] == '6')
				         || (Board[7] == 'C' && Board[8] == 'C' && Board[6] == '6'))
				      {
				        	 move = 6;
				      }
				         else if ((Board[4] == 'C' && Board[5] == 'C' && Board[3] == '3') || (Board[0] == 'C' && Board[6] == 'C' && Board[3] == '3'))
				      {
				        	 move = 3;
				      }
				         else if ((Board[2] == 'C' && Board[0] == 'C' && Board[1] == '1') || (Board[4] == 'C' && Board[7] == 'C' && Board[1] == '1'))
				      {
				        	 move = 1;
				      }
				         else if ((Board[4] == 'C' && Board[1] == 'C' && Board[7] == '7') || (Board[8] == 'C' && Board[6] == 'C' && Board[7] == '7'))
				      {
				        	 move = 7;
				      }
				         else if ((Board[2] == 'C' && Board[8] == 'C' && Board[5] == '5') || (Board[3] == 'C' && Board[4] == 'C' && Board[5] == '5'))
				      {
				        	 move = 5;
				      }
				         else if ((Board[2] == 'C' && Board[5] == 'C' && Board[8] == '8') || (Board[7] == 'C' && Board[6] == 'C' && Board[8] == '8')
				         || (Board[4] == 'C' && Board[0] == 'C' && Board[8] == '8'))
				      {
				        	 move = 8;
				      }
				         //if the human makes two moves that can make him/her to win, 
				         //the following if and else-if statements will check and block the last move for the human to win
				         else if (  (Board[2] == 'H' && Board[1] == 'H' && Board[0] == '0') || (Board[3] == 'H' && Board[6] == 'H' && Board[0] == '0')
				      || (Board[4] == 'H' && Board[8] == 'H' && Board[0] == '0'))
				      {
				        	 move = 0;
				      }
				         
				         else if ((Board[0] == 'H' && Board[8] == 'H' && Board[4] == '4') || (Board[2] == 'H' && Board[6] == 'H' && Board[4] == '4')
				         || (Board[1] == 'H' && Board[7] == 'H' && Board[4] == '4') || (Board[5] == 'H' && Board[3] == 'H' && Board[4] == '4'))
				      {
				        	 move = 4;
				      }
				         else if ((Board[0] == 'H' && Board[1] == 'H' && Board[2] == '2') || (Board[4] == 'H' && Board[6] == 'H' && Board[2] == '2')
				         || (Board[5] == 'H' && Board[8] == 'H' && Board[2] == '2'))
				      {
				        	 move = 2;
				      }    
				         else if ((Board[2] == 'H' && Board[4] == 'H' && Board[6] == '6') || (Board[3] == 'H' && Board[0] == 'H' && Board[6] == '6')
				         || (Board[7] == 'H' && Board[8] == 'H' && Board[6] == '6'))
				      {
				        	 move = 6;
				      }
				         else if ((Board[4] == 'H' && Board[5] == 'H' && Board[3] == '3') || (Board[0] == 'H' && Board[6] == 'H' && Board[3] == '3'))
				      {
				        	 move = 3;
				      }
				         else if ((Board[2] == 'H' && Board[0] == 'H' && Board[1] == '1') || (Board[4] == 'H' && Board[7] == 'H' && Board[1] == '1'))
				      {
				        	 move = 1;
				      }
				         else if ((Board[4] == 'H' && Board[1] == 'H' && Board[7] == '7') || (Board[6] == 'H' && Board[8] == 'H' && Board[7] == '7'))
				      {
				        	 move = 7;
				      }
				         else if ((Board[2] == 'H' && Board[8] == 'H' && Board[5] == '5') || (Board[3] == 'H' && Board[4] == 'H' && Board[5] == '5'))
				      {
				        	 move = 5;
				      }
				         else if ((Board[2] == 'H' && Board[5] == 'H' && Board[8] == '8') || (Board[7] == 'H' && Board[6] == 'H' && Board[8] == '8')
				         || (Board[4] == 'H' && Board[0] == 'H' && Board[8] == '8'))
				      {
				        	 move = 8;
				      }
				         //if there is no two moves either from the human or computer, then the following if and else-if statements will make the computer to move in following spot
				         else if ((Board[4] != 'H' && Board[4] != 'C'))
				    {
				        	 move = 4;
				      }

				         else if ((Board[0] != 'H' && Board[0] != 'C'))
				    {
				        	 move = 0;  
				    }                  
				    else if ((Board[2] != 'H' && Board[2] != 'C'))
				    {
				    	move = 2;
				    }
				    else if ((Board[6] != 'H' && Board[6] != 'C'))
				    {
				    	move = 6;
				    }
				    else if ((Board[3] != 'H' && Board[3] != 'C'))
				    {
				    	move = 3;
				    }
				    else if ((Board[1] != 'H' && Board[1] != 'C'))
				    {
				    	move = 1;
				    }
				    else if ((Board[7] != 'H' && Board[7] != 'C'))
				    {
				    	move = 7;
				    }
				    else if ((Board[5] != 'H' && Board[5] != 'C'))
				    {
				    	move = 5;
				    }
				    else if ((Board[8] != 'H' && Board[8] != 'C'))
				    {
				    	move = 8;
				    }

			 }
			
			
			 
			return move;
			 
			 
			
		 }
		//check that the position selected by the user is available
		 public static void checkPositionAvailability() {
			 
		 }
		 private static void systemClear() {
			 for(int i = 0; i < 1000; i++) {
					
				    System.out.println();// adds 1000 lines so it appears as if the screen is cleared!
				
				  }
	
}
}
