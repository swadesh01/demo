package com.notification.Service.Impl;

import com.notification.Service.SpamContentValidatorService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SpamContentValidatorServiceImpl implements SpamContentValidatorService{

    @Override
    public Boolean isSpamContent(String content) {
        Boolean status = false;

        Pattern p = Pattern.compile("fuck|xxx|porn|sexy");

        if(matchesPattern(p,content)!=null){
            status=true;
        }
        return status;
    }

    private static String matchesPattern(Pattern p, String sentence) {
        Matcher m = p.matcher(sentence);

        if (m.find()) {
            return m.group();
        }

        return null;
    }
}
