package ru.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("camera")
@Scope("prototype")
public class CameraImpl implements Camera {

    @Value("false")
    private boolean broken;

    @Autowired
    @Qualifier("cameraRoll")
    private CameraRoll cameraRoll;

    @Override
    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    //@Autowired - заменяет два бина в классе AppConfig
    @Override
    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    @Override
    public void breaking() {
        this.broken = true;
    }

    @Override
    public boolean isBroken() {
        return broken;
    }

    @PostConstruct
    @Override
    public void ready() {
        System.out.println("Фотоаппарат готов к использованию!");
    }

    @Override
    public void doPhotograph() {
        if (isBroken()) {
            System.out.println("Фотоаппарат сломан!");
            return;
        }

        System.out.println("Сделана фотография!");
        cameraRoll.processing();
    }

}
