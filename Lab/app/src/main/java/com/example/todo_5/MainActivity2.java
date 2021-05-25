package com.example.todo_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.todo_5";

    private TextView mTextViewReceivedHeader;
    private TextView mTextViewMessage;
    private EditText mEditTextReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTextViewReceivedHeader = (TextView) findViewById(R.id.textView3);
        mTextViewMessage = (TextView) findViewById(R.id.textView4);
        mEditTextReply = (EditText) findViewById(R.id.editText2);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        mTextViewMessage.setText(message);
    }

    public void previousActivity(View view) {
        Intent returnIntent = new Intent();
        String reply = mEditTextReply.getText().toString();
        returnIntent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK,returnIntent);
        finish();
    }
}