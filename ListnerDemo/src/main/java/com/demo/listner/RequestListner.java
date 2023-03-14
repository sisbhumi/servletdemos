package com.demo.listner;

import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;

@WebListener 
public class RequestListner  {

    public RequestListner() {
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
         System.out.println("Request destroyed...");
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
         System.out.println("Request initialized...");
    }
	
}
