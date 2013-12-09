package utilities.views.list;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment for the
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(ibr.androidlab.simplesql.R.layout.list_fragement, container, false);
    }
}