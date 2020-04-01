package com.bawei.dome0331;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEt;
    private Button mBt;
    private FlowView mSp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSp = findViewById(R.id.sf);
        mEt = findViewById(R.id.et);
        mBt = findViewById(R.id.bt);

        final FlowView mSimpleFlowView = new FlowView(this);
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mEt.getText().toString();
                Log.i("TAG", "onClick: "+s);
               mSp.addChildView(s);
            }
        });
    }
}
