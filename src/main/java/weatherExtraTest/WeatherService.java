package weatherExtraTest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * Created by waynamigo on 18-11-25
 */
public class WeatherService extends UnicastRemoteObject implements IWeatherService {

    private WeatherRepository weatherRepository;

    protected WeatherService() throws RemoteException {
        super();
    }
    @Override
    public Weather getWeather(String location) throws RemoteException{
        return weatherRepository.findWeatherByLocation(location);

    }
    @Override
    public List<Weather> getWeatherList()throws RemoteException{
        return weatherRepository.findAll();
    }
}
