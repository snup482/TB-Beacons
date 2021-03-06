package tb.heigvd.tb_userapp;

import android.graphics.Color;

/**
 * Created by anthony on 03.12.2015.
 */
public class AppConfig {
    //Dessin
    public static final int CIRCLE_STAND_RADIUS = 100;
    public static final int CIRCLE_POSITION_RADIUS = 200;
    public static final int COLOR_DEFAULT = Color.BLACK;
    public static final int COLOR_DESTINATION = Color.RED;
    public static final int COLOR_POSITION = Color.GREEN;

    //Carte
    public static final int MAP = R.drawable.ecole_map;

    //Serveur
    public static final String URL_ROOT = "http://heigvd-tb-beacons.appspot.com/api";

    public static final String URL_GET_ALL_STAND = URL_ROOT + "/stand";
    public static final String URL_GET_ALL_BALISE = URL_ROOT + "/balise";
    public static final String URL_GET_ALL_INFORMATION = URL_ROOT + "/info";
}
