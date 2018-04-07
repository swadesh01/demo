package com.notification.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


    public class Response extends ResponseEntity<ResponseWrapper> {


        public Response(ResponseWrapper body, HttpStatus status) {
            super(body, status);
        }

        public static Response buildSuccessResponse(Object payload) {
            ResponseWrapper responseWrapper = new ResponseWrapper();
            responseWrapper.setPayload(payload);
            responseWrapper.setStatus("Success");
            return new Response(responseWrapper, HttpStatus.OK);
        }


    }


