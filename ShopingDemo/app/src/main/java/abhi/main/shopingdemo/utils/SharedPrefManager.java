package abhi.main.shopingdemo.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import abhi.main.shopingdemo.model.User;


public class SharedPrefManager {

    //the constants
    private static final String SHARED_PREF_NAME = "laundry";
    private static final String KEY_USERNAME = "keyusername";
    private static final String KEY_EMAIL = "keyemail";
    private static final String KEY_MOBILE = "keymobile";
    private static final String KEY_ID = "keyid";
    private static final String KEY_DOB = "keydob";
    private static final String KEY_ADDRESS = "keyaddress";
    private static final String KEY_ALTMOBILE = "keyaltmob";
    private static final String KEY_ALTADDRESS = "keyaltadd";
    private static final String KEY_EMPTYPE = "keyemptype";
    private static final String KEY_USERTYPE = "keyemptype";


    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //method to let the user login
    //this method will store the user data in shared preferences
    public void userLogin(User user) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ID, user.getId());
        editor.putString(KEY_USERNAME, user.getUserName());
        editor.putString(KEY_EMAIL, user.getUserEmail());
        editor.putString(KEY_MOBILE, user.getUserMob());
        editor.putString(KEY_USERTYPE, user.getUserType());
        editor.apply();
    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME, null) != null;
    }

    //this method will give the logged in user
    public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        User user = new User();
        user.setId(sharedPreferences.getString(KEY_ID, null));
        user.setUserName(sharedPreferences.getString(KEY_USERNAME, ""));
        user.setUserMob(sharedPreferences.getString(KEY_MOBILE, ""));
        user.setUserType(sharedPreferences.getString(KEY_USERTYPE, ""));
        user.setUserEmail(sharedPreferences.getString(KEY_EMAIL, ""));
         return user;

    }

    //this method will logout the user
//    public void logout() {
//        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.clear();
//        editor.apply();
//        mCtx.startActivity(new Intent(mCtx, MainActivity.class));
//    }


}
