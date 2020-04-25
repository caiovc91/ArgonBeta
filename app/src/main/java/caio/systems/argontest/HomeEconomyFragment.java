package caio.systems.argontest;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matthewtamlin.sliding_intro_screen_library.indicators.DotIndicator;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeEconomyFragment extends Fragment {

    public HomeEconomyFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_economy, container, false);
        DotIndicator indicator = new DotIndicator(getContext());
        indicator.getNumberOfItems();
        return v;
    }

    public static HomeEconomyFragment newInstance(String text) {

        HomeEconomyFragment f = new HomeEconomyFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

}
