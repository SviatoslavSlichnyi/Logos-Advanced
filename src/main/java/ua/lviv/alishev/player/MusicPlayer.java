package ua.lviv.alishev.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.lviv.alishev.song.Music;

import java.util.StringJoiner;

@Component
@Scope("prototype")
public class MusicPlayer {

    private final Music music;
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private String volume;

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MusicPlayer.class.getSimpleName() + "[", "]")
                .add("music=" + music)
                .add("name='" + name + "'")
                .add("volume='" + volume + "'")
                .toString();
    }
}
