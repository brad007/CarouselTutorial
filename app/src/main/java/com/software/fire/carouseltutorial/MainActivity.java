package com.software.fire.carouseltutorial;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.genius.groupie.GroupAdapter;
import com.genius.groupie.Section;
import com.software.fire.carouseltutorial.databinding.ActivityMainBinding;
import com.software.fire.carouseltutorial.decoration.CarouselItemDecoration;
import com.software.fire.carouseltutorial.decoration.HeaderItemDecoration;
import com.software.fire.carouseltutorial.item.CarouselCardItem;
import com.software.fire.carouseltutorial.item.CarouselItem;
import com.software.fire.carouseltutorial.item.HeaderItem;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private GroupAdapter mGroupAdapter;
    private GridLayoutManager mLayoutManager;

    private int[] mRainbow200;

    int mGray;
    int mBetweenPadding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mGray = ContextCompat.getColor(this, R.color.background);
        mBetweenPadding = getResources().getDimensionPixelSize(R.dimen.padding_small);
        mRainbow200 = getResources().getIntArray(R.array.rainbow_200);

        mGroupAdapter = new GroupAdapter();
        mGroupAdapter.setSpanCount(12);
        populateAdapter();
        mLayoutManager = new GridLayoutManager(this, mGroupAdapter.getSpanCount());
        mLayoutManager.setSpanSizeLookup(mGroupAdapter.getSpanSizeLookup());

        final RecyclerView recyclerView = mBinding.recyclerView;
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new HeaderItemDecoration(mGray, mBetweenPadding));
        recyclerView.setAdapter(mGroupAdapter);

    }

    private void populateAdapter() {
        //Horizontal carousel
        Section carouselSection = new Section(new HeaderItem(R.string.carousel, R.string.carousel_subtitle));
        CarouselItem carouselItem = makeCarouselItem();
        carouselSection.add(carouselItem);
        mGroupAdapter.add(carouselSection);
        mGroupAdapter.add(carouselSection);
        mGroupAdapter.add(carouselSection);
    }

    private CarouselItem makeCarouselItem() {
        CarouselItemDecoration carouselItemDecoration = new CarouselItemDecoration(mGray, mBetweenPadding);
        GroupAdapter carouselAdapter = new GroupAdapter();
        for (int i = 0; i < 30; i++) {
            carouselAdapter.add(new CarouselCardItem(mRainbow200[i % (mRainbow200.length - 1)]));
        }
        CarouselItem carouselItem = new CarouselItem(carouselItemDecoration);
        carouselItem.setAdapter(carouselAdapter);
        return carouselItem;
    }
}
