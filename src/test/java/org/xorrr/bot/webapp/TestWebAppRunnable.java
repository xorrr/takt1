package org.xorrr.bot.webapp;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestWebAppRunnable {

    @Mock
    WebApp app;

    @Test
    public void test() {
        WebAppRunnable thread = new WebAppRunnable(app);

        thread.run();

        verify(app, times(1)).launchServer();
    }

}
