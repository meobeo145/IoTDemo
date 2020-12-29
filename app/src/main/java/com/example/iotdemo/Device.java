package com.example.iotdemo;

public class Device {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getMac() {
//        return mac;
//    }
//
//    public void setMac(String mac) {
//        this.mac = mac;
//    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Device(String name, String humidity, String light, String temperature) {
        this.name = name;
//        this.mac = mac;
        this.humidity = humidity;
        this.light = light;
        this.temperature = temperature;
    }

    public Device() {
    }

    private String name;
//    private String mac;
    private String humidity;
    private String light;
    private String temperature;
}
