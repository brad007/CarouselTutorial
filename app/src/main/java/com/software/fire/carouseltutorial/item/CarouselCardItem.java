package com.software.fire.carouseltutorial.item;

import android.support.annotation.ColorInt;

import com.genius.groupie.Item;
import com.software.fire.carouseltutorial.R;
import com.software.fire.carouseltutorial.databinding.ItemSquareCardBinding;

/**
 * Created by Brad on 12/21/2016.
 */

public class CarouselCardItem extends Item<ItemSquareCardBinding> {

    @ColorInt
    private int colorRes;

    public CarouselCardItem(@ColorInt int colorRes) {
        this.colorRes = colorRes;
    }

    @Override
    public int getLayout() {
        return R.layout.item_square_card;
    }

    @Override
    public void bind(ItemSquareCardBinding viewBinding, int position) {
        viewBinding.getRoot().setBackgroundColor(colorRes);
    }
}
