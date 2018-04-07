package com.notification.Service.Impl;

import com.notification.Service.FeedbackService;
import com.notification.Service.SpamContentValidatorService;
import com.notification.request.FeedbackRequest;
import com.notification.response.GetFeedbackResponse;
import com.notification.response.SubmitFeedbackResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FeedbackServiceImpl implements FeedbackService {


    @Autowired
    private SpamContentValidatorService spamContentValidatorService;

    private static Map<String,Map<Integer,String>> feedbackMap = new HashMap<String,Map<Integer,String>>();

    @Override
    public SubmitFeedbackResponse submitFeedbackResponse(FeedbackRequest request) {

        SubmitFeedbackResponse feedbackResponse = new SubmitFeedbackResponse();

        if(!isValidRequest(request,feedbackResponse)){
            return feedbackResponse;
        }

        if(spamContentValidatorService.isSpamContent(request.getComment())){
            feedbackResponse.setMsg("Invalid content");
        }

        Map<Integer,String> userfeedBack = null;

        if(feedbackMap.get(request.getProductId()) !=null){
            userfeedBack = feedbackMap.get(request.getProductId());
        }else{
            userfeedBack =  new HashMap<Integer,String>();
        }
       // Map<Integer,String> userfeedBack = new HashMap<Integer,String>();
        userfeedBack.put(request.getUserId(),request.getComment());
        feedbackMap.put(request.getProductId(),userfeedBack);
        return feedbackResponse;
    }


    public GetFeedbackResponse getFeedback(String productId){

        GetFeedbackResponse resp= new GetFeedbackResponse();
        resp.setFeedbackMap(feedbackMap.get(productId));
        return resp;

    }

    Boolean isValidRequest(FeedbackRequest request, SubmitFeedbackResponse feedbackResponse){

        if(StringUtils.isBlank(request.getProductId())){
            feedbackResponse.setMsg("Invalid productId");
            return false;
        }else if(request.getUserId()==null){
            feedbackResponse.setMsg("Invalid UserId");
            return false;
        }

        return true;

    }

}
