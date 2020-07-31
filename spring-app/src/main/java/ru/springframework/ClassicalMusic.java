package ru.springframework;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
//prototype predestroy не вызывает

//@Component
//@Scope("prototype")
public class ClassicalMusic implements Music {
    public ClassicalMusic() {
    }

    //при scope Singleton фабричный метод вызывается только один раз
    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();
    }
    @PostConstruct
    public void doMyInit() {
        System.out.println("Initialization");
    }
    @PreDestroy
    public void doMyDestroy() {
        System.out.println("Destruction");
    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
