package com.example.todo_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declare key value pair for intent
    public static final String EXTRA_MESSAGE = "com.example.todo_5";
    public static final String LOG_TAG = "==========";
    public static final int TEXT_REQUEST = 1;
    private TextView mTextViewHeader;
    private TextView mTextViewReply;
    private EditText mEditTextSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewHeader = (TextView) findViewById(R.id.textView1);
        mTextViewReply = (TextView) findViewById(R.id.textView2);
        mEditTextSend = (EditText) findViewById(R.id.editText1);
        Log.d(LOG_TAG,"onCreate");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }@Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }
    public void nextActivity(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        String message = mEditTextSend.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent,TEXT_REQUEST);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String message = data.getStringExtra(MainActivity2.EXTRA_REPLY);
                mTextViewHeader.setVisibility(View.VISIBLE);
                mTextViewReply.setText(message);
                mTextViewReply.setVisibility(View.VISIBLE);
            }
        }
    }
}