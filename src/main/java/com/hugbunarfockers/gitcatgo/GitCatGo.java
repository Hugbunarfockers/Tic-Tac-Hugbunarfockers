package com.hugbunarfockers.gitcatgo;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;
import com.hugbunarfockers.gitcatgo.entities.*;
import com.hugbunarfockers.gitcatgo.services.*;

public class GitCatGo implements SparkApplication
{
	private final String sqliteConnectionString = "jdbc:sqlite:sql/mock/GitCatGoMock.db";

    public static void main(String[] args)
    {
        staticFileLocation("/public");
        SparkApplication gitCatGo = new GitCatGo();

        String port = System.getenv("PORT");
        if (port != null) {
            port(Integer.valueOf(port));
        }

        gitCatGo.init();
    }

    @Override
    public void init()
    {
		final DataService ds = new DataService(sqliteConnectionString);
		final GameBoard gb = new GameBoard();
		final GameService gs = new GameService();
		final Player p1 = new Player();
		final Player p2 = new Player();

		post("/setPlayers", (req, res) ->
		{
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

			res.header("testVal", "AMAZESPACEBALLS");
			res.status(200);
            return res;
		});

		post("/makeMove", (req, res) ->
		{
			return null;
		});
    }

}
