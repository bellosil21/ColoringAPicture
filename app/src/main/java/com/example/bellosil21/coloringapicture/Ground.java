package com.example.bellosil21.coloringapicture;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * <!-- class Ground -->
 *
 * This class defines a Sun object used for drawing the floor
 * on Drawing View
 * This class also inherited from the CustomElement class
 *
 * @author Paul Patrick Bellosillo
 * @version February 20, 2019
 *
 */

public class Ground extends CustomElement {

    //Declares teh rectangle for the floor
    Rect floor;

    /**Sun
     *
     * Creates and initializes a Ground object
     *
     * @param name - name of object
     * @param color - color used for object
     * @param left - X coordinate for left edge of object
     * @param top - Y coordinate for top edge of object
     * @param right - X coordinate for right edge of object
     * @param bottom - Y coordinate for bottom edge of object
     */
    public Ground(String name, int color,
               int left, int top, int right, int bottom)
    {
        // Sets the name, color and shape for the object
        super(name, color);
        this.floor = new Rect(left, top, right, bottom);
    }

    /** drawMe
     *
     * Draws the Ground CustomElement to custom SurfaceView
     *
     * @param canvas - canvas to be drawn on
     */
    @Override
    public void drawMe(Canvas canvas) {
        // Draws the floor at the given points and outline
        canvas.drawRect(floor, myPaint);
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
        int left = this.floor.left - TAP_MARGIN;
        int top = this.floor.top - TAP_MARGIN;
        int right = this.floor.right + TAP_MARGIN;
        int bottom = this.floor.bottom + TAP_MARGIN;
        Rect check = new Rect(left, top, right, bottom);

        // Checks and returns boolean for if the given coordinate
        // is within the boundary
        return check.contains(x,y);
    }

    /**getSize
     *
     * Calculate and returns the size of object
     *
     * @return size of object
     */
    @Override
    public int getSize() {
        // Calculate the area of the floor
        return floor.width() * floor.height();
    }

    /**drawHighlight
     *
     * Draws the outline or highlights for Ground Object
     *
     * @param canvas - canvas to be drawn on
     */
    @Override
    public void drawHighlight(Canvas canvas) {
        canvas.drawRect(floor, outlinePaint);
    }
}
