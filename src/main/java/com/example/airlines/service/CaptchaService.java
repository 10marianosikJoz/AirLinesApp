package com.example.airlines.service;

import com.example.airlines.beans.rest_template.RestTemplateBean;
import com.example.airlines.recaptcha.ReCaptchaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class CaptchaService {

    @Autowired
    private RestTemplateBean restTemplateBean;

    @Value("${recaptcha.secret}")
    private String recaptchaSecretKey;
    @Value("${recaptcha.url}")
    private String recaptchaServerUrl;

    public boolean verifyReCaptcha(String recaptchaResponse) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("secret", recaptchaSecretKey);
        map.add("response", recaptchaResponse);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ReCaptchaResponse response = restTemplateBean.getRestTemplate(new RestTemplateBuilder())
                .postForObject(recaptchaServerUrl, request, ReCaptchaResponse.class);

        return response.isSuccess();
    }
}
