package fr.wcs.battlegeek.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

import static fr.wcs.battlegeek.ui.Block.State.ALIVE;

/**
 * Created by adphi on 26/09/17.
 */

public class Block implements Cloneable{

    // State
    protected State mState = ALIVE;

    // Geometry
    protected PointF mPosition;
    protected float mX;
    protected float mY;
    protected float mBlockSize;

    // Painting
    private Paint mPaintStroke = new Paint();
    private Paint mPaintAliveFill = new Paint();
    private Paint mPaintDeadFill = new Paint();

    /**
     * Constructor
     *
     * @param position PointF in Item
     */
    public Block(PointF position) {
        this.mPosition = position;
        this.mX = position.x;
        this.mY = position.y;
        init();
    }

    /**
     * Constructor
     *
     * @param x position in Item
     * @param y position in Item
     */
    public Block(float x, float y) {
        this.mPosition = new PointF(x, y);
        this.mX = x;
        this.mY = y;
        init();
    }

    /**
     * Copy Constructor
     * @param other
     */
    public Block(Block other) {
        mState = other.mState;
        mPosition = other.mPosition;
        mX = other.mX;
        mY = other.mY;
        mBlockSize = other.mBlockSize;

        mPaintStroke = other.mPaintStroke;
        mPaintAliveFill = other.mPaintAliveFill;
        mPaintDeadFill = other.mPaintDeadFill;
    }

    /**
     * Clone Method
     * @return
     */
    @Override
    public Block clone(){

        try {
            return (Block) super.clone();
        } catch (CloneNotSupportedException e) {
            return this;
        }

    }

    /**
     * @return the State of the Block
     */
    public State getState() {
        return mState;
    }

    /**
     * Set the State of the Block
     *
     * @param state
     */
    public void setState(State state) {
        mState = state;
    }

    /**
     * Return the Position of the Block relative to it's parent Item
     *
     * @return
     */
    public PointF getPosition() {
        return mPosition;
    }

    /**
     * Initiate Painters
     */
    private void init() {
        this.mPaintStroke.setStyle(Paint.Style.STROKE);
        this.mPaintStroke.setStrokeWidth(2);
        this.mPaintStroke.setColor(Color.BLACK);
        this.mPaintStroke.setAntiAlias(true);

        this.mPaintAliveFill.setStyle(Paint.Style.FILL);
        this.mPaintAliveFill.setColor(Color.GRAY);

        this.mPaintDeadFill.setStyle(Paint.Style.FILL);
        this.mPaintDeadFill.setColor(Color.BLACK);
    }

    /**
     * @return the x poisition in Item
     */
    public float getX() {
        return this.mX;
    }

    /**
     * @param x the x position in Item
     */
    public void setX(float x) {
        this.mX = x;
        this.mPosition.x = x;
    }

    /**
     * @return the y position in Item
     */
    public float getY() {
        return this.mY;
    }

    /**
     * @param y the y position in Item
     */
    public void setY(float y) {
        this.mY = y;
        this.mPosition.y = y;
    }

    /**
     * Check if the Block contains the PointF
     *
     * @param pointF
     * @return
     */
    public boolean contains(PointF pointF) {
        return this.mX <= pointF.x && pointF.x < this.mX + 1 &&
                this.mY <= pointF.y && pointF.y < this.mY + 1;
    }

    /**
     * Method to draw the Block to the Canvas
     *
     * @param canvas    the Canvas
     * @param itemX     the x Position of the parent Item relative to the Grid Coordinate System
     * @param itemY     the y Position of the parent Item relative to the Grid Coordinate System
     * @param blockSize the Size of the Block relative to the Canvas Coordinate System
     */
    public void draw(Canvas canvas, float itemX, float itemY, float blockSize) {
        this.mBlockSize = blockSize;
        float x = (itemX + mX) * mBlockSize;
        float y = (itemY + mY) * mBlockSize;
        switch (mState) {
            case ALIVE:
                canvas.drawRect(x, y, x + mBlockSize, y + mBlockSize, mPaintAliveFill);
                break;
            case DEAD:
                canvas.drawRect(x, y, x + mBlockSize, y + mBlockSize, mPaintDeadFill);
                break;
        }
        canvas.drawRect(x, y, x + mBlockSize, y + mBlockSize, mPaintStroke);
    }

    /**
     * Enumeration Block's Stats : ALIVE (initial State), DEAD (When the Block in the Item is Touch)
     */
    enum State {
        ALIVE, DEAD
    }

    /**
     * String Representation of a Block
     * @return
     */
    @Override
    public String toString() {
        return "Block{" +
                "mPosition=" + mPosition +
                "}\n";
    }
}
