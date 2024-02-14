import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        while(true){
            Socket client = serverSocket.accept();
            //Nuevo cliente
            Hilo h = new Hilo(client);
            new Thread(h).start();
        }
    }
}
