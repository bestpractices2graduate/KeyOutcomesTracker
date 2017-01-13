package bestpractices.keyoutcomestracker.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesKeyOutcomesTracker {

    private static final String SHARED_PREFERENCES_NAME = "bestpractices.keyoutcomestracker";
    private static final String IS_FIRST_TIME_LAUNCH = "isFirstTimeLaunch";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    public SharedPreferencesKeyOutcomesTracker(Context context) {
        Context context1 = context;
        int PRIVATE_MODE = 0;
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.apply();
    }

    public boolean isFirstTimeLaunch() {
        boolean isFirstTimeLaunch;
        isFirstTimeLaunch = sharedPreferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
        return isFirstTimeLaunch;
    }
}