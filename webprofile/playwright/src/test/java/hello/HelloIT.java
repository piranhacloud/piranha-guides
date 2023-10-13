package hello;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class HelloIT {
    
    @Test
    public void testHelloPlaywrightXhtml() throws Exception {
        try (Playwright playwright = Playwright.create()) {
            BrowserType chromium = playwright.chromium();
            try (Browser browser = chromium.launch()) {
                Page page = browser.newPage();
                page.navigate("http://localhost:8080/playwright/helloplaywright.xhtml");
                assertTrue(page.content().contains("Hello Playwright!"));
            }
        }
    }
}
