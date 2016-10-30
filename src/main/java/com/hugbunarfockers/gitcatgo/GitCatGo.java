package com.hugbunarfockers.gitcatgo;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;
import com.hugbunarfockers.gitcatgo.entities.*;
import com.hugbunarfockers.gitcatgo.services.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GitCatGo implements SparkApplication
{
	private static String connectionString;
	private static Map gameSessions;
	private static IDataService ds;

    public static void main(String[] args)
    {
        staticFileLocation("/public");
        SparkApplication gitCatGo = new GitCatGo();

		gameSessions = new HashMap();
		setConnectionString();
		ds = new DataService(connectionString);

        String port = System.getenv("PORT");
        if (port != null) {
            port(Integer.valueOf(port));
        }

        gitCatGo.init();
    }

    @Override
    public void init()
    {
		post("/setPlayers", (req, res) ->
		{
			IGameService gs = new GameService();
			GameBoard gb = new GameBoard();
			Player p1 = new Player();
			Player p2 = new Player();

			final String p1name = req.queryParams("player1name"),
						 p1key = req.queryParams("player1key"),
						 p2name = req.queryParams("player2name"),
						 p2key = req.queryParams("player2key");

			ds.addPlayer(p1name, p1key);
			ds.addPlayer(p2name, p2key);

			Player p1temp = ds.getPlayer(
				p1name,
				p1key
			);
			p1.setID(p1temp.getID());
			p1.setName(p1temp.getName());
			p1.setKey(p1temp.getKey());

			Player p2temp = ds.getPlayer(
				p2name,
				p2key
			);
			p2.setID(p2temp.getID());
			p2.setName(p2temp.getName());
			p2.setKey(p2temp.getKey());

			gs.setBoard(gb);
			gs.setPlayer1(p1);
			gs.setPlayer2(p2);

			gameSessions.put(req.session().id().toString(), gs);

			res.status(200);
            return res;
		});

		post("/makeMove", (req, res) ->
		{
			IGameService gs = (GameService) gameSessions.get(req.session().id().toString());
			Player p1 = gs.getPlayer1();
			Player p2 = gs.getPlayer2();

			String cell = req.queryParams("cell");
			char move = cell.charAt(cell.length()-1);

			if(gs.makeMove(move))
			{
				Player checkPlayer = gs.getCurrentPlayer();

				if (checkPlayer.getID() == p1.getID())
				{
					res.header("char", "X");
				}
				else
				{
					res.header("char", "O");
				}

				if(gs.checkWinner())
				{
					int p1ID, p2ID, wID;
					p1ID = p1.getID();
					p2ID = p2.getID();
					wID = checkPlayer.getID();
					ds.addScore(p1ID, p2ID, wID);
					res.header("winner", checkPlayer.getName());
				}
				else if(gs.isBoardFull())
				{
					int p1ID, p2ID;
					p1ID = p1.getID();
					p2ID = p2.getID();
					ds.addScore(p1ID, p2ID, 0);
					res.header("winner", "draw");
				}

				gs.changeCurrentPlayer();

				res.status(200);
			}
			else
			{
				res.status(500);
			}

			return res;
		});

		post("/resetGame", (req, res) ->
		{
			IGameService gs = (GameService) gameSessions.get(req.session().id().toString());
			gs.resetGame();
			

			return res;
		});
    }

	private static void setConnectionString()
    {
		//String serverFilePath = System.getProperty("user.dir") + "/servers/sql/sql_server.txt";
		String serverFilePath = System.getProperty("user.dir") + "/servers/sql/local_sqlite.txt";
        try
		{
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(serverFilePath));
			try
			{
				connectionString = reader.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					reader.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
    }
}
