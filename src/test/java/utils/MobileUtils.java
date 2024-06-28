package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MobileUtils {

    private AppiumDriver<WebElement> driver;

    public MobileUtils(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }

    public void swipe(int startX, int startY, int endX, int endY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    public void pinchAndZoom(WebElement element, double scaleFactor) {
        int centerX = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int centerY = element.getLocation().getY() + element.getSize().getHeight() / 2;

        int anchorX = centerX;
        int anchorY = centerY;

        TouchAction action0 = new TouchAction(driver)
                .press(PointOption.point(anchorX, anchorY))
                .moveTo(PointOption.point(anchorX, anchorY - 100))
                .release();

        TouchAction action1 = new TouchAction(driver)
                .press(PointOption.point(anchorX, anchorY))
                .moveTo(PointOption.point(anchorX, anchorY + 100))
                .release();

        MultiTouchAction multiTouch = new MultiTouchAction(driver);
        multiTouch.add(action0).add(action1).perform();
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(source.getLocation().getX(), source.getLocation().getY()))
                .moveTo(PointOption.point(target.getLocation().getX(), target.getLocation().getY()))
                .release()
                .perform();
    }

    public void testBiometricAuthentication() {
        WebElement biometricButton = driver.findElement(By.id("biometricButtonId"));
        biometricButton.click();
    }
}
