package com.centaurstech.domain;

/**
 * All centaurs backend api result must implement this interface
 */
public interface ApiResult {

    Integer getRetcode();

    String getMessage();

    Integer getStatus();

    String getPayload();

}
