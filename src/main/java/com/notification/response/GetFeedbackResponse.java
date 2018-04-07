package com.notification.response;

import java.util.Map;

public class GetFeedbackResponse {

    Map<Integer,String> feedbackMap;

    public Map<Integer, String> getFeedbackMap() {
        return feedbackMap;
    }

    public void setFeedbackMap(Map<Integer, String> feedbackMap) {
        this.feedbackMap = feedbackMap;
    }
}
