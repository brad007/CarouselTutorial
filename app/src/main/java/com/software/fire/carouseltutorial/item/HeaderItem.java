package com.software.fire.carouseltutorial.item;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.View;

import com.genius.groupie.Item;
import com.software.fire.carouseltutorial.R;
import com.software.fire.carouseltutorial.databinding.ItemHeaderBinding;

/**
 * Created by Brad on 12/21/2016.
 */

public class HeaderItem extends Item<ItemHeaderBinding> {
    @StringRes
    private int titleStringResId;
    @StringRes
    private int subtitleResId;
    @DrawableRes
    private int iconResId;
    private View.OnClickListener onIconClickListener;


    public HeaderItem(@StringRes int titleStringResId) {
        this.titleStringResId = titleStringResId;
    }

    public HeaderItem(@StringRes int titleStringResId, @StringRes int subtitleResId) {
        this(titleStringResId, subtitleResId, 0, null);
    }

    public HeaderItem(@StringRes int titleStringResId, @StringRes int subtitleResId, @DrawableRes int iconResId, View.OnClickListener onIconClickListener) {
        this.titleStringResId = titleStringResId;
        this.subtitleResId = subtitleResId;
        this.iconResId = iconResId;
        this.onIconClickListener = onIconClickListener;
    }


    public int getLayout() {
        return R.layout.item_header;
    }

    @Override
    public void bind(ItemHeaderBinding viewBinding, int position) {
        viewBinding.title.setText(titleStringResId);
        if (subtitleResId > 0) {
            viewBinding.subtitle.setText(subtitleResId);
        }
        viewBinding.subtitle.setVisibility(subtitleResId > 0 ? View.VISIBLE : View.GONE);

        if (iconResId > 0) {
            viewBinding.icon.setImageResource(iconResId);
            viewBinding.icon.setOnClickListener(onIconClickListener);
        }
        viewBinding.icon.setVisibility(iconResId > 0 ? View.VISIBLE : View.GONE);
    }
}
