package automation.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {

    @DataProvider
    public Object[][] getData(){

        Object[][] employeeCredentials = {
                {"gino.wintheiser","%B6B*q1!TH"},
                {"dallas.batz","dOWjuXz8*es6"},
                {"leonel.skiles","x3uvY0f8hw1T"}
        };
        return employeeCredentials;
    }

    @Test(dataProvider = "getData")
    public void employeeLogin(String username, String password){

        System.out.println(username+" "+password);
    }
}
