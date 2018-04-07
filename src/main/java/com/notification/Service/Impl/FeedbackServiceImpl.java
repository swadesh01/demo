package com.notification.Service.Impl;

import com.notification.Service.FeedbackService;
import com.notification.Service.SpamContentValidatorService;
import com.notification.request.FeedbackRequest;
import com.notification.response.GetFeedbackResponse;
import com.notification.response.SubmitFeedbackResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FeedbackServiceImpl implements FeedbackService {


    @Autowired
    private SpamContentValidatorService spamContentValidatorService;

    private static Map<String,Map<Integer,String>> feedbackMap = new HashMap<String,Map<Integer,String>>();

    @Override
    public SubmitFeedbackResponse submitFeedbackResponse(FeedbackRequest request) {

        SubmitFeedbackResponse feedbackResponse = new SubmitFeedbackResponse();

        if(spamContentValidatorService.isSpamContent(request.getComment())){
            feedbackResponse.setMsg("Invalid content");
        }
        Map<Integer,String> userfeedBack = new HashMap<Integer,String>();
        userfeedBack.put(request.getUserId(),request.getComment());
        feedbackMap.put(request.getProductId(),userfeedBack);
        return feedbackResponse;
    }


    public GetFeedbackResponse getFeedback(String productId){

        GetFeedbackResponse resp= new GetFeedbackResponse();
        resp.setFeedbackMap(feedbackMap);
        return resp;

    }


}
