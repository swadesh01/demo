package com.notification.Service;

import com.notification.request.FeedbackRequest;
import com.notification.response.GetFeedbackResponse;
import com.notification.response.SubmitFeedbackResponse;

public interface FeedbackService {


    public SubmitFeedbackResponse submitFeedbackResponse(FeedbackRequest request);

    public GetFeedbackResponse getFeedback(String productId);
}
