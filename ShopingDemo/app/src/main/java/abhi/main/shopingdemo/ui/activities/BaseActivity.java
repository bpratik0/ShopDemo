package abhi.main.shopingdemo.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import abhi.main.shopingdemo.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }


       public  void setTitle(String title)
    {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar_layout);
        getSupportActionBar().setElevation(0);
        View view =getSupportActionBar().getCustomView();
        Button imageButton= (Button)view.findViewById(R.id.btn_back);
        TextView tvTitle= (TextView)view.findViewById(R.id.tvtitle);
        tvTitle.setText(title);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                            onBackPressed();
                        }

                });
            }




}
