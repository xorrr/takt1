package org.xorrr.bot.boundaries.impl;

import com.google.inject.Inject;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import org.xorrr.bot.HandleChannelMessage;
import org.xorrr.bot.IrcMessage;
import org.xorrr.bot.boundaries.impl.PircBotXIrcChannel;

public class PircBotXMessageListener extends ListenerAdapter<PircBotX> {

  private HandleChannelMessage handleChannelMessage;

  @Inject
  public PircBotXMessageListener(HandleChannelMessage handleChannelMessage) {
    this.handleChannelMessage = handleChannelMessage;
  }

  @Override
  public void onMessage(MessageEvent<PircBotX> messageEvent) throws Exception {
    handleChannelMessage.handle(new PircBotXIrcChannel(messageEvent.getChannel()),
            new IrcMessage(messageEvent.getMessage()));
  }
}