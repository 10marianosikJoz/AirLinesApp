package com.example.airlines.email;

import javax.servlet.http.HttpServletRequest;

public class UtilityPath {

    public static String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(),"");
    }
}
