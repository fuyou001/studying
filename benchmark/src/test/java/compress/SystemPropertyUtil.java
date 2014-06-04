package compress;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.regex.Pattern;

/**
 * User: yubao.fyb
 * Date: 14-6-4
 * Time: 14:27
 */
public class SystemPropertyUtil {
    private static final Pattern INTEGER_PATTERN = Pattern.compile("-?[0-9]+");

    public static int getInt(String key, int def) {
        String value = get(key, null);
        if (value == null) {
            return def;
        }

        value = value.trim().toLowerCase();
        if (INTEGER_PATTERN.matcher(value).matches()) {
            try {
                return Integer.parseInt(value);
            } catch (Exception e) {
                // Ignore
            }
        }
        return def;
    }

    public static String get(final String key, String def) {
        if (key == null) {
            throw new NullPointerException("key");
        }
        if (key.isEmpty()) {
            throw new IllegalArgumentException("key must not be empty.");
        }

        String value = null;
        try {
            if (System.getSecurityManager() == null) {
                value = System.getProperty(key);
            } else {
                value = AccessController.doPrivileged(new PrivilegedAction<String>() {
                    @Override
                    public String run() {
                        return System.getProperty(key);
                    }
                });
            }
        } catch (Exception e) {

        }

        if (value == null) {
            return def;
        }

        return value;
    }

}
