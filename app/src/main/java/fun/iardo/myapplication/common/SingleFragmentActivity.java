package fun.iardo.myapplication.common;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import fun.iardo.myapplication.R;


public abstract class SingleFragmentActivity extends AppCompatActivity
        implements OnBackPressedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ac_swipe_container);

        if (savedInstanceState == null) {
            changeFragment(getFragment());
        }
    }

    protected abstract Fragment getFragment();

    public void changeFragment(Fragment fragment){
        boolean addToBackStack = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer) != null;

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment);

        if (addToBackStack){
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        }

        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        OnBackPressedListener backPressedListener = null;
        for (Fragment fragment: fm.getFragments()) {
            if (fragment instanceof  OnBackPressedListener) {
                backPressedListener = (OnBackPressedListener) fragment;
                break;
            }
        }

        if (backPressedListener != null) {
            backPressedListener.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

}
