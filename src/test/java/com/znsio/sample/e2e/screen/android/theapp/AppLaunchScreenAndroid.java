package com.znsio.sample.e2e.screen.android.theapp;

import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import com.znsio.sample.e2e.screen.theapp.AppLaunchScreen;
import com.znsio.sample.e2e.screen.theapp.ClipboardDemoScreen;
import com.znsio.sample.e2e.screen.theapp.EchoScreen;
import com.znsio.sample.e2e.screen.theapp.LoginScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class AppLaunchScreenAndroid
        extends AppLaunchScreen {
    private static final String SCREEN_NAME = AppLaunchScreenAndroid.class.getSimpleName();
    private static final Logger LOGGER = Logger.getLogger(SCREEN_NAME);
    private final Driver driver;
    private final Visual visually;
    private final String byClipboardDemoAccessibilityId = "Clipboard Demo";
    private final String loginScreenAccessibilityId = "Login Screen";
    private static final By byGoBackToHomeScreenButtonXpath = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate Up\"]");
    private static final By byEchoMessageXpath = By.xpath("//android.view.ViewGroup[@content-desc=\"Echo Box\"]/android.view.ViewGroup");

    public AppLaunchScreenAndroid(Driver driver, Visual visually) {
        this.driver = driver;
        this.visually = visually;
    }

    @Override
    public LoginScreen selectLogin() {
        driver.findElementByAccessibilityId(loginScreenAccessibilityId)
              .click();
        return LoginScreen.get();
    }

    @Override
    public AppLaunchScreen goBack() {
        driver.waitForClickabilityOf(byGoBackToHomeScreenButtonXpath)
              .click();
        return this;
    }

    @Override
    public EchoScreen selectEcho() {
        driver.waitForClickabilityOf(byEchoMessageXpath)
              .click();
        return EchoScreen.get();
    }

    @Override
    public ClipboardDemoScreen goToClipboardDemo() {
        LOGGER.debug("Clicking on Clipboard Demo");
        visually.checkWindow(SCREEN_NAME, "On app launch screen");
        driver.findElementByAccessibilityId(byClipboardDemoAccessibilityId)
              .click();
        return ClipboardDemoScreen.get();
    }
}
