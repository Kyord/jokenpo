package com.android.phantom.jokenpo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class JokenpoScreen1 extends AppCompatActivity {
    private Button btn_jkp_play;
    private EditText et_jkp_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokenpo_screen1);

        et_jkp_name = (EditText) findViewById(R.id.et_jkp_name);

        btn_jkp_play = (Button) findViewById(R.id.btn_jkp_play);
        btn_jkp_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JokenpoScreen1.this, JokenpoScreen2.class);
                i.putExtra(JokenpoScreen2.EXTRA_MESSAGE, et_jkp_name.getText().toString());
                startActivity(i);
            }
        });
    }
}
