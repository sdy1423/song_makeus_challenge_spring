package com.example.makeuschallenge.src.login.select.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.makeuschallenge.R;
import com.example.makeuschallenge.src.BaseActivity;
import com.example.makeuschallenge.src.login.select.signup.interfaces.SignupActivityView;

import org.json.JSONException;

public class SignUpActivity extends BaseActivity implements SignupActivityView {

    EditText mEdtName,mEdtId,mEdtPwd;
    Button mBtnComplete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        mEdtPwd=findViewById(R.id.sign_up_edt_pwd);
//        mEdtName=findViewById(R.id.sign_up_edt_name);
//        mEdtId=findViewById(R.id.sign_up_edt_id);
        mBtnComplete=findViewById(R.id.sing_up_btn_complete);

    }

    public void onClick(View view) throws JSONException {
        String pwd =mEdtPwd.getText().toString();
        String name = mEdtName.getText().toString();
        String id = mEdtId.getText().toString();
        //TODO 체크 하고 넘기기

//        SignupService signupservice = new SignupService(this);


    }

    @Override
    public void postSignupSuccess() {

    }

    @Override
    public void postSignupFail() {

    }
}
