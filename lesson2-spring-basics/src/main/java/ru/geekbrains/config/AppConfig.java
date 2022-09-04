package ru.geekbrains.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.geekbrains.Camera;
import ru.geekbrains.CameraImpl;
import ru.geekbrains.CameraRoll;
import ru.geekbrains.ColorCameraRoll;

@Configuration
@ComponentScan("ru.geekbrains")
public class AppConfig {
//    @Bean(name = "cameraRoll")
//    public CameraRoll cameraRoll() {
//        return new ColorCameraRoll();
//    }
//
//    @Bean(name = "camera")
//    public Camera camera(CameraRoll cameraRoll) {
//        Camera camera = new CameraImpl();
//        camera.setCameraRoll(cameraRoll);
//        return camera;
//    }
}
