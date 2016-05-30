package org.dai.mysettings;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity implements CompoundButton.OnCheckedChangeListener {

    private TextView mTxtDeviceProvisioned;
    private TextView mTxtUserSetupComplete;

    private Switch mSwitchDeviceProvisioned;
    private Switch mSwitchUserSetupComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private int getDeviceProvisioned() {
        return Settings.Global.getInt(getContentResolver(), Settings.Global.DEVICE_PROVISIONED, 0);
    }

    private int getUserSetupComplete() {
		return Settings.Secure.getInt( getContentResolver(), Settings.Secure.USER_SETUP_COMPLETE, 0);
    }

    private void setDeviceProvisioned(int value) {
		Settings.Global.putInt(getContentResolver(), Settings.Global.DEVICE_PROVISIONED, value);
    }

    private void setUserSetupComplete(int value) {
		Settings.Secure.putInt( getContentResolver(), Settings.Secure.USER_SETUP_COMPLETE, value);
    }

    private void initView() {
        mTxtDeviceProvisioned = (TextView) findViewById(R.id.txt_value_device_provisioned);
        mTxtUserSetupComplete = (TextView) findViewById(R.id.txt_value_setup_complete);

        mSwitchDeviceProvisioned = (Switch) findViewById(R.id.switch_device_provisioned);
        mSwitchDeviceProvisioned.setOnCheckedChangeListener(this);

        mSwitchUserSetupComplete = (Switch) findViewById(R.id.switch_setup_complete);
        mSwitchUserSetupComplete.setOnCheckedChangeListener(this);

        updateStatus();
    }

    private void updateStatus() {
        int iDeviceProvisioned = getDeviceProvisioned();
        int iSetupComplete = getUserSetupComplete();

        if (null != mTxtDeviceProvisioned) {
            mTxtDeviceProvisioned.setText(String.valueOf(iDeviceProvisioned));
        }

        if (null != mSwitchDeviceProvisioned) {
            mSwitchDeviceProvisioned.setChecked(0 != iDeviceProvisioned);
        }

        if (null != mTxtUserSetupComplete) {
            mTxtUserSetupComplete.setText(String.valueOf(iSetupComplete));
        }

        if (null != mSwitchUserSetupComplete)
            mSwitchUserSetupComplete.setChecked(0 != iSetupComplete);
    }

    /**
     * Called when the checked state of a compound button has changed.
     *
     * @param buttonView The compound button view whose state has changed.
     * @param isChecked  The new checked state of buttonView.
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()) {
            case R.id.switch_device_provisioned: {

                if (null != mSwitchDeviceProvisioned) {
                    setDeviceProvisioned(mSwitchDeviceProvisioned.isChecked() ? 1 : 0);
                }

                break;
            }
            case R.id.switch_setup_complete: {

                if (null != mSwitchUserSetupComplete) {
                    setUserSetupComplete(mSwitchUserSetupComplete.isChecked() ? 1 : 0);
                }
                break;
            }
        }

        updateStatus();
    }
}
