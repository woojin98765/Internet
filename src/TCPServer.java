import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        String myIp = new MyIp().getLocalIp();
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is running on " + myIp + ":1234 ....");

        Socket socket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("한국의 수도는 어디일까요?");
        String clientMessage = in.readLine();
        System.out.println("Client: " + clientMessage);

        if ("서울".equals(clientMessage)) {
            out.println("정답!");
        } else {
            out.println("오답~");
        }


        socket.close();
        serverSocket.close();
    }
}
