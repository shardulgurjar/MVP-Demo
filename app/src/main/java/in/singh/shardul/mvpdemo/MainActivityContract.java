package in.singh.shardul.mvpdemo;

public interface MainActivityContract {

    interface View{
        void onSuccess(String message);
        void onError(String message);
    }

    interface Presenter{
        void doLogin(String email,String password);
    }
}
