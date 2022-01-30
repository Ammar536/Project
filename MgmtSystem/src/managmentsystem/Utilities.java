/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managmentsystem;

/**
 *
 * @author DELL
 */
public class Utilities {
    public static final String FIRST_NAME="firstname";
    public static final String LAST_NAME="lastname";
    public static final String PHONE="phone";
    public static final String CNIC="cnic";
    public static final String EMAIL="email";
    public static final String DESIGNATION="designation";
    
    public static boolean validEmail(String email){
        if(email.contains("@") && email.endsWith(".com")){
            return true;
        }
        return false;
    }
    
    public static boolean validPhone(String phone){
        if(phone.length()==11 && phone.startsWith("03")){
            return true;
        }
        return false;
    }
    
    public static boolean validCnic(String cnic){
        if(cnic.length()==13){
            return true;
        }
        return false;
    }
    
    public static boolean isInteger(String str){
        if(str.matches("-?\\d+")){
            return true;
        }
        return false;
    }
    
}
