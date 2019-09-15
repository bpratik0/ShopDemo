package abhi.main.shopingdemo.ui.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import abhi.main.shopingdemo.utils.FontCache;
import androidx.appcompat.widget.AppCompatEditText;


/**
 */
public class EditTextPlus extends AppCompatEditText {

    public EditTextPlus(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public EditTextPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public EditTextPlus(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("Nunito-Regular.ttf", context);
        setTypeface(customFont);
    }
}
