package pages;

import enums.WaitStrategy;
import utils.DynamicXpathUtils;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

public final class linksPO extends BasePO {

    public linksPO() {
    }

    private final String APP_LINKS = "www.ebay.com";
    @SneakyThrows
    public <T> T navigateToApp(Appenum apps, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        String xpath = DynamicXpathUtils.getXpath(APP_LINKS, apps.getAppName());
        click(By.xpath(xpath), WaitStrategy.VISIBILITY, apps.getAppName());
        performImplicitWait();
        return clazz.newInstance();
    }
}

