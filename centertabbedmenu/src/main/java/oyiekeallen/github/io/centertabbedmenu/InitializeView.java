package oyiekeallen.github.io.centertabbedmenu;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class InitializeView {


    HeightWrappingViewPager wrappingViewPager;
    TabLayout tablayout;
    LinearLayout tabLayout_ll;
    CardView cardView;

    String mfrag_two_title;
    Fragment mfrag_two;
    String mfrag_one_title;
    Fragment mfrag_one;
    ItemAdapter mAdapter;
    FragmentManager mfm;

    public InitializeView(Context mContext, FragmentManager fm, ItemAdapter itemAdapter, Fragment frag_one, String frag_one_title, Fragment frag_two, String frag_two_title) {


        CardView parent = setParentView(mContext);
        LinearLayout child = setChildView(mContext);

        parent.addView(child);


        //Add fragments "two"
        ItemAdapter adapter = AddFragments(fm, itemAdapter, frag_one, frag_one_title, frag_two, frag_two_title);
        wrappingViewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(wrappingViewPager);


    }

    public CardView setParentView(Context mContext) {
        //Initialize parent View
        this.cardView = new CardView(mContext);
        cardView.setCardElevation(4f);
        cardView.setPadding(20, 20, 20, 20);
        cardView.setRadius(8f);

        return cardView;

    }

    public LinearLayout setChildView(Context mContext) {

        this.tabLayout_ll = new LinearLayout(mContext);
        tabLayout_ll.setWeightSum(5f);
        tabLayout_ll.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams tabLayout_llp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);


        this.tablayout = new TabLayout(mContext, null, R.style.CardView);
        tablayout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        this.wrappingViewPager = new HeightWrappingViewPager(mContext);
        wrappingViewPager.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        // Add views

        tabLayout_ll.addView(tablayout);
        tabLayout_ll.addView(wrappingViewPager);

        return tabLayout_ll;
    }


    public ItemAdapter AddFragments(FragmentManager fm, ItemAdapter itemAdapter, Fragment frag_one, String frag_one_title, Fragment frag_two, String frag_two_title) {

        mfm = fm;
        mAdapter = itemAdapter;
        mfrag_one = frag_one;
        mfrag_one_title = frag_one_title;
        mfrag_two = frag_two;
        mfrag_two_title = frag_two_title;


        return addFragmentsToAdapter(mfm, mAdapter, mfrag_one, mfrag_one_title, mfrag_two, mfrag_two_title);

    }


    public ItemAdapter addFragmentsToAdapter(FragmentManager frag_man, ItemAdapter adapter, Fragment frag_one, String frag_one_title, Fragment frag_two, String frag_two_title) {


        FragmentManager fm = frag_man;
        adapter = new ItemAdapter(fm);

        adapter.AddFragment(frag_one, frag_one_title);
        adapter.AddFragment(frag_two, frag_two_title);

        return adapter;

    }

}