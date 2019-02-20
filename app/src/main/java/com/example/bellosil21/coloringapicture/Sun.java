package com.example.bellosil21.coloringapicture;

import android.graphics.Canvas;

/**
 * <!-- class Sun -->
 *
 * This class defines a Sun object used for drawing a sun the SurfaceView
 * This class also inherited from the CustomElement class
 *
 * @author Paul Patrick Bellosillo
 * @version February 20, 2019
 *
 */

public class Sun extends CustomElement{

    // Declares the origin and radius for the sun
    float centerX;
    float centerY;
    float sunRadius;

    /**Sun
     *
     * Creates and initializes a Sun object
     *
     * @param name - name of object
     * @param color - color used for object
     * @param left - X coordinate for left edge of object
     * @param top - Y coordinate for top edge of object
     * @param right - X coordinate for right edge of object
     * @param bottom - Y coordinate for bottom edge of object
     */
    public Sun(String name, int color,
                      int left, int top, int right, int bottom)
        {
            // Sets the name and color for the Sun
            super(name, color);

            // Initializes the origin and radius for the Sun
            centerX = (right + left) / 2;
            centerY = (top + bottom) / 2;
            sunRadius = (right - left) / 2;
        }

    /** drawMe
     *
     * Draws the Sun CustomElement to custom SurfaceView
     *
     * @param canvas - canvas to be drawn on
     */
    @Override
    public void drawMe(Canvas canvas) {
        // Draws the sun at given points along with outline
        canvas.drawCircle(centerX, centerY, sunRadius, myPaint);
        this.drawHighlight(canvas);
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

        // Sets a boundary for the object
        int xDist = Math.abs(x - (int) centerX);
        int yDist = Math.abs(y - (int) centerY);
        int dist = (int)Math.sqrt(xDist*xDist + yDist*yDist);  //Thanks, Pythagoras :)

        // Checks and returns boolean for if the given coordinate
        // is within the boundary
        return (dist < this.sunRadius + TAP_MARGIN);

    }

    /**getSize
     *
     * Calculate and returns the size of object
     *
     * @return size of object
     */
    @Override
    public int getSize() {
        // Returns the area of the sun
        return (int) (3.14 * sunRadius * sunRadius);
    }

    /**drawHighlight
     *
     * Draws the outline or highlights for Ground Object
     *
     * @param canvas - canvas to be drawn on
     */
    @Override
    public void drawHighlight(Canvas canvas) {
        //Draws outline of the sun
        canvas.drawCircle(centerX, centerY, sunRadius, outlinePaint);
    }
}
