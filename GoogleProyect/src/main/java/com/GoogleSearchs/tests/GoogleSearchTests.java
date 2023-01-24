package com.GoogleSearchs.tests;

import com.GoogleSearchs.base.BasePage;
import com.GoogleSearchs.base.BaseTest;
import com.GoogleSearchs.pages.GoogleHomePage;
import com.GoogleSearchs.pages.GoogleResultsPage;
import com.extentreports.ExtentFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class GoogleSearchTests extends BaseTest {
	static BasePage _basePage = new BasePage();
	static GoogleHomePage googleHomePage = new GoogleHomePage();
	static GoogleResultsPage googleResultsPage = new GoogleResultsPage();
	private static WebDriver driver;
	static  boolean condition;

	private String [] products =  {"Aerolineas Argentinas","Iphone 13", "Samsung A30", "Notebook Banghó", "Perfumes importados", "Lavarropas Whirpool","Mochilas escolares", "Repuestos Volkswagen Golf", "Sommier Queen Size" ,"Vino Catena Zapata", "Zapatillas Nike"};
	private String [] productss =  {"Aerolineas Argentinas", "Samsung A30", "Notebook Banghó", "Perfumes importados", "Lavarropas Whirpool","Mochilas escolares", "Repuestos Volkswagen Golf", "Sommier Queen Size" ,"Vino Catena Zapata", "Zapatillas Nike"};

	@BeforeAll
	static void setUp() {
		_basePage = new BasePage();
		driver = _basePage.getDriver();
		extent = ExtentFactory.getInstance();
		extent.attachReporter(spark);
	}

	@BeforeEach
	public void initialPage() {
		_basePage.openApp();
	}

	@Test
	@DisplayName("Page title refers to search")
	public void searchProductTitle() throws IOException {
		for ( String product :products) {
			googleHomePage.standarSearchItem(product);
			condition = driver.getTitle().contains(product);
			_basePage.checkCondition("PageTitle_"+product, condition);
			googleResultsPage.goToHomePage();

		}
	}

	@Test
	@DisplayName("Mercadolibre´s link present on 1st result page")
	public void meliLinkPresent() throws IOException {
		for (String product : products){
			googleHomePage.standarSearchItem(product);
			_basePage.checkCondition("MercadolibreLink_"+ product,googleResultsPage.searchMeliLink());
			googleResultsPage.goToHomePage();

		}
	}

	@Test
	@DisplayName("Result Page has a rating stars")
	public void hasStarRatings() throws IOException {
		for (String product: products){
			googleHomePage.standarSearchItem(product);
			condition = googleResultsPage.hasRatings();
			_basePage.checkCondition("Has_Star_Ratings_"+product,condition);
			googleResultsPage.goToHomePage();
		}
	}

	@Test
	@DisplayName("Results quantity")
	public void quantity() throws IOException {
		for (String product: productss){
			googleHomePage.standarSearchItem(product);
			condition = googleResultsPage.moreResults();
			_basePage.checkCondition("Has_more_than_5M_results_"+product,condition);
			googleResultsPage.goToHomePage();
		}
	}


	@AfterAll
	public static void finishTest() { driver.quit();}

}
	
