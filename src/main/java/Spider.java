import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by Hunter on 7/20/2019
 * 注意保持ChromeDriver版本和Chrome版本一致，否则会报错
 */
public class Spider {
    public static void main(String[] args) {
        //设置WebDriver路径
        String path="src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);

        //创建WebDriver
        WebDriver  webDriver=new ChromeDriver();

        //打开浏览器地址
        webDriver.get("https://www.lagou.com/jobs/list_Java?isSchoolJob=1#/");

        //选择
        choseElement(webDriver, "工作性质：", "应届");
        choseElement(webDriver, "学历要求：", "不限");
        choseElement(webDriver, "行业领域：", "移动互联网");

        //解析页面元素
        extract(webDriver);
    }
    //解析页面元素
    private static void extract(WebDriver webDriver) {
        List<WebElement> positions = webDriver.findElements(By.className("con_list_item"));
        for (WebElement webElement:positions) {
            WebElement money = webElement.findElement(By.className("position")).findElement(By.className("money"));
            WebElement company = webElement.findElement(By.className("company_name"));
            System.out.println(company.getText()+":"+money.getText());
        }
        WebElement pager_next = webDriver.findElement(By.className("pager_next"));
        if(!pager_next.getAttribute("class").contains("pager_next_disabled")){
            pager_next.click();
            System.out.println("------解析下一页-------");
            //线程延迟避免未来得及打印导致的报错
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            extract(webDriver);
        }
    }

    //通过Xpath选中元素
    private static void choseElement(WebDriver webDriver, String title, String chose) {
        WebElement titleElement = webDriver.findElement(By.xpath("//li[@class='multi-chosen']//span[contains(text(),'" + title + "')]"));
        WebElement choseElement = titleElement.findElement(By.xpath("..//a[contains(text(),'" + chose + "')]"));
        choseElement.click();
    }
}
