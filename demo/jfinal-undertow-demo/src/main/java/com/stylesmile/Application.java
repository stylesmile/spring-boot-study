package com.stylesmile;

import com.jfinal.server.undertow.UndertowServer;

/**
 * @author chenye
 */
public class Application {

    public static void main(String[] args) {
        UndertowServer.start(AppConfig.class);
    }
}
