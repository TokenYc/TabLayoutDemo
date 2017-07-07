package net.archeryc.tablayoutdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import static net.archeryc.tablayoutdemo.R.id.textView;

public class MainActivity extends AppCompatActivity {

    private SlidingTabLayout tabLayout;
    private ViewPager viewPager;

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private int oldPosition=-1;

    private final String[] mTitles = {
            "首页",
            "朋友圈",
            "首页",
            "朋友圈",
            "首页",
            "朋友圈",
            "首页",
            "朋友圈",
            "首页",
            "朋友圈",
            "首页",
            "朋友圈",
            "首页",
            "朋友圈",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (SlidingTabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        for (int i=0;i<mTitles.length;i++) {
            mFragments.add(BlankFragment.newInstance(mTitles[i]));
        }
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabLayout.setViewPager(viewPager);
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                TextView textView=tabLayout.getTitleView(position);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                if (oldPosition>=0){
                    TextView oldTextView=tabLayout.getTitleView(oldPosition);
                    oldTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
                }
                oldPosition=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }
}
