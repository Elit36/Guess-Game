import java.util.*;
import java.io.*;
public class GuessGame {
	Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	Players p1 = new Players();
	Players p2 = new Players();
	Players p3 = new Players();
	machine m = new machine();
		int c; // counter variable for attempts
	
	public void menu() throws IOException {
		boolean sb=true;
		if(c==3) {
			System.out.println("\n3 attempt done\trestart again.!");
			System.exit(0);
		}
		System.out.println(); // Printing spaces b/w logo & menu.
		System.out.println();
		System.out.println("Press 1 to Start");
		System.out.println("Press 2 to Exit");
		System.out.print("Enter the choice: "); 
		int x = Integer.parseInt(br.readLine());
		do {									
			switch(x) {
			case 1: startGame();
					sb=false;
					break;
			case 2:	System.out.println("\nGame Exited..! \n..See you soon..");
					sb=false;
					System.exit(0);
					//break; is not required due to termination of program
					
			default:{
				++c; /** Counter need to be treaded */
				System.out.println("\nInvalid input... Try again..!!");						
				menu(); // Calling the menu method to restart the game.				
			}
			}
		}while(sb);		
	}// Menu block
	
	public void startGame()throws IOException {
		boolean bp1,bp2,bp3;	bp1=bp2=bp3=false;
		int gp1,gp2,gp3;	gp1=gp2=gp3=0;
		char ch='\u0000';
		
		m.g_machine();// Machine Random number generating.
		int tn = m.m_num; // machine variable
		
		while(true) {			
				System.out.println("\nGuess the number between 0 - 10");				
					try {
						boolean eb=true;		
						System.out.print("Player 1: ");
						gp1 = p1.input();
						if(gp1>10)
						while(eb){
							if(gp1>10) {
								System.out.printf("Player 1 input error!");
								System.out.print("\nTry again: ");
								gp1 = p1.input();
									if(gp1>10)
										continue;
									else
										eb=false;
									if(gp1<=10) {
										break;
									}
								} 	
						  }
						eb=true; //Rset
						System.out.print("Player 2: ");
						gp2 = p2.input();
						if(gp2>10)
							while(eb){
							if(gp2>10) {
								System.out.printf("Player 2 input error!");
								System.out.print("\nTry again: ");
								gp2 = p2.input();
									if(gp2>10)
										continue;
									else
										eb=false;
							 	}
							}
						eb=true; //Rset
						System.out.print("Player 3: ");
						gp3 = p3.input();
						if(gp3>10)
							while(eb){
							if(gp3>10) {
								System.out.printf("Player 3 input error!");
								System.out.print("\nTry again: ");
								gp3 = p3.input();
									if(gp3>10)
										continue;
									else
										eb=false;
							    }	
						   }
					}catch(Exception e) {
						System.out.println("Retry!");
						continue;
					}	
					
		if(gp1==tn)
			bp1 = true;
		if(gp2==tn)
			bp2 = true;
		if(gp3==tn)
			bp3 = true; // Boolean initializations
				
		if(bp1 || bp2 || bp3) {
			System.out.println("Correct Answer: "+tn);
				if(bp1&&bp2&&bp3) {
					System.out.println("\n\"We have 3 Winners\"");
					System.out.println("Player 1 and Player 2 and Player 3 are Winners");
					System.exit(0);
				}
				if((bp1&&bp2) || (bp2&&bp3) ||(bp3&&bp1)) {
						System.out.println("\n\"We have 2 winners\" ");				
					if((bp1&&bp2)==true)
						System.out.println("Player 1 and Player 2 is Winner");			
					else if((bp2&&bp3)==true)
						System.out.println("Player 2 and Player 3 is Winner");
					else if(bp1&&bp3==true)
						System.out.println("Player 1 and Player 3 is Winner");
				} else {
						System.out.println("\n\"We have only 1 winner\"");
					if(bp1==true)
						System.out.println("Player 1 is Winner ");
					else if(bp2==true)
						System.out.println("Player 2 is Winner");
					else
						System.out.println("Player 3 is Winner");
			}
				System.out.println("Game Over Sucessfully");
				System.out.println("\nDo you want to Play again");
				System.out.print("Press Y / N: ");
				ch = sc.next().charAt(0);
				if(ch==('Y')||ch==('y'))
					menu();
				if(ch==('N')||ch==('n')) {
					System.out.println("Game End :)");
					System.exit(0);
				}
					
		}// 1st if	
		
			if((bp1==false)&&(bp2==false)&&(bp3==false)) {
				System.out.println("\nNo Player got right Try again!");
				System.out.println("Correct Answer: "+tn);
				//System.gc();
				startGame();
				}						
	}//loop	
	}// startGame method
} //Class

//------------------------------------------------------------------------------------------------

/**		boolean eb=true;		
while(eb) {
if(gp1>10) {
		System.out.printf("Player 1 input error!");
		System.out.print("\nTry again: ");
		gp1 = p1.input();
			if(gp1>10)
				continue;
	} if(gp2>10) {
		System.out.printf("Player 2 input error!");
		System.out.print("\nTry again: ");
		gp2 = p2.input();
			if(gp2>10)
				continue;
	} if(gp3>10) {
		System.out.printf("Player 3 input error!");
		System.out.print("\nTry again: ");
		gp3 = p3.input();
			if(gp3>10)
				continue;
	}// Error management
	eb=false;
} // While-loop 
*/	