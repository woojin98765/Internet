import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(12345);
        byte[] buffer = new byte[1024];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        socket.receive(packet);

        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Client: " + received);

        String response = "Hello, Client!";
        DatagramPacket responsePacket = new DatagramPacket(
                response.getBytes(), response.getBytes().length,
                packet.getAddress(), packet.getPort()
        );
        socket.send(responsePacket);

        socket.close();
    }
}