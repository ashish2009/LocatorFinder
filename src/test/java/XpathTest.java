import com.quikr.locatorFinder.HtmlReader;
import com.quikr.locatorFinder.XMLReader;
import org.jsoup.nodes.Document;
import org.jsoup.select.Selector;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.HashMap;

public class XpathTest {

    XMLReader xmlReader;
    HashMap<String,String > locators;
    Document document;
    String url = "https://www.quikr.com/";
    String htmlFile = "/Users/ashishkumar/Documents/QuikrAutomation/LocatorFinder/src/main/resources/home.html";

    @BeforeMethod
    public void setup(){
        xmlReader = new XMLReader();
        locators = xmlReader.getDOMElements("HomePageElements.xml");
        HtmlReader htmlReader = new HtmlReader();
        document = htmlReader.read(url,htmlFile);
    }

    @Test
    public void verifyXpath(){
        SoftAssert softAssert = new SoftAssert();
        for (String s:locators.keySet()){
            try{
                document.select(locators.get(s));
            }catch (Selector.SelectorParseException e){
                softAssert.assertTrue(false,s+" locator not found on page");
            }

        }
        softAssert.assertAll();
    }
}
