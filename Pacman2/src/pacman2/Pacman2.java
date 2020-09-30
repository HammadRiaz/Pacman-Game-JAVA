
package pacman2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Hammad Riaz
 */
public class Pacman2 
{

    
    
}

class Vertex 
{
    Vertex Left;
    Vertex UP;
    Vertex Down;
    Vertex Right;
    int score=10;
    
    Object Label;
    boolean status=true;
    
    public Vertex(Object Label) 
    {
        this.Label = Label;
    }
         
    public Vertex() {
    }
}

class GRAPH
{
    int N; //Total Number of NODES
    int n;
    int nn; //Number of nodes created 
    Vertex[][] VMatrix; //Marix of all the nodes
    int edge[][];   //MAtrix showing the connectivity

    public GRAPH() {
    }
    
    public GRAPH(int NV)
    {
        N=NV;
        n=0;
        nn=0;
        VMatrix=new Vertex[NV][NV];
        
    }
    
    public void add_ALL()
    {
        Rectangle R=new Rectangle(70,70,70,70);
        Vertex[][] NEW=new Vertex[N][N];
       
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                NEW[i][j]=new Vertex(R);
        
                VMatrix[i][j]=NEW[i][j];
            }
        }
    }
    public void setStatus(Vertex a)
    {
        a.status=false;
    }
    public void connection()
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(i==0)
                {
                    if(j==0)
                    {
                        VMatrix[i][j].Right=VMatrix[i][j+1];
                        VMatrix[i][j].Left=null;
                        VMatrix[i][j].UP=null;
                        VMatrix[i][j].Down=VMatrix[i+1][j];
                    }
                    else if(j!=0&&j!=N-1)
                    {
                        
                        VMatrix[i][j].UP=null;
                        VMatrix[i][j].Down=VMatrix[i+1][j];
                        VMatrix[i][j].Left=VMatrix[i][j-1];
                        VMatrix[i][j].Right=VMatrix[i][j+1];
                        
                    }
                    else if(j==N-1)
                    {
                        VMatrix[i][j].Right=null;
                        VMatrix[i][j].Down=VMatrix[i+1][j];
                        VMatrix[i][j].UP=null;
                        VMatrix[i][j].Left=VMatrix[i][j-1];
                       
                    }
                    
                }
                if(i!=0&&i!=N-1)
                {
                    if(j==0)
                    {
                        VMatrix[i][j].Down=VMatrix[i+1][j];
                        VMatrix[i][j].UP=VMatrix[i-1][j];
                        VMatrix[i][j].Right=VMatrix[i][j+1];
                        VMatrix[i][j].Left=null;
                    }
                    else if(j!=N-1&&j!=0)
                    {
                        VMatrix[i][j].Left=VMatrix[i][j+1];
                        VMatrix[i][j].Right=VMatrix[i][j-1];
                        VMatrix[i][j].UP=VMatrix[i-1][j];
                        VMatrix[i][j].Down=VMatrix[i+1][j];
                    }
                    else if(j==N-1)
                    {
                        VMatrix[i][j].UP=VMatrix[i-1][j];
                        VMatrix[i][j].Down=VMatrix[i+1][j];
                        VMatrix[i][j].Left=VMatrix[i][j-1];
                        VMatrix[i][j].Right=null;
                    }
                }
                if(i==N-1)
                {
                    if(j==0)
                    {
                        VMatrix[i][j].Right=VMatrix[i][j+1];
                        VMatrix[i][j].Down=null;
                        VMatrix[i][j].UP=VMatrix[i-1][j];
                        VMatrix[i][j].Left=null;
                    }
                    else if(j!=0&&j!=N-1)
                    {
                        VMatrix[i][j].UP=VMatrix[i-1][j];
                        VMatrix[i][j].Right=VMatrix[i][j+1];
                        VMatrix[i][j].Left=VMatrix[i][j-1];
                        VMatrix[i][j].Down=null;
                    }
                    else if(j==N-1)
                    {
                        VMatrix[i][j].Right=null;
                        VMatrix[i][j].Down=null;
                        VMatrix[i][j].UP=VMatrix[i-1][j];
                        VMatrix[i][j].Left=VMatrix[i][j-1];
                    }
                    
                
                }
                
                
            }
        }
    }
    public void setWalls()
    {
        for(int i=0;i<N;i++)
        {
            setStatus(VMatrix[0][i]);
            setStatus(VMatrix[i][0]);
            setStatus(VMatrix[N-1][i]);
            setStatus(VMatrix[i][N-1]);
        }
            setStatus(VMatrix[1][5]);
            setStatus(VMatrix[1][6]);
            setStatus(VMatrix[2][2]);
            setStatus(VMatrix[2][9]);
            setStatus(VMatrix[3][2]);
            setStatus(VMatrix[3][4]);
            setStatus(VMatrix[3][5]);
            setStatus(VMatrix[3][6]);
            setStatus(VMatrix[3][7]);
            setStatus(VMatrix[3][9]);
            setStatus(VMatrix[4][2]);
            setStatus(VMatrix[4][9]);
            setStatus(VMatrix[5][2]);
            setStatus(VMatrix[5][4]);
            setStatus(VMatrix[5][7]);
            setStatus(VMatrix[5][9]);
            setStatus(VMatrix[6][4]);
            setStatus(VMatrix[6][7]);
            setStatus(VMatrix[7][4]);
            setStatus(VMatrix[7][5]);
            setStatus(VMatrix[7][6]);
            setStatus(VMatrix[7][7]);
            setStatus(VMatrix[8][2]);
            setStatus(VMatrix[8][9]);
            setStatus(VMatrix[9][2]);
            setStatus(VMatrix[9][3]);
            setStatus(VMatrix[9][5]);
            setStatus(VMatrix[9][6]);
            setStatus(VMatrix[9][8]);
            setStatus(VMatrix[9][9]);
            setStatus(VMatrix[10][5]);
            setStatus(VMatrix[10][6]);
    }
    public void TRAVEL(int x,int y)
    {
        int scorr=0;
        Vertex Pac=VMatrix[x][y];
        if(Pac.status)
        {
            
        }
        Queue<Vertex> Q=new LinkedList<>();
        Vertex save=null;
        while(Pac!=VMatrix[8][6])
        {
            
        try {
            Thread.sleep(200);
            } catch (InterruptedException ex) {
                    Logger.getLogger(Pacman2.class.getName()).log(Level.SEVERE, null, ex);
                }
            System.out.println(Pac);
            if(Pac.Left.status)
            {
                if(Pac.UP.status)
                {
                    if(save!=Pac.UP)
                    Q.add(Pac.UP);
                    
                }
                if(Pac.Right.status)
                {
                    if(save!=Pac.Right)
                    Q.add(Pac.Right);
                }
                if(Pac.Down.status)
                {
                    if(save!=Pac.Down)
                    Q.add(Pac.Down);
                }
                if(save!=Pac.Left)
                Q.add(Pac.Left);
                
            }
            else if(Pac.Down.status)
            {
                if(Pac.Left.status)
                {
                    if(save!=Pac.Left)
                    Q.add(Pac.Left);
                }
                if(Pac.UP.status)
                {
                    if(save!=Pac.UP)
                    Q.add(Pac.UP);
                }
                if(Pac.Right.status)
                {
                    if(save!=Pac.Right)
                    Q.add(Pac.Right);
                }
                if(save!=Pac.Down)
                  Q.add(Pac.Down);
            
            }
            else if(Pac.Right.status)
            {  
                if(Pac.Down.status)
                {
                    if(save!=Pac.Down)
                    Q.add(Pac.Down);
                }
                 
                if(Pac.Left.status)
                {
                    if(save!=Pac.Left)
                    Q.add(Pac.Left);
                }
                if(Pac.UP.status)
                {
                    if(save!=Pac.UP)
                    Q.add(Pac.UP);
                }
                if(save!=Pac.Right)
                Q.add(Pac.Right);
            }
            else if(Pac.UP.status)
            {
                
                if(Pac.Right.status)
                {
                    if(save!=Pac.Right)
                    Q.add(Pac.Right);
                }
                if(Pac.Down.status)
                {
                    if(save!=Pac.Down)
                    Q.add(Pac.Down);
                }
                if(Pac.Left.status)
                {
                    if(save!=Pac.Left)
                    Q.add(Pac.Left);
                }
                if(save!=Pac.UP)
                Q.add(Pac.UP);
            }
           save=Pac; 
           Pac=Q.remove();
           scorr=scorr+Pac.score;
           Q.clear();
        }
        System.out.println("Your TUKKA Score is:"+scorr);
            
    }
    
    public static void main(String[] args)
    {
        GRAPH a=new GRAPH(12);
        a.add_ALL();
        a.connection();
        a.setWalls();
        //a.setStatus(a.VMatrix[0][0]);
//
//        for(int i=0;i<12;i++)
//        {
//            for(int j=0;j<12;j++)
//            {
//                System.out.println(a.VMatrix[i][j].status);
//            }
//        }
        System.out.println("Enter X and Y placements giving a TUKKA to get the nearest placements"
                + "\n\t\t\t toward the GOAL"
                + "\nTHE LOWER the Score,"
                + "\nmore of a WINNER you GET");
        System.out.println("Enter X axis:(Ranges from 0 - 11)");
        java.util.Scanner in=new java.util.Scanner(System.in);
        int X=in.nextInt();
        System.out.println("Enter Y axis: (Ranges from 0 to 11)");
        int Y=in.nextInt();
        
        if(X>11&&Y>11)
        {
            System.out.println("\tOOPS! you DISOBEYED THE RULES !"
                             + "\n\t Hence YOU are DISBANDED XD"); 
            System.exit(0);
        }
        Vertex Enter= a.VMatrix[X][Y];
        for(int i=0;!Enter.status;i++)
        {
            System.out.println("Xb What YOU selected is a WALL!  BAKKA");
            System.out.println("Enter X axis:(Ranges from 0 - 11)");
            X=in.nextInt();
            
            System.out.println("Enter Y axis: (Ranges from 0 to 11)");
            Y=in.nextInt();
       
            
            if(X>11&&Y>11)
            {
                System.out.println("\t OOPS! you DISOBEYED THE RULES !"
                             + "\n\t Hence YOU are DISBANDED XD"); 
                System.exit(0);
            }
            Enter= a.VMatrix[X][Y];
        }
        a.TRAVEL(X, Y);
    }
    
}
