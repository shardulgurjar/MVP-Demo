package in.singh.shardul.mvpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private TextInputEditText edtEmail,edtPassword;
    private MaterialButton btnLogin;
    MainActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = null,password = null;
                try {
                     email = edtEmail.getText().toString().trim();
                }catch (NullPointerException e){
                    mt("Please Enter Email");
                }
                try{
                    password = edtPassword.getText().toString().trim();
                }catch (NullPointerException e){
                    mt("Plese Enter Password");
                }


                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    onError("Fields Required");
                }else{
                    presenter.doLogin(email,password);
                }

            }
        });
    }

    private void init() {
        presenter = new MainActivityPresenter(this);
        edtEmail = findViewById(R.id.email);
        edtPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
    }


    @Override
    public void onSuccess(String message) {
        mt(message);
    }

    @Override
    public void onError(String message) {
        mt(message);
    }

    public void mt(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
