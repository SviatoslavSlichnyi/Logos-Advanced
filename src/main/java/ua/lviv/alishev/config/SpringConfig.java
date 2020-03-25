package ua.lviv.alishev.config;

import org.springframework.context.annotation.*;
import ua.lviv.alishev.player.MusicPlayer;
import ua.lviv.alishev.song.Music;
import ua.lviv.alishev.song.music.ClassicalMusic;
import ua.lviv.alishev.song.music.RockMusic;

@Configuration
@ComponentScan("ua.lviv.alishev")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean
    @Scope("prototype")
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(rockMusic());
    }

}
