package com.example.mygame.gamepanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import com.example.mygame.GameDisplay;
import com.example.mygame.R;
import com.example.mygame.gameobject.Player;

/**
 * HealthBar displays the players health to the screen
 */
public class HealthBar {

    private Player player;
    private int width, height, margin;
    private Paint borderPaint, healthPaint;

    public HealthBar(Context context, Player player){
        this.player = player;
        this.width = 100;
        this.height = 20;
        this.margin = 2;
        this.borderPaint = new Paint();
        int borderColor = ContextCompat.getColor(context, R.color.healthBarBorder);
        borderPaint.setColor(borderColor);

        this.healthPaint = new Paint();
        int healthColor = ContextCompat.getColor(context, R.color.healthBarHealth);
        healthPaint.setColor(healthColor);
    }

    public void draw(Canvas canvas, GameDisplay gameDisplay) {
        float x = (float) player.getPositionX();
        float y = (float) player.getPositionY();
        float distanceToPlayer = 30;
        float healthPointPercentage = (float) player.getHealthPoints()/player.MAX_HEALTH_POINTS;

        // Draw border
        float borderLeft, borderTop, borderRight, borderBottom;
        borderLeft = x - width/2;
        borderRight = x + width/2;
        borderBottom = y - distanceToPlayer;
        borderTop = borderBottom - height;
        canvas.drawRect(
            (float) gameDisplay.gameToDisplayCoordinatesX(borderLeft),
            (float) gameDisplay.gameToDisplayCoordinatesY(borderTop),
            (float) gameDisplay.gameToDisplayCoordinatesX(borderRight),
            (float) gameDisplay.gameToDisplayCoordinatesY(borderBottom),
            borderPaint
        );

        // Draw health
        float healthLeft, healthTop, healthRight, healthBottom, healthWidth, healthHeight;
        healthWidth = width - 2*margin;
        healthHeight = height - 2*margin;
        healthLeft = borderLeft + margin;
        healthRight = borderLeft + healthWidth*healthPointPercentage;
        healthBottom = borderBottom - margin;
        healthTop = healthBottom - healthHeight;
        canvas.drawRect(
            (float) gameDisplay.gameToDisplayCoordinatesX(healthLeft),
            (float) gameDisplay.gameToDisplayCoordinatesY(healthTop),
            (float) gameDisplay.gameToDisplayCoordinatesX(healthRight),
            (float) gameDisplay.gameToDisplayCoordinatesY(healthBottom),
            healthPaint
        );
    }
}
