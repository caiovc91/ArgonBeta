package caio.systems.argontest;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.matthewtamlin.sliding_intro_screen_library.indicators.DotIndicator;

import me.relex.circleindicator.CircleIndicator;

public class HomeMainSlider extends Fragment {

    private ViewPager mPager;
    private InternalPagerAdapter pagerAdapter;
    private CircleIndicator indicator;

    public HomeMainSlider() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_main_slider, container, false);
        mPager = v.findViewById(R.id.pager);
        indicator =  v.findViewById(R.id.indicator);
        pagerAdapter = new InternalPagerAdapter(getChildFragmentManager());
        mPager.setAdapter(pagerAdapter);


        return v;
    }
    class InternalPagerAdapter extends FragmentPagerAdapter {

        static final int NUMBER_OF_PAGES = 3;
        public InternalPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }


        public Fragment getItem(int position) {

            indicator.setViewPager(mPager);
            indicator.createIndicators(3,0);

            switch (position){
                case 0:
                    indicator.animatePageSelected(0);
                    return  HomeGraphFragment.newInstance("HOME MAIN FRAGMENT, Instance 1");
                case 1:
                    indicator.animatePageSelected(1);
                    //indicator.setSelectedItem(1, true);
                    return HomeEconomyFragment.newInstance("HOME ECONOMY FRAGMENT, Instance 2");
                case 2:
                    indicator.animatePageSelected(2);
                    //indicator.setSelectedItem(2, true);
                    return HomeGreenFragment.newInstance("HOME GREEN FRAGMENT, Instance 3");
                default: return null;
            }
        }

        @Override
        public int getCount() {
            return NUMBER_OF_PAGES;
        }
    }

}
