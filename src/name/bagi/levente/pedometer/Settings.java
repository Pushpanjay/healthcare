

package name.bagi.levente.pedometer;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Activity for Pedometer settings.
 * Started when the user click Settings from the main menu.
 */
public class Settings extends PreferenceActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        addPreferencesFromResource(com.example.healthcare.R.xml.preferences);
    }
}
