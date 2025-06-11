
package org.tensorflow.lite.examples.modelpersonalization

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import org.tensorflow.lite.examples.modelpersonalization.databinding.ActivityMainBinding
import org.tensorflow.lite.examples.modelpersonalization.fragments.HelperDialog
import org.tensorflow.lite.examples.modelpersonalization.fragments.SettingFragment

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.imgSetting.setOnClickListener {
            if (viewModel.getCaptureMode() == true) {
                SettingFragment().show(
                    supportFragmentManager,
                    SettingFragment.TAG
                )
            } else {
                Toast.makeText(
                    this, "Change the setting only available in " +
                            "training mode", Toast.LENGTH_LONG
                ).show()
            }
        }
        activityMainBinding.tvHelper.setOnClickListener {
            HelperDialog().show(supportFragmentManager, HelperDialog.TAG)
        }
    }

    override fun onBackPressed() {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
            // Workaround for Android Q memory leak issue in IRequestFinishCallback$Stub.
            // (https://issuetracker.google.com/issues/139738913)
            finishAfterTransition()
        } else {
            super.onBackPressed()
        }
    }
}
