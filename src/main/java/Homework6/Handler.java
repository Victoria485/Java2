package Homework6;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Handler {
    private static int clientCounter = 0;
    private int clientNumber;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private Thread handlerThread;
    private static ArrayList<Socket> sockets = new ArrayList<Socket>();

    public Handler(Socket socket) {
        try {
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Handler created");
            this.clientNumber = ++clientCounter;
            sockets.add(this.socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handle() {
        handlerThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted() && socket.isConnected()) {
                try {
                    String message = in.readUTF();
                    System.out.printf("Client #%d: %s\n", this.clientNumber, message);
                    for (int i = 0; i < sockets.size(); i++) {
                        new DataOutputStream((sockets.get(i)).getOutputStream()).writeUTF("For all from client #" + this.clientNumber + ": " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        handlerThread.start();
    }

    public Thread getHandlerThread() {
        return handlerThread;
    }
}