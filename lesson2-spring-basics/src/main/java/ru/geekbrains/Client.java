package ru.geekbrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.geekbrains.config.AppConfig;

public class Client {
    public static void main(String[] args) {
        /*CameraImpl cameraImpl = new CameraImpl();
        CameraRoll cameraRoll = new ColorCameraRoll();
        cameraImpl.setCameraRoll(cameraRoll);
        cameraImpl.doPhotograph();
        - вариант без Spring context*/

       /* все действия с камерой можно отдать на откуп ассистенту (создание пленки, создание камеры, зарядка пленки.),
       то есть произошла инверсия управления, эти задачи и берет на себя Spring Context
        Assistant assistant = new Assistant();
        Camera camera = assistant.getCamera();
        camera.doPhotograph();*/

        //ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Camera camera = context.getBean("camera", Camera.class);
        camera.breaking();
        camera.doPhotograph();
        camera = context.getBean("camera", Camera.class);
        camera.doPhotograph();

        /*Стоит ли применять конфигурацию с помощью аннотаций совместно с JavaConfig? Однозначно стоит.
Оптимальный способ — условие, согласно которому все бины, необходимые для инфраструктуры
приложения (источники данных, менеджеры транзакций), объявляются непосредственно в классе
JavaConfig путем создания метода и применения к нему аннотации @Bean. А ко всем классам,
реализующим написанную нами бизнес-логику (либо к классам, предназначенным для хранения
какой-либо информации), применяются специальные аннотации (@Component, @Service,
@Repository и т. п.) */
    }
}
