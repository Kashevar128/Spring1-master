package ru.titov.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SecondBean {

    private FirstBean firstBean;

    @Autowired
    public SecondBean(FirstBean firstBean) {
        this.firstBean = firstBean;
    }
}
