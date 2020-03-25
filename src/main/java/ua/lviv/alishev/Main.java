package ua.lviv.alishev;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.lviv.alishev.player.MusicPlayer;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        musicPlayer.playMusic();
        System.out.println(musicPlayer);

        context.close();
    }
}
