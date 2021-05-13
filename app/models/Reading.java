package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Reading extends Model {
    public int code;
    public float temperature;
    public float windSpeed;
    public int windDirection;
    public int pressure;

    public Reading(int code, float temperature, float windSpeed, int windDirection, int pressure) // constructor
    {
        if (code >= 100 && code <= 800) {
            this.code = code;
        }
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        if(windDirection >= 0 && windDirection <= 360){
        this.windDirection = windDirection;
         }
        this.pressure = pressure;
    }


    public int getCode() {                       //getters
        return this.code;
    }

    public float getTemperature() {
        return this.temperature;
    }

    public float getWindSpeed() {
        return this.windSpeed;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public int getPressure() {
        return this.pressure;
    }

    public void setCode(int code) {          //setters
        this.code = code;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }


}