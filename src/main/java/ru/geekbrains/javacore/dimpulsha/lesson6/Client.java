package ru.geekbrains.javacore.dimpulsha.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in);
        Socket socket= new Socket("localhost",8181)) {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            while (true) {
                out.writeUTF(scanner.nextLine());
                System.out.println(inputStream.readUTF());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
