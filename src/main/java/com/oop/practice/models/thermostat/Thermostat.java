package com.oop.practice.models.thermostat;

import com.oop.practice.pojos.TemperatureLog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.oop.practice.constants.ThermostatConstants.*;

public class Thermostat {

    private double temp;
    private List<TemperatureLog> temperatureLogList;

    public Thermostat() {
        temp = DEFAULT_TEMP;
        temperatureLogList = new ArrayList<>();
        temperatureLogList.add(TemperatureLog.logTemp(DEFAULT_TEMP,String.format(INITIALIZED,DEFAULT_TEMP)));

    }

    public double getTemp() {
        return temp;
    }

    public List<TemperatureLog> getTemperatureLogList() {
        return Collections.unmodifiableList(temperatureLogList);
    }

    public double increaseTemp(double tempIncrement){
        if (tempIncrement < 0){
            temperatureLogList.add(TemperatureLog.logTemp(temp,ERR_NEGATIVE_CHANGE));
            throw new IllegalArgumentException(ERR_NEGATIVE_CHANGE);
        }
        if ( temp + tempIncrement > UPPER_LIMIT) {
            temperatureLogList.add(TemperatureLog.logTemp(temp,ERR_ABOVE_MAX));
            throw new IllegalStateException(ERR_ABOVE_MAX);
        }
        temp+=tempIncrement;
        temperatureLogList.add(TemperatureLog.logTemp(temp,String.format(LOG_INCREASE,temp-tempIncrement,temp)));
        return temp;
    }

    public double decreaseTemp(double tempDecrement) {
        if (tempDecrement < 0){
            TemperatureLog.logTemp(temp,ERR_NEGATIVE_CHANGE);
            throw new IllegalArgumentException(ERR_NEGATIVE_CHANGE);
        }
        if (temp - tempDecrement < LOWER_LIMIT) {
            TemperatureLog.logTemp(temp,ERR_BELOW_MIN);
            throw new IllegalStateException(ERR_BELOW_MIN);
        }
        temp-=tempDecrement;
        temperatureLogList.add(TemperatureLog.logTemp(temp,String.format(LOG_DECREASE,temp+tempDecrement,temp)));
        return temp;
    }

}
