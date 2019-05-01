package com.example.mishvaaaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText t1,t2,t3;
    TextView ans1,ans2;
    String st;
    double aa,b,c,x;
    boolean bo=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=(EditText) findViewById(R.id.t1);
        t2=(EditText) findViewById(R.id.t2);
        t3=(EditText) findViewById(R.id.t3);
        ans1=(TextView) findViewById(R.id.ans1);
        ans2=(TextView) findViewById(R.id.ans2);

        Intent gi=getIntent();
        ans1.setText("last answers: "+gi.getStringExtra("st"));
        if(gi.getStringExtra("st")==null) {
            ans1.setText("last answers:");
        }
    }

    public void solution(View view) {
        bo=true;
        st=t1.getText().toString();
        if(st.length()==0) {
            bo=false;
        }
        else {
            aa = Double.parseDouble(st);
        }
        st=t2.getText().toString();
        if(st.length()==0) {
            bo=false;
        }
        else {
            b = Double.parseDouble(st);
        }
        st=t3.getText().toString();
        if(st.length()==0) {
            bo=false;
        }
        else {
            c = Double.parseDouble(st);
        }

        if(bo) {
            Intent si=new Intent(this,Main2Activity.class);
            si.putExtra("a",aa);
            si.putExtra("b",b);
            si.putExtra("c",c);
            startActivity(si);
        }
        else {
            ans2.setText("try again...");
        }
    }

    public void erase(View view) {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        ans2.setText("");
    }


    public void random(View view) {
        aa=Math.random()*100;
        x=Math.random();
        if(x<0.5) {
            aa=0-aa;
        }
        t1.setText(""+aa);
        b=Math.random()*100;
        x=Math.random();
        if(x<0.5) {
            b=0-b;
        }
        t2.setText(""+b);
        c=Math.random()*100;
        x=Math.random();
        if(x<0.5) {
            c=0-c;
        }
        t3.setText(""+c);
    }
}