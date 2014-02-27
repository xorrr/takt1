package bot;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import com.google.inject.Inject;

public class BotHandler extends ListenerAdapter<PircBotX> {

    private TitleGrabber tg;
    private UrlGrabber ug;

    @Inject
    public BotHandler(TitleGrabber tg, UrlGrabber ug) {
        this.tg = tg;
        this.ug = ug;
    }

    @Override
    public void onGenericMessage(final GenericMessageEvent<PircBotX> event)
            throws Exception {
        String url = ug.grabUrl(event.getMessage());

        if (isNotNull(url)) {
            String title = tg.grabTitle(url);
            checkIfRespondWithTitle(event, title);
        }
    }

    private void checkIfRespondWithTitle(final GenericMessageEvent<PircBotX> event,
            String title) {
        if (isNotNull(title))
            event.respond(title);
    }

    private boolean isNotNull(String title) {
        return title != null;
    }
}
