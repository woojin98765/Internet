import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPChatServer {
    public static void main(String[] args) {
        try {
            String myIp = InetAddress.getLocalHost().getHostAddress();
            ServerSocket serverSocket = new ServerSocket(12340);
            System.out.println("TCP 채팅 서버 시작 (" + myIp + ":12340)");

            Socket socket = serverSocket.accept();
            System.out.println("클라이언트 연결됨: " + socket.getInetAddress().getHostAddress());

            // 입력/출력 스트림 준비
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            // 클라이언트 메시지 수신 스레드
            Thread receiveThread = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println("\n[클라이언트] " + msg);
                        System.out.print("서버> ");
                    }
                } catch (IOException e) {
                    System.out.println("클라이언트 연결 종료");
                }
            });
            receiveThread.start();

            // 서버 메시지 송신 루프
            System.out.print("서버> ");
            while (true) {
                String message = sc.nextLine();
                if (message.equalsIgnoreCase("exit")) break;
                out.println(message);
            }

            // 종료
            socket.close();
            serverSocket.close();
            sc.close();
            System.out.println("서버 종료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

