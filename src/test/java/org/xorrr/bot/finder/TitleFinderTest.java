package org.xorrr.bot.finder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.xorrr.bot.helpers.IntegrationTest;

@Category(IntegrationTest.class)
public class TitleFinderTest {

    private final String TITLE = "Regular expression - Wikipedia, the "
            + "free encyclopedia";
    private final String URL = "http://en.wikipedia.org/wiki/Regex";
    private String NON_EXISTING_URL = "http://www.test.test";
    private String IMAGE_URL = "http://upload.wikimedia.org/wikipedia/commons"
            + "/thumb/8/8e/Thompson-kleene-star.svg/503px-Thompson-kleene-"
            + "star.svg.png";

    private TitleFinder finder;

    @Before
    public void setUp() {
        finder = new TitleFinder();
    }

    @Test
    public void can_find_html_title() {
        String grabbedTitle = finder.findTitle(URL);

        assertThat(TITLE, equalTo(grabbedTitle));
    }

    @Test
    public void image_url_does_not_have_html_title() {
        String title = finder.findTitle(IMAGE_URL);

        assertNull(title);
    }

    @Test
    public void testGrabbingTheTitleOfANonExistingUrl() {
        String title = finder.findTitle(NON_EXISTING_URL);

        assertNull(title);
    }
}