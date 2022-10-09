package skillcheck.level3;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
* 방금 그 곡
*
* 구현 문제인데 지저분하다.
*
* 풀이가 맞는데 늘 확신이 부족하다. (많이 풀자)
*
* import문 잘 쓰자. (java는 deep import가 없다. 패키지 독립적)
* JodaTime 패키지랑 친해지자.
*
* */

public class RecentSong {

    public String solution(String m, String[] musicinfos) {
        List<Music> musics = new ArrayList<>();

        for(String musicInfo : musicinfos) {
            String[] split = musicInfo.split(",");

            DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");

            LocalTime start = LocalTime.parse(split[0], format);
            LocalTime end = LocalTime.parse(split[1], format);

            Duration duration = Duration.between(start, end);
            int durationMinutes = (int) duration.getSeconds() / 60;

            StringBuilder melody = new StringBuilder();
            if(durationMinutes > split[3].length()) {
                melody.append(split[3]);
                melody.append(split[3]);
            } else {
                melody.append(split[3], 0, split[3].length() % durationMinutes);
            }
            musics.add(new Music(split[2], melody.toString(), durationMinutes));
        }

        int length = 0;
        String answer = "(None)";
        for(Music music : musics) {
            if(music.getMelody().contains(m)) {
                if(length < music.duration) {
                    length = music.duration;
                    answer = music.subject;
                }
            };
        }

        return answer;
    }

    class Music {
        private String subject;
        private String melody;
        private int duration;

        public Music(String subject, String melody, int duration) {
            this.subject = subject;
            this.melody = melody;
            this.duration = duration;
        }

        public String getSubject() {
            return subject;
        }

        public String getMelody() {
            return melody;
        }

        public int getDuration() {
            return duration;
        }
    }

}
