import java.util.Scanner; 
public class TicTacToe {
	Scanner input = new Scanner(System.in);
	String [][] Board = {{" " , " " , " "},{" " , " " , " "},{" " , " " , " "}};
	String player1name;
    String player1shape;
    String player2name;
    String player2shape;
    int row;
    int column;
    int n;
    String l = "a";
	public static void main(String[] args) {
		TicTacToe tictactoe = new TicTacToe();
	}
	
	TicTacToe() {
	    profile();
	    boardPrint();
	    userInput();
	    
	}
	
	void profile( ) {
        int a = 0;
        System.out.println("Enter first player name:");
        player1name = input.nextLine();
        System.out.println("Select X or O :");
        do {
          a = 0;
          player1shape = input.nextLine();
          switch (player1shape) {
            case "X" :{
                player1shape = "X";
                player2shape = "O";
            } break;
            case "O" :{
                player2shape = "X";
                player1shape = "O";
            } break;
            default :{
              System.out.println("Please select X or O :");
              a = 1;
            }  
          } 
        } while (a == 1);
        System.out.println("Enter second player name:");
        player2name = input.nextLine();
        System.out.println(player1name + " = " +  player1shape + "\n" + player2name + " = " + player2shape);

	}
	
	void boardPrint( ) {
		for(int i=0; i<3; i++){
	          int j=0;
	          int k=0;
	          if (i==2) {
	            k = 1;
	          }
	          System.out.println(Board[i][j] + " | " + Board[i][j+=1] + " | " + Board[i][j+=1]);
	          if (k==0) {
	            System.out.println("-- --- --");
	          } 
	        }
	}
	
	void userInput(){
		for(n=0; n<9; n++) {
		   switch (l) {
           case "a":{
             System.out.println(player1name + " select the Row and Column to place " + player1shape + ":");
             row = input.nextInt();
             column = input.nextInt();
             indexcheck();
             locationcheckforplayer1();
             boardPrint();
             l = "b";  
             ReturnPlayer1();
             wincheckplayer1();
             
           }break;
           default:{
             System.out.println(player2name + " select the Row and Column to place " + player2shape + ":");
             row = input.nextInt();
             column = input.nextInt();
             indexcheck();
             locationcheckforplayer2();
             boardPrint();
             l="a";
             ReturnPlayer2();
             wincheckplayer2();
             
           }break;
         }
      }
	}	
	
	void locationcheckforplayer1() {
		int s=0;
		if(Board[row-1][column-1] != " "){
		  while(s<1){
		    System.out.println(player1name + " " + "This location is already filled please select other location :");
		    row = input.nextInt();
		    column = input.nextInt();
		    indexcheck();
		    if (Board[row-1][column-1] == " ") {
		        Board[row-1][column-1] = player1shape;
		        s=1;
		    }
		  }
		}
		else {
		      Board[row-1][column-1] = player1shape;
		      s=1;
		}
	}
	
	void locationcheckforplayer2() {
		int s=0;
		if(Board[row-1][column-1] != " "){
		  while(s<1){
		    System.out.println(player2name + " " + "This location is already filled please select other location :");
		    row = input.nextInt();
		    column = input.nextInt();
		    indexcheck();
		    if (Board[row-1][column-1] == " ") {
		        Board[row-1][column-1] = player2shape;
		        s=1;
		    }
		  }
		}
		else {
		      Board[row-1][column-1] = player2shape;
		      s=1;
		}
	}
	
	void indexcheck() {
		int e=0;
        if(3<row || row<1 || 3<column || column<1){
          while(e<1){
            System.out.println("This location does not exist try other location :");
            int row2 = input.nextInt();
            int column2 = input.nextInt();
            if (0<row2 && row2<4 && 0<column2 && column2<4) {
              row = row2;
              column = column2;
              e=1;
            }
          }
	    }

    }
	
	void wincheckplayer1() {
		for(int m=0; m<3; m++) {
		   if(Board[m][0]==player1shape && Board[m][1]==player1shape && Board[m][2]==player1shape) {
			   System.out.println(player1name + " " + "Wins");
			   n=10;
			
		   }
		}
		for(int m=0; m<3; m++) {
		   if(Board[0][m]==player1shape && Board[1][m]==player1shape && Board[2][m]==player1shape) {
			   System.out.println(player1name + " " + "Wins");
			   n=10;
				
		   }
		}
		if(Board[0][0]==player1shape && Board[1][1]==player1shape && Board[2][2]==player1shape) {
			   System.out.println(player1name + " " + "Wins");
			   n=10;
		}
		if(Board[0][2]==player1shape && Board[1][1]==player1shape && Board[2][0]==player1shape) {
			   System.out.println(player1name + " " + "Wins");
			   n=10;
		}
		if(n!=10) {
		   if(Board[0][0]!=" " && Board[0][1]!=" " && Board[0][2]!=" " && Board[1][0]!=" " && Board[1][1]!=" " && Board[1][2]!=" " && Board[2][0]!=" " && Board[2][1]!=" " && Board[2][2]!=" ") {
			   System.out.println("The game is a tie!");
		   }
		}
	}
	
	void wincheckplayer2() {
		for(int m=0; m<3; m++) {
		   if(Board[m][0]==player2shape && Board[m][1]==player2shape && Board[m][2]==player2shape) {
			   System.out.println(player2name + " " + "Wins");
			   n=10;
			
		   }
		}
		for(int m=0; m<3; m++) {
		   if(Board[0][m]==player2shape && Board[1][m]==player2shape && Board[2][m]==player2shape) {
			   System.out.println(player2name + " " + "Wins");
			   n=10;
				
		   }
		}
		if(Board[0][0]==player2shape && Board[1][1]==player2shape && Board[2][2]==player2shape) {
			   System.out.println(player2name + " " + "Wins");
			   n=10;
		}
		if(Board[0][2]==player2shape && Board[1][1]==player2shape && Board[2][0]==player2shape) {
			   System.out.println(player2name + " " + "Wins");
			   n=10;
		}
	}
	
	void ReturnPlayer1() {
		System.out.println("Enter '1' to continue OR '2' To reverse your move");
		int confirmMove = input.nextInt();
		if (confirmMove==2) {
			Board[row-1][column-1]=" ";
			boardPrint();
			n--;
			l = "a";	
		}
	}
	
	void ReturnPlayer2() {
		System.out.println("Enter '1' to continue OR '2' To reverse your move");
		int confirmMove = input.nextInt();
		if (confirmMove==2) {
			Board[row-1][column-1]=" ";
			boardPrint();
			n--;
			l = "b";
		}
	}

};