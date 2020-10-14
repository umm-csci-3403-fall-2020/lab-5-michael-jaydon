package echoserver;

import java.io.*;
import java.net.*;

public class EchoServer {
    private static final int portNumber = 6013;

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            ServerSocket sock = new ServerSocket(portNumber);

            while (true) {
                Socket client = sock.accept();
                System.out.println("Processing input. . .");
                InputStream input = client.getInputStream();
                OutputStream output = client.getOutputStream();
                int bytes;
                while ((bytes = input.read()) != -1) {
                    output.write(bytes);
                }
                output.flush();
                client.close();
            }
        } catch (IOException ioe) {
            System.out.println("We caught an unexpected error");
            System.err.println(ioe);
        }
    }
}