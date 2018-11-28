package weatherExtra;

import org.springframework.beans.factory.annotation.Autowired;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by waynamigo on 18-11-25
 */
public class WeatherService implements Remote {
    @Autowired
    private WeatherRepository weatherRepository;

    public Weather getWeather(String location) {

        return weatherRepository.findWeatherByLocation(location);

    }
    public List<Weather> getWeatherList(){
        return weatherRepository.findAll();
    }
}
