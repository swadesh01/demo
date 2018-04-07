package com.notification.response;

import java.util.Map;

public class GetFeedbackResponse {

    Map<String,Map<Integer,String>> feedbackMap;

    public Map<String, Map<Integer, String>> getFeedbackMap() {
        return feedbackMap;
    }

    public void setFeedbackMap(Map<String, Map<Integer, String>> feedbackMap) {
        this.feedbackMap = feedbackMap;
    }
}
