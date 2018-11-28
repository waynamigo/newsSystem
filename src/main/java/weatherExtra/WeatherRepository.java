package weatherExtra;

import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by waynamigo on 18-11-25
 */
public interface WeatherRepository extends JpaRepository<Weather,Integer> {
    public List<Weather> findAll();
    public Weather findWeatherByLocation(String location);
}
