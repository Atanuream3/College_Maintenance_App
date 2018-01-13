package com.example.asmita.loginactivity;

/**
 * Created by asmita on 17/4/17.
 */

public class Config {

    public static final String LOGIN_URL="http://asmitaatanure.000webhostapp.com/check.php";

    public static final String INSERT_URL="http://asmitaatanure.000webhostapp.com/insert.php";

    public static final String ADMIN_URL="http://asmitaatanure.000webhostapp.com/admin.php";

    public static final String Upload_Url="http://asmitaatanure.000webhostapp.com/upload.php";

    public static final String gettimage="http://asmitaatanure.000webhostapp.com/getImage.php";

    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_USER ="username";
    public static final String KEY_PASSWORD ="password";
    public static final String KEY_ADMIN="Admin_Id";

    public static final String KEY_PASS="Password";
    // public static final String KEY_Email ="email";
    public static final String KEY_MOBNO ="mobno";

    public static final String KEY_IMAGE="image";
    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS ="Success";

    public static final String INSERT_SUCCESS ="inserted";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "myloginapp";

    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "username";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";

}
