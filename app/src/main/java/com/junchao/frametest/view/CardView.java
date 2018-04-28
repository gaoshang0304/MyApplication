package com.junchao.frametest.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.junchao.frametest.R;
import com.junchao.frametest.utils.LogUtil;

/**
 * @author gjc
 * @version ;;
 * @since 2018-03-05
 */

public class CardView extends View {


    private Bitmap[] cards = new Bitmap[3];
    private int[] mImgId = {R.drawable.lufei, R.drawable.suolong, R.drawable.shoushudao};

    public CardView(Context context) {
        this(context, null);

    }

    public CardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Bitmap bm = null;
        for (int i = 0; i < cards.length; i++) {
            bm = BitmapFactory.decodeResource(getResources(), mImgId[i]);
            cards[i] = Bitmap.createScaledBitmap(bm, 400, 600, false);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        LogUtil.e("app", "onDraw");
        canvas.save();
        canvas.translate(20, 120);
        for (int i = 0; i < cards.length; i++) {
            canvas.translate(120, 0);
            canvas.save();
            if (i < cards.length - 1) {
                canvas.clipRect(0, 0, 120, cards[i].getHeight());
            }
            canvas.drawBitmap(cards[i], 0, 0, null);
            canvas.restore();
        }
        canvas.restore();

    }
}
