package com.example.bellosil21.coloringapicture;

import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;
import static android.graphics.Color.rgb;

/**
 * <!-- class Controller -->
 *
 * This class serves as a communicator between the model and view
 * to change and manipulate values once something is changed
 *
 * @author Paul Patrick Bellosillo
 * @version February 20, 2019
 *
 */

/**
 * External Citation
 * Date:    September 19, 2019
 * Problem: Couldn't get the red, blue, and green values from a color
 * Resource:
 *      https://developer.android.com/reference/android/graphics/Color
 *
 * Solution: I used the red, blue, and green functions found in
 *      this site
 */

public class Controller implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener{

    // Declares instance variable for all views
    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;
    private Drawing picture;
    private TextView selectionMade;
    private TextView redValueText;
    private TextView greenValueText;
    private TextView blueValueText;
    private CustomElement element = null;

    // Declares RGB values for an element
    int red;
    int blue;
    int green;

    /** Controller
     *
     * Creates and initializes all communicators between
     * the model and the view
     *
     * @param display - Custom SurfaceView to be changed
     * @param redShadeSB - SeekBar for red Color values
     * @param greenShadeSB - SeekBar for green Color Values
     * @param blueShadeSB - SeekBar for blue Color Values
     * @param selection - CustomElement in display to be changed
     * @param redValue - TextView to indicate red value
     * @param greenValue - TextView to indicate green value
     * @param blueValue - Text View to indicate blue value
     */
    public Controller(Drawing display, SeekBar redShadeSB, SeekBar greenShadeSB,
                      SeekBar blueShadeSB, TextView selection, TextView redValue,
                      TextView greenValue, TextView blueValue){

        // Initializes all views
        picture = display;
        redSeekBar = redShadeSB;
        greenSeekBar = greenShadeSB;
        blueSeekBar = blueShadeSB;
        selectionMade = selection;

        // Initializes all RGB indicator TextViews
        redValueText = redValue;
        greenValueText = greenValue;
        blueValueText = blueValue;

        // Sets the Listeners for the SeekBars and SurfaceView
        picture.setOnTouchListener(this);
        redSeekBar.setOnSeekBarChangeListener(this);
        greenSeekBar.setOnSeekBarChangeListener(this);
        blueSeekBar.setOnSeekBarChangeListener(this);

    }

    /**onProgressChanged
     *
     * Changes and sets the color for element chosen
     * when seekBar progress is changed
     *
     * @param seekBar - Seek Bar being changed
     * @param progress - progress currently set on seekBar
     * @param fromUser - boolean if SeekBar is changed by user
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (element != null) {
            if (fromUser == true) {
                // Checks if the SeekBar changed is for red
                // Then sets the color change to the element
                if (seekBar == redSeekBar) {
                    red = progress;
                    element.setColor(rgb(red, green, blue));
                    redValueText.setText("" + progress);
                }

                // Checks if the SeekBar changed is for green
                // Then sets the color change to the element
                if (seekBar == greenSeekBar) {
                    green = progress;
                    element.setColor(rgb(red, green, blue));
                    greenValueText.setText("" + progress);
                }

                // Checks if the SeekBar changed is for blue
                // Then sets the color change to the element
                if (seekBar == blueSeekBar) {
                    blue = progress;
                    element.setColor(rgb(red, green, blue));
                    blueValueText.setText("" + progress);
                }

                // Reprints the Drawing SurfaceView to reflect changes
                picture.invalidate();
            }
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    /**onTouch
     *
     * Selects the element that is touched
     *
     * @param v - view that is being touched
     * @param event - Compressed detail about touch event
     *
     * @return true if touch an element is found otherwise false
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // Retrieves the coordinates for event
        float touchedX = event.getX();
        float touchedY = event.getY();

        // Finds the elements at touched coordinate
        element = picture.findElement((int)touchedX,
                (int)touchedY);

        // If element not found and set selection to null
        // and returns
        if (element == null){
            selectionMade.setText("None");
            return false;
        }

        // Retrieves RGB values from found element
        red = red(element.getColor());
        green = green(element.getColor());
        blue = blue(element.getColor());

        // Changes all TextView values retrieved by found element
        selectionMade.setText(element.getName());
        redValueText.setText(""+red);
        redSeekBar.setProgress(red);
        greenValueText.setText(""+green);
        greenSeekBar.setProgress(green);
        blueValueText.setText(""+blue);
        blueSeekBar.setProgress(blue);

        // return
        return true;

    }
}
