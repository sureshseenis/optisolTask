package parcelable.arivista.com.optisoltest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



public class Pager extends FragmentStatePagerAdapter {


    int tabCount;

    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                ListViewClass tab1 = new ListViewClass();
                return tab1;
            case 1:
                ListViewClass tab2 = new ListViewClass();
                return tab2;
            case 2:
                ListViewClass tab3 = new ListViewClass();
                return tab3;

            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}