package com.test.etsy.test;

import com.test.etsy.EtsyTestBase;
import com.test.etsy.pages.MainPageEtsy;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSearch extends EtsyTestBase {
    @Parameters("Search")
    @Test
    public void EtsySearchTest(String search){
        MainPageEtsy mainPageEtsy=new MainPageEtsy(driver);
        mainPageEtsy.searchforiphone(search);


    }
}
