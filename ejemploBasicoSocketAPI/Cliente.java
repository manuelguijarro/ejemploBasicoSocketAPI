import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Cliente {
    private Socket socket;
    public Cliente(String host, int port) throws Exception{
        socket = new Socket(host, port);
    }
    public void send(String msg) throws Exception{
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bfw.write(msg);
        bfw.newLine();
        bfw.flush();
    }
    public void read() throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg = bfr.readLine();
        System.out.println(msg);
    }
    public static void main(String[] args) throws Exception{
        Cliente c = new Cliente("localhost", 12345);
        c.send("/api/addUser:Dani");
        c.read();
    }
}
