package com.param.usn.Common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Aritra on 4/27/2016.
 */
public class AppPreference {
    private SharedPreferences preferences;
    private SharedPreferences.Editor edit;

    public static final String USERNAME                =	"USERNAME";
    public static final String PASSWORD 			   =	"PASSWORD";

    public AppPreference(Context context)
    {
        preferences		=	PreferenceManager.getDefaultSharedPreferences(context);
        edit			=	preferences.edit();
    }

    public void saveStringInPreference(String strKey,String strValue)
    {
        edit.putString(strKey, strValue);
        commitPreference();
    }

    public void removeFromPreference(String strKey)
    {
        edit.remove(strKey);
    }

    public void commitPreference()
    {
        edit.commit();
    }

    public String getStringFromPreference(String strKey,String defaultValue )
    {
        return preferences.getString(strKey, defaultValue);
    }
}
