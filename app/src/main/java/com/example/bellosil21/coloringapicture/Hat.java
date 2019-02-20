package com.example.bellosil21.coloringapicture;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * <!-- class Hat -->
 *
 * This class defines a Sun object used for drawing a hat
 * for a Snowman object on Drawing View
 * This class also inherited from the CustomElement class
 *
 * @author Paul Patrick Bellosillo
 * @version February 20, 2019
 *
 */

public class Hat extends CustomElement {


    /** the position and size of the rectangle is stored here */
    protected Rect topPortion;
    protected Rect bottomPortion;
    protected Rect band;
    protected Paint bandColor;

    /**Sun
     *
     * Creates and initializes a Hat object for
     * a Snowman object
     *
     * @param name - name of object
     * @param color - color used for object
     * @param left - X coordinate for left edge of object
     * @param top - Y coordinate for top edge of object
     * @param right - X coordinate for right edge of object
     * @param bottom - Y coordinate for bottom edge of object
     */
    public Hat(String name, int color,
                      int left, int top, int right, int bottom)
    {
        // Sets name and color for object
        super(name, color);

        // Initializes adjusted coordinate for visor of hat
        int adjLeft = left + 25;
        int adjRight = right - 25;
        int adjBottom = bottom - 25;
        int adjTop = bottom - 35;

        // Initializes the coordinate objects for each portion of the hat
        this.topPortion = new Rect(adjLeft, top, adjRight, adjBottom);
        this.bottomPortion = new Rect(left, adjBottom, right, bottom);
        this.band = new Rect(adjLeft, adjTop, adjRight, adjBottom);

        // Sets the Red band color
        bandColor = new Paint();
        bandColor.setColor(0xffff0000);
    }

    /** drawMe
     *
     * Draws the hat CustomElement for a Snowman object
     * to the custom SurfaceView
     *
     * @param canvas - canvas to be drawn on
     */
    @Override
    public void drawMe(Canvas canvas) {
        // Draws all the parts of the hat
        canvas.drawRect(topPortion, myPaint);
        canvas.drawRect(bottomPortion, myPaint);
        canvas.drawRect(band, bandColor);
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

        // Sets a boundary for the top portion of object
        int left = this.topPortion.left - TAP_MARGIN;
        int top = this.topPortion.top - TAP_MARGIN;
        int right = this.topPortion.right + TAP_MARGIN;
        int bottom = this.topPortion.bottom + TAP_MARGIN;
        Rect topCheck = new Rect(left, top, right, bottom);

        // Checks if coordinate reside in the top portion
        // and returns true if true
        if (topCheck.contains(x,y) == true){
            return topCheck.contains(x,y);
        }

        // Sets a boundary for the lower portion of object
        left = this.bottomPortion.left - TAP_MARGIN;
        top = this.bottomPortion.top - TAP_MARGIN;
        right = this.bottomPortion.right + TAP_MARGIN;
        bottom = this.bottomPortion.bottom + TAP_MARGIN;
        Rect botCheck = new Rect(left, top, right, bottom);

        // Checks and returns boolean for if the given coordinate
        // is within the boundary
        return botCheck.contains(x,y);

    }//containsPoint


    /**getSize
     *
     * Calculate and returns the size of object
     *
     * @return size of object
     */
    @Override
    public int getSize() {
        // Calculates the area of the hat
        int size = this.topPortion.width() * this.topPortion.height();
        size = size + (this.bottomPortion.height() + this.bottomPortion.width());
        return size;
    }

    /**drawHighlight
     *
     * Draws the outline or highlights for Ground Object
     *
     * @param canvas - canvas to be drawn on
     */
    @Override
    public void drawHighlight(Canvas canvas) {
        // Draws the outline for the top of the hat
        // and the visor
        canvas.drawRect(band,outlinePaint);
        canvas.drawRect(topPortion,outlinePaint);
        canvas.drawRect(bottomPortion, outlinePaint);
    }
}//class CustomRect
