package com.centaurstech.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryHelperTest {


    @Test
    public void testEncodeURL() {
        HashMap<String, String> query = new HashMap<>();
        query.put("a", "1");
        query.put("b", "2");
        query.put("c", "3");

        //将HashMap通过utf8转码为url传参方式
        String queryString = QueryHelper.urlEncodeUTF8(query);
        System.out.println(queryString);
        assertThat(queryString, is("a=1&b=2&c=3"));

        //将url传参字符串通过utf8解码为HashMap
        Map<String, String> decodedQuery =  QueryHelper.urlDecodeUTF8Map(queryString);
        System.out.println(decodedQuery);
        assertThat(decodedQuery.size(), is(3));

        //验证未写全的传参字符串
        decodedQuery =  QueryHelper.urlDecodeUTF8Map("a=1&b=2&c=3&d=&e");
        System.out.println(decodedQuery);
        assertThat(decodedQuery.size(), is(5));
    }

}
