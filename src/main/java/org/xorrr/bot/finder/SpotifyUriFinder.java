package org.xorrr.bot.finder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpotifyUriFinder {

    private String urlPattern = "spotify:track:\\w{22}";

    public String findUri(String message) {
        Pattern p = Pattern.compile(urlPattern);
        Matcher m = p.matcher(message);

        return getMatch(m);
    }

    private String getMatch(Matcher m) {
        String uri = null;

        if (m.find()) {
            uri = m.group(0);
        }

        return uri;
    }

}
