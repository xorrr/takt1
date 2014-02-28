package bot;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

import bot.config.EnvironmentVars;

import com.google.inject.Inject;

public class BotConfig {
    private BotHandler listener;

    @Inject
    public BotConfig(BotHandler handler) {
        this.listener = handler;
    }

    public Configuration<PircBotX> createConfig() {
        Configuration<PircBotX> config = new Configuration.Builder<PircBotX>()
                .setName(System.getenv(EnvironmentVars.NAME))
                .setServerHostname(System.getenv(EnvironmentVars.SERVER))
                .addAutoJoinChannel(System.getenv(EnvironmentVars.CHANNEL))
                .addListener(listener).buildConfiguration();

        return config;
    }
}
