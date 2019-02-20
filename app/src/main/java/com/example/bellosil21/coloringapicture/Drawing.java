package com.example.bellosil21.coloringapicture;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.jar.Attributes;

/**
 * <!-- class Drawing -->
 *
 * This class creates a custom SurfaceView and an ArrayList of
 * CustomElements to draw on this custom Surface
 * This class also inherits SurfaceView
 *
 * @author Paul Patrick Bellosillo
 * @version February 20, 2019
 *
 */

public class Drawing extends SurfaceView{

    // declares an ArrayList needed to store a series of CustomElements
    // created
    ArrayList<CustomElement> picture;
    int white = 0xffffffff;


    /**Drawing
     *
     * Creates a custom Drawing SurfaceView Object
     *
     * @param context - service object is performing
     */
    public Drawing(Context context) {
        // Calls inherited constructor and Initializes the
        // custom SurfaceView
        super(context);
        init();
    }

    /** Drawing
     *
     * Creates a custom Drawing SurfaceView Object
     *
     * @param context - service object is performing
     * @param attrs - Attribute Set to be used for service
     */
    public Drawing(Context context, AttributeSet attrs) {
        // Calls inherited constructor and Initializes the
        // custom SurfaceView
        super(context, attrs);
        init();
    }

    /** Drawing
     *
     * Creates a custom Drawing SurfaceView Object
     *
     * @param context - service object is performing
     * @param attrs - Attribute Set to be used for service
     * @param defStyleAttr - Theme for resource style
     */
    public Drawing(Context context, AttributeSet attrs, int defStyleAttr) {
        // Calls inherited constructor and Initializes the
        // custom SurfaceView
        super(context, attrs, defStyleAttr);
        init();
    }

    /** init
     *
     * Creates all elements needed to draw the picture
     * and adds each to an ArrayList
     */
    private void init() {

        // Sets the ability to draw on the custom SurfaceView to true
        setWillNotDraw(false);

        // Creates a new ArrayList
        picture = new ArrayList<CustomElement>();

        // Creates the floor and adds it to the ArrayList for drawing
        Ground floor = new Ground("Ground", 0xffa0a0a0, 0, 700, 2000, 1000);
        picture.add(floor);

        // Creates two Snowman objects and adds it the the ArrayList for drawing
        Snowman snowman = new Snowman("Snowman", white, 300, 500, 400, 600);
        picture.add(snowman);
        Snowman snowBuddy = new Snowman("Snow Buddy", white, 1000, 500, 1100, 600);
        picture.add(snowBuddy);

        // Creates two Hat objects for the Snowman objects
        // adds it the ArrayList for drawing
        Hat snowmanHat = new Hat("Snowman's Hat", 0xff555555, 300, 400, 400, 505);
        picture.add(snowmanHat);
        Hat snowBuddyHat = new Hat("Snow Buddy's Hat", 0xff000000, 1000, 400, 1100, 505);
        picture.add(snowBuddyHat);

        // Creates a Sun object and adds it the ArrayList for drawing
        Sun sun = new Sun("Sun", 0xffffff00, 100, 50, 200, 150);
        picture.add(sun);

    }

    /**onDraw
     *
     * Draws all the elements to the this SurfaceView
     *
     * @param canvas - canvas to be drawn on
     */
    @Override
    protected void onDraw(Canvas canvas) {
        // Draws each element in the picture ArrayList one
        // at a time
        for (CustomElement element : picture) {
            element.drawMe(canvas);
        }
    }

    /** findElement
     *
     * Finds the element that has been touched at x and y
     *
     * @param x - X coordinate touched
     * @param y - Y coordinate touched
     *
     * @return last drawn element drawn at given coordinates
     */
    public CustomElement findElement(int x, int y) {

        // Checks and stores all CustomElements found
        // at coordinates (x,y) and stores it into an render
        ArrayList<CustomElement> render = new ArrayList<CustomElement>();
        for (CustomElement element : picture) {
            if (element.containsPoint(x, y)) {
                render.add(element);
            }
        }

        // Runs through the render ArrayList to retrieve the last
        // drawn element at touched point
        CustomElement submit = null;
        for (CustomElement rendered: render){
            if (rendered.containsPoint(x, y)) {
                submit = rendered;
            }
        }

        // Returns last drawn element for selection
        return submit;
    }
}
