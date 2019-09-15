package abhi.main.shopingdemo.ui.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import abhi.main.shopingdemo.utils.FontCache;
import androidx.appcompat.widget.AppCompatButton;


/**
 */
public class ButtonPlus extends AppCompatButton {

    public ButtonPlus(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public ButtonPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public ButtonPlus(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("Nunito-Bold.ttf", context);
        setTypeface(customFont);
    }
}
