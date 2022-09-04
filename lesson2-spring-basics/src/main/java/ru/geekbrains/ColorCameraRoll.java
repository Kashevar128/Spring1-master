package ru.geekbrains;

import org.springframework.stereotype.Component;

@Component("cameraRoll")
public class ColorCameraRoll implements CameraRoll{
    @Override
    public void processing() {
        System.out.println("-1 цветной кадр");
    }
}
