package com.centaurstech.domain;

import java.util.Calendar;
import java.util.Map;

/**
 * Created by Feliciano on 7/5/2017.
 */
public abstract class EngineQuery {

    /**
     * Session chat key
     */
    String chatKey;

    /**
     * Query start time
     */
    long beginTime;

    /**
     * Query process duration
     */
    long processTime;

    EngineQuery() {
        beginTime = Calendar.getInstance().getTimeInMillis();
    }

    EngineQuery(Map<String,String> requestParams) {
        this();
        chatKey = requestParams.get("chat_key");
        if (chatKey.contains("@@@")) {
            chatKey = chatKey.substring(0, chatKey.indexOf("@@@"));
        }
    }

    public String getChatKey() {
        return chatKey;
    }

    public void setChatKey(String chatKey) {
        this.chatKey = chatKey;
    }

    public long getQueryTime() {
        return processTime = Calendar.getInstance().getTimeInMillis() - beginTime;
    }

    public String getQueryTimeString() {
        return "Query takes " + getQueryTime() + "ms";
    }
}