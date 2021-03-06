/*
 * Copyright (C) 2018 VenomRom Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.venom.settings.fragments;

import android.content.Context;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserHandle;
import android.support.v14.preference.SwitchPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.preference.PreferenceCategory;
import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.settings.SettingsPreferenceFragment;
import com.android.internal.logging.nano.MetricsProto;

import com.venom.settings.R;

import com.venom.settings.preferences.CustomSeekBarPreference;

public class QuickSettings extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {

    private static final String OMNI_QS_PANEL_BG_ALPHA = "qs_panel_bg_alpha";

    private CustomSeekBarPreference mQsPanelAlpha;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.venom_settings_quicksettings);
        ContentResolver resolver = getActivity().getContentResolver();
        final PreferenceScreen prefScreen = getPreferenceScreen();

        mQsPanelAlpha = (CustomSeekBarPreference) findPreference(OMNI_QS_PANEL_BG_ALPHA);
        int qsPanelAlpha = Settings.System.getIntForUser(resolver,
                Settings.System.OMNI_QS_PANEL_BG_ALPHA, 255, UserHandle.USER_CURRENT);
        mQsPanelAlpha.setValue(qsPanelAlpha);
        mQsPanelAlpha.setOnPreferenceChangeListener(this);
    }

     @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.VENOM;
    }

     @Override
    public void onResume() {
        super.onResume();
    }

     @Override
    public void onPause() {
        super.onPause();
    }

<<<<<<< HEAD:src/com/venom/settings/fragments/QuickSettings.java
     public boolean onPreferenceChange(Preference preference, Object newValue) {
=======
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (preference == mQsPanelAlpha) {
            int bgAlpha = (Integer) newValue;
            Settings.System.putIntForUser(getContentResolver(),
                    Settings.System.OMNI_QS_PANEL_BG_ALPHA, bgAlpha,
                    UserHandle.USER_CURRENT);
            return true;
        }
>>>>>>> abebc3e... Quick settings: Set transparency [2/2]:src/com/superior/settings/fragments/QuickSettings.java
        return false;
    }
}
