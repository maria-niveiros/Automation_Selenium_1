package com.GoogleSearchs.pages;

import com.GoogleSearchs.base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class GoogleResultsPage extends BasePage {

    static GoogleHomePage googleHomePage = new GoogleHomePage();
    static BasePage basePage = new BasePage();
    String googleSmallLogo = "/html/body/div[4]/div[2]/form/div[1]/div[1]/div[1]/a/img";
    static String resultStatus= "/html/body/div[8]/div/div[7]/div[1]/div/div/div/div/text()";
    static String resultTime= "/html/body/div[8]/div/div[7]/div[1]/div/div/div/div/nobr";

    static String searchSideBoxTitle ="/html/body/div[8]/div/div[11]/div[2]/div/div/div[2]/div/div[1]/div/div/div/div[2]/h2";
    static String ratingProduct= "/html/body/div[8]/div/div[11]/div[2]/div/div/div[2]/div/div[1]/div/div/div/div[2]/div/span/span/span[1]";


    public void goToHomePage(){
        Wait wait1 = new WebDriverWait(_driver, Duration.ofSeconds(3));

        basePage.clickElement(googleSmallLogo);}

    public Boolean searchMeliLink(){
        try {
            WebElement meli = getDriver().findElement(By.partialLinkText("mercadolibre"));
            basePage.getJs().executeScript("arguments[0].scrollIntoView();", meli);
            return meli.isDisplayed();
        } catch (Exception e){
            return false;
        }

    }

    public Boolean hasRatings(){
        try {
            WebElement stars = getDriver().findElement(By.xpath("/html/body/div[7]/div/div[11]/div[2]/div/div/div[2]/div/div[1]/div/div/div/div[2]/div/span/span/span[1]/span"));
            return stars.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public Boolean moreResults() {
        Boolean result;
            WebElement results = _driver.findElement(By.xpath("/html/body/div[7]/div/div[7]/div[1]/div/div/div/div"));
            String text = results.getText();
            String[] parts = text.split(" ");
            String[] parts1 = parts[2].split(",");
             String total = "";
            for (int i=0; i< parts1.length; i++ ){

             total = total + parts1[i];}
            Integer resultadosNum = Integer.parseInt(total);
            if (resultadosNum > 5000000) {
               result = true;
            }else{
                result=false;
            }

            return result;
    }


}


