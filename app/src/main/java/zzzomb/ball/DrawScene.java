package zzzomb.ball;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.View;

public class DrawScene extends View {

    private Paint canvasPaint;
    private Paint circlePaint;

    private int x;
    private int y;
    private int circleRadius = 32;

    private int dx = 5;
    private int dy = 5;
    private final int FRAME_RATE = 1;

    private int scene_width;
    private int scene_height;

    private Handler h;

    public DrawScene(Context context, int start_x, int start_y) {
        super(context);
        x = start_x;
        y = start_y;

        canvasPaint = new Paint();
        canvasPaint.setStyle(Paint.Style.FILL);
        canvasPaint.setColor(Color.LTGRAY);



        h = new Handler();
    }

    private Runnable r = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    @Override
    protected void onDraw(Canvas sceneCanvas) {
        super.onDraw(sceneCanvas);

        sceneCanvas.drawPaint(canvasPaint);
        scene_width = this.getWidth();
        scene_height = this.getHeight();


        Bitmap d = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        sceneCanvas.drawBitmap(d, x, y, circlePaint);

        x += dx;
        y += dy;

        if ((x > scene_width - circleRadius * 2) || (x < 0)) {
            dx = dx * -1;
        }

        if ((y > scene_height - circleRadius * 2) || (y < 0)) {
            dy = dy * -1;
        }

        h.postDelayed(r, FRAME_RATE);
    }

}