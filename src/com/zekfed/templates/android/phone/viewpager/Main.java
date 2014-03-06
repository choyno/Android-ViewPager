//-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-::-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-//
//                                                                            //
//             Phone ViewPager Template Code                                  //
//                                                                            //
//             Main Class and Activity                                        //
//                                                                            //
//                                                                            //
//             Created by Asher Wood                                          //
//                                                                            //
//             © 2012 Asher Wood                                              //
//                                                                            //
//-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-::-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-//

package com.zekfed.templates.android.phone.viewpager;

import com.zekfed.templates.android.phone.viewpager.*;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Main extends FragmentActivity {

	SectionsPagerAdapter mSectionsPagerAdapter;

	static ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a SectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new SectionFragment();
			Bundle args = new Bundle();
			args.putInt(SectionFragment.ARG_SECTION_NUMBER, position);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase();
			case 1:
				return getString(R.string.title_section2).toUpperCase();
			case 2:
				return getString(R.string.title_section3).toUpperCase();
			}
			return null;
		}
	}

	
	public static class SectionFragment extends Fragment {
		
		public static final String ARG_SECTION_NUMBER = "section_number";

		public SectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			LayoutInflater inflater1 = (LayoutInflater) mViewPager.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			Bundle args = new Bundle();
			int resId = (Integer) getArguments().get(ARG_SECTION_NUMBER);
			switch (resId) {
			
			case 0:
				resId = R.layout.page1;
				break;
			case 1:
				resId = R.layout.page2;
				break;
			case 2:
				resId = R.layout.page3;
				break;
			}

			View view = inflater1.inflate(resId, null);

			return view;
		}
	}

}
