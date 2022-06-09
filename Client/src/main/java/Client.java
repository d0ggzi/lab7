import commands.AuthData;
import java.nio.channels.DatagramChannel;

public class Client {
    public static void main(String[] args) {
        try{
            DatagramChannel channel = DatagramChannel.open();
            channel.configureBlocking(false);
            ClientSender clientSender = new ClientSender(channel);
            ClientReceiver clientReceiver = new ClientReceiver(channel);

            System.out.println("Привет! Авторизируйся - напиши login или register");

            AuthData authData = new Authorisation().authorize(clientSender, clientReceiver);

            System.out.println("Добро пожаловать! Напиши help, чтобы узнать функционал");
            ClientApp app = new ClientApp();
            app.start(clientSender, clientReceiver, authData);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
