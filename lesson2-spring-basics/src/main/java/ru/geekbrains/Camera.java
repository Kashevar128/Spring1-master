package ru.geekbrains;

public interface Camera {

    public void doPhotograph();

    public CameraRoll getCameraRoll();

    public void setCameraRoll(CameraRoll cameraRoll);

    void breaking();

    boolean isBroken();

    void ready();
}
