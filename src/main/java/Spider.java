import org.openqa.selenium.WebDriver;
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
        webDriver.get("https://diannao.jd.com/");
    }
}
