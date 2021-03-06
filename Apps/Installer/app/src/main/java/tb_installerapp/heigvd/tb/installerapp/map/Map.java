package tb_installerapp.heigvd.tb.installerapp.map;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import tb_installerapp.heigvd.tb.installerapp.AppConfig;
import tb_installerapp.heigvd.tb.installerapp.R;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by anthony on 30.11.2015.
 */
public class Map {
    private ImageView mImageView;
    private PhotoViewAttacher mAttacher;
    private Resources resources;
    private Drawable map;

    private TextView outX;
    private TextView outY;
    private double onePercentHeight;
    private double onePercentWidth;


    public Map(ImageView mapImage, Activity activity, TextView outX, TextView outY){
        mImageView = mapImage;
        this.resources = activity.getResources();
        this.outX = outX;
        this.outY = outY;

        //On récupère l'image de la mémoire
        map = resources.getDrawable(AppConfig.MAP);

        //on récupère la vrai taille
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        //Returns null, sizes are in the options variable
        BitmapFactory.decodeResource(resources, AppConfig.MAP, options);
        int realWidth = options.outWidth;
        int realHeight = options.outHeight;
        onePercentHeight = realHeight/100.0;
        onePercentWidth = realWidth/100.0;

        mImageView.setImageDrawable(map);
        mAttacher = new PhotoViewAttacher(mImageView);
        mAttacher.setOnPhotoTapListener(new MapTapListener());
    }


    private class MapTapListener implements PhotoViewAttacher.OnPhotoTapListener {
        @Override
        public void onPhotoTap(View view, float x, float y) {
            int xPx = (int)(100 * x * onePercentWidth);
            int yPx = (int)(100 * y * onePercentHeight);

            outX.setText(xPx + "");
            outY.setText(yPx + "");
        }
    }
}
