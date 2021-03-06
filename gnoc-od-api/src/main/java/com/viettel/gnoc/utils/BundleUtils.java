package com.viettel.gnoc.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author TungBoom
 *
 */
public class BundleUtils {

    protected static final Logger logger = LoggerFactory.getLogger(BundleUtils.class);

    private static volatile ResourceBundle rsConfig = null;

    public static String getLanguage(String key, Locale... locale) {
        ResourceBundle resource = ResourceBundle.getBundle("config/globalConfig");
        return resource.getString(key);
    }

    public static String getLangString(String key, Locale... locale) {
        Locale vi = new Locale("vi");

        try {
            if (locale != null) {
                if (locale.length == 0) {
                    rsConfig = ResourceBundle.getBundle(Constants.LANGUAGE, vi);
                } else {
                    rsConfig = ResourceBundle.getBundle(Constants.LANGUAGE, locale[0]);
                }
            } else {
                rsConfig = ResourceBundle.getBundle(Constants.LANGUAGE, vi);
            }
            return rsConfig.getString(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return key;
        }
    }

    public static String getMessage(String key, Locale locale, Object... params) {
        try {
            String ms = getLangString(key, locale);
            return MessageFormat.format(ms, params);
        } catch (MissingResourceException e) {
            logger.error(e.getMessage(), e);
            return '!' + key + '!';
        }
    }
}
