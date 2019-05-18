package com.abinash.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_exactMatch() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,true);
    }

    @Test
    public void jsonAssert_strictFalse() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,false);
    }

    @Test
    public void jsonAssert_withoutEscapechar() throws JSONException {
        String expectedResponse = "{id: 1,name: Ball, price: 10}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,false);
    }
}
