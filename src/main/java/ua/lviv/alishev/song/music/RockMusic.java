package ua.lviv.alishev.song.music;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.lviv.alishev.song.Music;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class RockMusic implements Music {

    @PostConstruct
    @Override
    public void init() {
        System.out.println(this.getClass().getName() + ": initialization...");
    }

    @PreDestroy
    @Override
    public void destroy() {
        System.out.println(this.getClass().getName() + ": destroying...");
    }

    @Override
    public String getSong() {
        return "Wind cries Marry";
    }

    @Override
    public String toString() {
        return "RockMusic";
    }
}
