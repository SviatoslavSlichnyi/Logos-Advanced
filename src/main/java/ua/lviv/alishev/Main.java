package ua.lviv.alishev;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.lviv.alishev.player.MusicPlayer;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //Without DI
//        Music music = context.getBean("musicBean", ClassicalMusic.class);
//        MusicPlayer musicPlayer = new MusicPlayer(music);

        //DI
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        musicPlayer.playMusic();
        System.out.println("Playing on: " + musicPlayer.getName());
        System.out.println("Volume: " + musicPlayer.getVolume());

        context.close();
    }
}
