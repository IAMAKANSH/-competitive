package topic.graph;

import java.util.Scanner;

public class KnightTour {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter chess board");
        int n=sc.nextInt();
        System.out.println("Enter knight row position");
        int r=sc.nextInt();
        System.out.println("Enter knight col position");
        int c=sc.nextInt();

        int[][] chessboard=new int[n][n];
        printKnightTour(chessboard,r,c,1);
        printChessBoard(chessboard);
    }

    private static void printChessBoard(int[][] chessboard) {

        for (int i=0;i<chessboard.length;i++)
        {
            for (int j=0;j<chessboard.length;j++)
            {
                System.out.print(chessboard[i][j]);
            }
            System.out.println();
        }
    }

    private static void printKnightTour(int[][] chessboard, int r, int c, int move) {

        if(r<0 || c<0 || r>=chessboard.length || c>=chessboard.length || chessboard[r][c]>0 )
            return;
        else if(move== chessboard.length*chessboard.length)
        {
            chessboard[r][c]=move;
            printChessBoard(chessboard);
            chessboard[r][c]=0;
            return;
        }
        chessboard[r][c]=move;
        printKnightTour(chessboard,r-2,c+1,move+1);

        printKnightTour(chessboard,r-1,c+2,move+1);

        printKnightTour(chessboard,r+1,c+2,move+1);

        printKnightTour(chessboard,r+2,c+1,move+1);

        printKnightTour(chessboard,r+2,c-1,move+1);

        printKnightTour(chessboard,r+1,c-2,move+1);

        printKnightTour(chessboard,r-1,c-2,move+1);
        printKnightTour(chessboard,r-2,c-1,move+1);
        chessboard[r][c]=0;

    }
}
