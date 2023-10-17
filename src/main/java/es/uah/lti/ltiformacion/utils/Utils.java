package es.uah.lti.ltiformacion.utils;

public class Utils {


    public static String getLang(String locale) {
        if (locale != null && locale.length() > 2) {
            return locale.substring(0, 2);
        }
        return locale;
    }

    public static String ensureEndWithSlash(String url) {

        if (!url.endsWith("/")) {
            url += "/";
        }
        return url;
    }

    /**
     * Generates Random String
     *
     * @param sisId
     * @return
     */
    public static String getRandoKey(String sisId) {

        return sisId + "_" + System.currentTimeMillis();
    }

    public static String buildKey(String redisMainKey, String sisId) {

        return redisMainKey + "_" + getRandoKey(sisId);
    }
}
