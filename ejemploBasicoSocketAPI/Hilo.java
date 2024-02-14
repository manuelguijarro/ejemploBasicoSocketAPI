import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Hilo implements Runnable{
    Socket cliente;

    public Hilo(Socket _cliente){
        this.cliente = _cliente;
    }

    public String getUsers(){
        return "dani;pepe;jose;pepe2";
    }

    @Override
    public void run() {
        try {
            BufferedReader bfr = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()));
            String url = bfr.readLine();
            String api = url.split("/")[url.split("/").length-1];
            if(api.contains("addUser")){
                String userName = api.split(":")[1];
                System.out.println("Usuario "+ userName + " añadido");
            }
            if(api.contains("getUsers")){
                bfw.write(getUsers());
                bfw.newLine();
                bfw.flush();
            }
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        //cliente.getInputS
    }
    
}
