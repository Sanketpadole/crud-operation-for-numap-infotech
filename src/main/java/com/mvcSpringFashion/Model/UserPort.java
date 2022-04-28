package com.mvcSpringFashion.Model;



public class UserPort {

	
	private static boolean userAvailable = false;
    private static Customer user;
	
    public static boolean isUserAvailable() {
		return userAvailable;
	}
   
    public static void setUser(Customer order) {
        UserPort.user = order;
        userAvailable = true;
    }

    public static Customer getUser() {
        userAvailable = false;
        return user;
    }
    
    
	
	
    
    
    
}
