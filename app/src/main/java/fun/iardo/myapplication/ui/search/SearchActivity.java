package fun.iardo.myapplication.ui.search;

import androidx.fragment.app.Fragment;

import fun.iardo.myapplication.common.SingleFragmentActivity;

public class SearchActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return SearchFragment.newInstance();
    }
}
