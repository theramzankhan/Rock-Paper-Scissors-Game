import java.io.*;

enum Selection
{
	ROCK, PAPER, SCISSOR;
};

class Game
{
	public static void main(String args[])
	{
		Selection user, comp;
		int nt=0,  uw=0, cw=0;

		Console c = System.console();

		int ng = Integer.parseInt(c.readLine("Enter number of games in the tournament : "));
		int i=1;

		while(i++ <= ng)
		{
			int co = (int)(Math.random() * 3);
			if(co == 0)
				comp = Selection.ROCK;
			else if(co == 1)
				comp = Selection.PAPER;
			else
				comp = Selection.SCISSOR;

		int us = Integer.parseInt(c.readLine("0 ROCK , 1 PAPER and 2 SCISSOR "));
		if(us == 0)
			user = Selection.ROCK;
		else if(us == 1)
			user = Selection.PAPER;
		else
			user = Selection.SCISSOR;

		if(user == Selection.ROCK && comp == Selection.ROCK)                           nt++;
		else if(user == Selection.PAPER && comp == Selection.PAPER)                    nt++;
		else if(user == Selection.SCISSOR && comp == Selection.SCISSOR)                nt++;
		else if(user == Selection.ROCK && comp == Selection.SCISSOR)                   uw++;
		else if(user == Selection.PAPER && comp == Selection.ROCK)                     uw++;
		else if(user == Selection.SCISSOR && comp == Selection.PAPER)                  uw++;
		else if(comp == Selection.ROCK && comp == Selection.SCISSOR)                   cw++;
		else if(comp == Selection.PAPER && comp == Selection.ROCK)                     cw++;
		else if(comp == Selection.SCISSOR && comp == Selection.PAPER)                  cw++;
		System.out.println(comp.name() + " " +user.name());

		System.out.println(" Ties " +nt + " User " + uw + " comp " + cw);
		}

		try
		{
			File f = new File("score.txt");
			FileWriter fw = new FileWriter(f,true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(new java.util.Date() + "  --->  " + " Ties " + nt + " User " + uw + " Comp " + cw);
			pw.close();
		}
		catch(IOException ie)
		{
			System.out.println(ie);
		}
	}
}