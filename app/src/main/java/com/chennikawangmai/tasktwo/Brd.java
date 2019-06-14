package com.chennikawangmai.tasktwo;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


public class Brd extends View
{ Bitmap cell;
    int  sampleSize;

    Bitmap rb;

    Brd(Context context){
        super(context);
        rb= BitmapFactory.decodeResource(getResources(),R.drawable.redcircle);
        cell= BitmapFactory.decodeResource(getResources(),R.drawable.cell_frame);
        BitmapFactory.Options bitmapoptions=new BitmapFactory.Options();
        bitmapoptions.inSampleSize = 3;
        cell= BitmapFactory.decodeResource(getResources(),R.drawable.cell_frame,bitmapoptions);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint paint;


        for (int i= (canvas.getHeight()/12)*6;i<=canvas.getHeight();i=i+canvas.getHeight()/12)
        { for(int j=3;j<=canvas.getWidth();j=j+canvas.getWidth()/7)
        {canvas.drawBitmap(cell,j,i,null);}
        }

        Paint paint1=new Paint();
        paint1.setColor(getResources().getColor(R.color.blue));

        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(8);
        for (int i= (canvas.getHeight()/12)*6;i<=canvas.getHeight();i=i+canvas.getHeight()/12)
        { for(int j=3;j<=canvas.getWidth();j=j+canvas.getWidth()/7)
        {canvas.drawLine(j,i,j,canvas.getHeight(),paint1);
            canvas.drawLine(j,i,canvas.getWidth(),i,paint1);}
        }

    }

}
