package com.notification.controller;

import com.notification.Service.FeedbackService;
import com.notification.request.FeedbackRequest;
import com.notification.response.GetFeedbackResponse;
import com.notification.response.SubmitFeedbackResponse;
import com.notification.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeedbackController {


    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping(value = "/submitFeedback", method = RequestMethod.POST)
    public Response submitFeedbackReport(@RequestBody FeedbackRequest request) {


        SubmitFeedbackResponse obj = feedbackService.submitFeedbackResponse(request);

        return Response.buildSuccessResponse(obj);
    }


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Response getFeedback(@RequestParam("id") String productId) {


        GetFeedbackResponse obj = feedbackService.getFeedback(productId);

        return Response.buildSuccessResponse(obj);
    }
}
