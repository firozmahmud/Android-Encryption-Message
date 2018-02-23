package com.example.my_pc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.getMsgId)
    EditText getMsgId;
    @BindView(R.id.getPassId)
    EditText getPassId;
    @BindView(R.id.viewEncMsgId)
    EditText viewEncMsgId;
    @BindView(R.id.getDecPass)
    EditText getDecPass;
    @BindView(R.id.dicriptMsg)
    EditText dicriptMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnEnc)
    public void onBtnEncClicked() {
        String msg = getMsgId.getText().toString().trim();
        String pass = getPassId.getText().toString().trim();

        String encryptedString = AES.encrypt(msg, pass);

        viewEncMsgId.setText(encryptedString);

    }

    @OnClick(R.id.btnDec)
    public void onBtnDecClicked() {

        String msg = viewEncMsgId.getText().toString().trim();
        String pass = getDecPass.getText().toString().trim();

        String decryptedString = AES.decrypt(msg, pass);

        dicriptMsg.setText(decryptedString);
    }
}
