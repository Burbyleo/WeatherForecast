import connetcion.Connect;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args)  {

        try(ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server started.");

            while (true) {
                Connect connect = new Connect(server);
                    //http://localhost8000 or telnet 127.0.0.1 8000
     new Thread(() ->  {
         String request = connect.readLine();
         System.out.println("Request: " + request);
         String response = (int) (Math.random() * 30 - 10) + "";
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         connect.writeLine(response);
         System.out.println("Response: " + response);
      try { connect.close();} catch (IOException e) {}
            }).start();

                }


            } catch(IOException e ){
                throw new RuntimeException(e);
            }

        }
}