package org.xorrr.bot.finder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SpotifyUriFinderTest {

  private static final String URI_TRACK = "spotify:track:47vFyxAv24QxAOfdMuE3oV";
  private static final String MESSAGE = "hey check " + URI_TRACK + " this out!";

  private SpotifyUriFinder finder;

  @Before
  public void initialize() {
    finder = new SpotifyUriFinder();
  }

  @Test
  public void canCheckIfUriExtractable() {
    assertTrue(finder.isUriExtractableIn(MESSAGE));
  }

  @Test
  public void cantFindUriInAnEmptyMessage() {
    assertFalse(finder.isUriExtractableIn(""));
  }

  @Test
  public void canFindUri() {
    String spotifyUri = finder.findUri(MESSAGE);

    assertEquals(URI_TRACK, spotifyUri);
  }

  @Test
  public void wontFindMatchInMessageWithoutMatches() {
    String found = finder.findUri("asfdasdf");

    assertNull(found);
  }
}
