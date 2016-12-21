package com.software.fire.carouseltutorial.item;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.genius.groupie.Item;
import com.software.fire.carouseltutorial.R;
import com.software.fire.carouseltutorial.databinding.ItemCarouselBinding;

/**
 * Created by Brad on 12/21/2016.
 */

public class CarouselItem extends Item<ItemCarouselBinding> {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.ItemDecoration carouselDecoration;
    private LinearLayoutManager layoutManager;

    public CarouselItem(RecyclerView.ItemDecoration carouselDecoration) {
        this.carouselDecoration = carouselDecoration;
    }

    public int getLayout() {
        return R.layout.item_carousel;
    }

    @Override
    public void bind(ItemCarouselBinding viewBinding, int position) {
        recyclerView = viewBinding.recyclerView; //findViewById
        layoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.removeItemDecoration(carouselDecoration);
        recyclerView.addItemDecoration(carouselDecoration);
    }


    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public RecyclerView.ItemDecoration getCarouselDecoration() {
        return carouselDecoration;
    }

    public LinearLayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }
}
