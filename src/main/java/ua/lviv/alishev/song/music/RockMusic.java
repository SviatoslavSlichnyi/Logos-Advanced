package ua.lviv.alishev.song.music;

import ua.lviv.alishev.song.Music;

public class RockMusic implements Music {

    @Override
    public void init() {
        System.out.println(this.getClass().getName() + ": initialization...");
    }

    @Override
    public void destroy() {
        System.out.println(this.getClass().getName() + ": destroying...");
    }

    @Override
    public String getSong() {
        return "Wind cries Marry";
    }
}
