package weatherExtraTest;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by waynamigo on 18-11-25
 */
@Entity
public class Weather implements Serializable {
    @Autowired
    @Id
    private Integer weatherid;
    private String location;
    private Date date;
    private Integer tempreture;
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTempreture() {
        return tempreture;
    }

    public void setTempreture(Integer tempreture) {
        this.tempreture = tempreture;
    }
}
