package com.testng_ex.dataprovider;

/**
 * Created by gnavin on 2/25/17.
 */

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class MapDataProvider {

    @Test(dataProvider = "dbconfig")
    public void testConnection(Map<String, String> map) {

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("[Key] : " + entry.getKey()
                    + " [Value] : " + entry.getValue());
        }

    }

    @DataProvider(name = "dbconfig")
    public Object[][] provideDbConfig() {
        Map<String, String> map = readDbConfig();
        return new Object[][]{{map}};
    }

    public Map<String, String> readDbConfig() {

        Map<String, String> map = new HashMap<String, String>();

        map.put("jdbc.driver", "com.mysql.jdbc.Driver");
        map.put("jdbc.url", "jdbc:mysql://localhost:3306/mkyongserver");
        map.put("jdbc.username", "username");
        map.put("jdbc.password", "password");

        return map;

    }

}