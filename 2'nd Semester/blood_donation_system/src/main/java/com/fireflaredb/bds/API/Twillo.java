package com.fireflaredb.bds.API;

import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;


public class Twillo {
    public static final String ACCOUNT_SID = "";
    public static final String AUTH_TOKEN = "";

    public static String sendOTP(String phone) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Verification verification = Verification.creator(
                        "",
                        "+91" + phone,
                        "sms")
                .create();
        System.out.println("OTP Sent");
        return verification.getStatus();
    }

    public static boolean verifyOTP(String revOTP, String phone) {
        boolean flag = false;
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        VerificationCheck verificationCheck = VerificationCheck.creator(
                        "",
                        revOTP)
                .setTo("+91" + phone).create();
        if (verificationCheck.getStatus() == "approved") {
            flag = true;
        }
        System.out.println("OTP Received Passed: " + flag);
        return flag;
    }
}

