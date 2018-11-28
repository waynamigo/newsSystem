package weatherExtraTest;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class WeatherApplication {
    public static void main(String[] args) {
        try {
            IWeatherService weatherService=new WeatherService();
//注册通讯端口
            LocateRegistry.createRegistry(6600);
//注册通讯路径
            Naming.rebind("rmi://127.0.0.1:6600/WeatherService", weatherService);
            System.out.println("Service Start!");
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
