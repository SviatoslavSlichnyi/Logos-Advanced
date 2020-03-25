package ua.lviv.alishev;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.lviv.alishev.config.SpringConfig;
import ua.lviv.alishev.player.MusicPlayer;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        musicPlayer.playMusic();
        System.out.println(musicPlayer);

        context.close();
    }
}
