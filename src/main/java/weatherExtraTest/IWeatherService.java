package weatherExtraTest;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by waynamigo on 18-11-28
 */
public interface IWeatherService extends Remote {
    public Weather getWeather(String location)throws RemoteException;
    public List<Weather> getWeatherList()throws RemoteException;
}
