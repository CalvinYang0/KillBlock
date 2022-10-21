package com.Shark.GameStart;

import com.Shark.Client.Client;
import com.Shark.Paint.GameFrame;


public class Start {
    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        Client client = new Client();
        frame.addKeyListener(client);

    }

}
