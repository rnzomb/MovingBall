package zzzomb.ball;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    private int start_x =50;
    private int start_y =50;

    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawScene scene = new DrawScene(this, start_x, start_y);
        setContentView(scene);
    }
}