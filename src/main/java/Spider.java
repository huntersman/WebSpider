import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        choseElement(webDriver, "学历要求：", "硕士");
        choseElement(webDriver, "行业领域：", "移动互联网");
    }
    //通过Xpath选中元素
    private static void choseElement(WebDriver webDriver, String title, String chose) {
        WebElement titleElement = webDriver.findElement(By.xpath("//li[@class='multi-chosen']//span[contains(text(),'" + title + "')]"));
        WebElement choseElement = titleElement.findElement(By.xpath("//a[contains(text(),'" + chose + "')]"));
        choseElement.click();
    }
}
