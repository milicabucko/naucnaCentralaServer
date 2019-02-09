package com.sep.naucnacentrala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class NaucnacentralaApplication {
	
	static {
	    //for localhost testing only
	    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
	    new javax.net.ssl.HostnameVerifier(){
 
	        public boolean verify(String hostname,
	                javax.net.ssl.SSLSession sslSession) {
	            if (hostname.equals("localhost") || hostname.equals("sandbox.paypal")) {
	                return true;
	            }
	            return true;
	        }
	    });
	}

	public static void main(String[] args) {
		SpringApplication.run(NaucnacentralaApplication.class, args);
	}
}
