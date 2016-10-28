package com.hugbunarfockers.gitcatgo;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class GitCatGo implements SparkApplication {

    public static void main(String[] args) {
        staticFileLocation("/public");
        SparkApplication gitCatGo = new GitCatGo();

        String port = System.getenv("PORT");
        if (port != null) {
            port(Integer.valueOf(port));
        }

        gitCatGo.init();
    }

    @Override
    public void init() {
        // TODO
    }

}
