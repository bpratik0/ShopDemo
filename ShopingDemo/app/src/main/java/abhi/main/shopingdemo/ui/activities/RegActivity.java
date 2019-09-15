package abhi.main.shopingdemo.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import abhi.main.shopingdemo.R;
import abhi.main.shopingdemo.constants.AppConstants;
import abhi.main.shopingdemo.model.User;
import abhi.main.shopingdemo.utils.SharedPrefManager;
import abhi.main.shopingdemo.utils.VolleySingleton;
import androidx.appcompat.app.AppCompatActivity;

public class RegActivity extends BaseActivity implements View.OnClickListener {
    User user;
    Spinner spUserType;
    EditText etUserName,etMob,etEmail,etPass;
    Button  btn_signUP;
    String users[]={"Buyer","Seller"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_layout);
        setTitle("Sign Up");
        init();



    }

    public void init() {
        user =    User.getUserRegDataHolder();
        etUserName = findViewById(R.id.username);
        etEmail = findViewById(R.id.useremail);
        etMob = findViewById(R.id.userMob);
        etPass = findViewById(R.id.etpassword);
        spUserType = findViewById(R.id.spUserType);
        btn_signUP = findViewById(R.id.btn_signUP);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,users);
        spUserType.setAdapter(arrayAdapter);
        btn_signUP.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String userName  = etUserName.getText().toString().trim();
        String userEmail  = etEmail.getText().toString().trim();
        String userMob  = etMob.getText().toString().trim();
        String userPass  = etPass.getText().toString().trim();
        String userType  = spUserType.getSelectedItem().toString().trim();
        user.setUserName(userName);
        user.setUserEmail(userEmail);
        user.setUserMob(userMob);
        user.setUserPassword(userPass);
        user.setUserType(userType);
        upload(user);
    }


    public  void upload(final User user)
    {
        StringRequest postRequest = new StringRequest(Request.Method.POST, AppConstants.URL_REGISTER,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response", response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.getString("error").equals("false")) {
                                Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                JSONObject userJson = jsonObject.getJSONObject("user");
                                User user =  User.getUserRegDataHolder();
                                user.setId(userJson.getString("id"));
                                user.setUserName(userJson.getString("userName"));
                                user.setUserType(userJson.getString("userType"));
                                user.setUserMob(userJson.getString("mob"));
                                user.setUserEmail( userJson.getString("email"));
                                SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);
                                finish();
                                startActivity(new Intent(getApplicationContext(), SellerDashBoard.class));
                            } else {

                                Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.toString());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> jsonObject = new HashMap<String, String>();
                jsonObject.put("userType",user.getUserType());
                jsonObject.put("userName",user.getUserName());
                jsonObject.put("mob",user.getUserMob());
                jsonObject.put("email",user.getUserEmail());
                jsonObject.put("password",user.getUserPassword());
                return jsonObject;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(postRequest);
    }
}


