package com.example.bellosil21.coloringapicture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * <!-- class MainActivity -->
 *
 * This class starts up and displays the layout
 * retrieve the Views shown in the layout
 *
 * @author Paul Patrick Bellosillo
 * @version February 20, 2019
 *
 */
public class MainActivity extends AppCompatActivity {
    // Declares a Controller object for communication
    // between view and model
    Controller control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Starts up the program and layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieves the instances for all TextViews in the layout
        TextView selection = findViewById(R.id.selectionMade);
        TextView redValue = findViewById(R.id.redValue);
        TextView greenValue = findViewById(R.id.greenValue);
        TextView blueValue = findViewById(R.id.blueValue);

        // Retrieves the instances for all SeekBars in the layout
        SeekBar redSeekBar = findViewById(R.id.redShadeSeeker);
        SeekBar greenSeekBar = findViewById(R.id.greenShadeSeeker);
        SeekBar blueSeekBar = findViewById(R.id.blueShadeSeeker);

        // Retrieves the instances for the SurfaceView in the layout
        Drawing display = findViewById(R.id.drawing);

        // Initializes the Controller variable
        control = new Controller(display, redSeekBar, greenSeekBar,
                blueSeekBar, selection, redValue, greenValue, blueValue);
    }
}
