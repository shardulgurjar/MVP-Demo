package in.singh.shardul.mvpdemo;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {

        if(email.equals("abc@demo.com") && password.equals("123")){
            view.onSuccess("Success");
        }else{
            view.onError("Incorrect Credentials");
        }
    }
}
