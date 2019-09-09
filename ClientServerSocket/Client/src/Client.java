import connetcion.Connect;

import java.io.*;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {

      try(Connect connection = new Connect("127.0.0.1", 8000)) {

          Scanner input = new Scanner(System.in);
System.out.println("Connected to server");
System.out.println("Enter a city where you want to know a weather forecast.");
String request = input.next();
connection.writeLine(request);
String response = connection.readLine();
System.out.println("So the weather in "+request+" is "+response +" °C");

      } catch (IOException e){
          e.printStackTrace();
      }
    }
}
