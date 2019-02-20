package com.example.bellosil21.coloringapicture;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * <!-- class Snowman -->
 *
 * This class defines a Snowman object used for drawing the SurfaceView
 * This class also inherited from the CustomElement class
 *
 * @author Paul Patrick Bellosillo
 * @version February 20, 2019
 *
 */

public class Snowman extends CustomElement {

    // Declares head circle origin and radius
    float headRadius;
    float headInitX;
    float headInitY;

    // Declares body circle origin and radius
    float bodyRadius;
    float bodyInitX;
    float bodyInitY;

    // Declares radius and Color for the nose
    float eyeRadius;
    Paint eyeColor;

    /**Snowman
     *
     * Creates and initializes a Snowman object
     *
     * @param name - name of object
     * @param color - color used for object
     * @param left - X coordinate for left edge of object
     * @param top - Y coordinate for top edge of object
     * @param right - X coordinate for right edge of object
     * @param bottom - Y coordinate for bottom edge of object
     */
    public Snowman(String name, int color,
               int left, int top, int right, int bottom)
    {
        // Sets name and color for object
        super(name, color);

        // Sets the origin and radius for the head
        headRadius = (right - left) / 2;
        headInitX = (right + left) / 2;
        headInitY = (top + bottom) / 2;

        // Sets the origin and the radius for the body
        bodyRadius = headRadius * 2;
        bodyInitX = headInitX;
        bodyInitY = headInitY + (headRadius * 2.5f);

        // Sets the radius and color for the eyes
        eyeRadius = headRadius / 10;
        eyeColor = new Paint();
        eyeColor.setColor(Color.BLACK);
    }

    /** drawMe
     *
     * Draws the Snowman CustomElement to custom SurfaceView
     *
     * @param canvas - canvas to be drawn on
     */
    @Override
    public void drawMe(Canvas canvas) {
        // Draws the body of the snowman
        canvas.drawCircle(bodyInitX, bodyInitY, bodyRadius, myPaint);
        canvas.drawCircle(bodyInitX, bodyInitY, bodyRadius, outlinePaint);

        // Draws the head of the Snowman
        canvas.drawCircle(headInitX, headInitY, headRadius, myPaint);
        this.drawHighlight(canvas);

        // Draws the eyes
        canvas.drawCircle(headInitX + 5, headInitY, eyeRadius, eyeColor);
        canvas.drawCircle(headInitX + 25, headInitY, eyeRadius, eyeColor);
    }

    /**containPoint
     *
     * Checks if the element is drawn over given coordinate
     *
     * @param x - X coordinate that is touched
     * @param y - Y coordinate that is touched
     *
     * @return true if object contain the point. Otherwise,
     *      returns false
     */
    @Override
    public boolean containsPoint(int x, int y) {

        // Sets a boundary for the head of the object
        int xDist = Math.abs(x - (int) headInitX);
        int yDist = Math.abs(y - (int) headInitY);
        int dist = (int)Math.sqrt(xDist*xDist + yDist*yDist);  //Thanks, Pythagoras :)

        // Checks if coordinate reside in the head
        // and returns if true
        if (dist < headRadius + TAP_MARGIN){
            return true;
        }

        // Sets a boundary for the body of the object
        xDist = Math.abs(x - (int) bodyInitX);
        yDist = Math.abs(y - (int) bodyInitY);
        dist = (int)Math.sqrt(xDist*xDist + yDist*yDist);  //Thanks, Pythagoras :)

        // Checks and returns boolean for if the given coordinate
        // is within the boundary
        return  (dist < bodyRadius + TAP_MARGIN);
    }

    /**getSize
     *
     * Calculate and returns the size of object
     *
     * @return size of object
     */
    @Override
    public int getSize() {
        // Calculates sum of the areas of the body and head
        double size = 3.14 * headRadius * headRadius;
        size = size + (3.14 * bodyRadius * bodyRadius);
        return (int) size;
    }

    /**drawHighlight
     *
     * Draws the outline or highlights for Ground Object
     *
     * @param canvas - canvas to be drawn on
     */
    @Override
    public void drawHighlight(Canvas canvas) {
        canvas.drawCircle(headInitX, headInitY, headRadius, outlinePaint);
    }
}
