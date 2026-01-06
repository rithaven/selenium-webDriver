package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WysiwygEditorPage {

    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.cssSelector("button[aria-label='Decrease indent']");

    public WysiwygEditorPage(WebDriver driver){
        this.driver = driver;
    }

    public void clearTextArea(){
        switchToEditArea();
        WebElement editor = driver.findElement(textArea);
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", editor);
        switchToMainArea();
    }

    public void setTextArea(String text){
        switchToEditArea();
        WebElement editor = driver.findElement(textArea);
        String currentText = editor.getText();
        String newText = currentText + text;
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = arguments[1];", editor, newText);
        switchToMainArea();
    }

    public String getTextFromEditor(){
        switchToEditArea();
        WebElement editor = driver.findElement(textArea);
        String text = editor.getText();
        switchToMainArea();
        return text;
    }

    public void decreaseIndention(){
        driver.findElement(decreaseIndentButton).click();
    }

    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }

    private void switchToMainArea(){
        driver.switchTo().defaultContent();
    }
}
