package com.draco.buoy.views

import android.app.ActivityManager
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.os.UserHandle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.draco.buoy.R
import com.draco.buoy.viewmodels.PermissionActivityViewModel
import com.google.android.material.snackbar.Snackbar

class PermissionActivity : AppCompatActivity() {
    private val viewModel: PermissionActivityViewModel by viewModels()

    private lateinit var command: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        command = findViewById(R.id.command)

        val userId = UserHandle.getUserHandleForUid(this.taskId).toString().filter {
            it.isDigit()
        }

        command.text = String.format(resources.getString(R.string.permission_command_with_user), userId)



        /* Copy ADB command to clipboard */
        command.setOnClickListener {
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("ADB Command", command.text.toString())
            clipboardManager.setPrimaryClip(clip)

            Snackbar.make(command, R.string.copied, Snackbar.LENGTH_SHORT).show()
        }

        /* Once permission is granted, return */
        viewModel.permissionGranted.observe(this) {
            if (it == true)
                finish()
        }
    }

    /* Disallow exit */
    override fun onBackPressed() {}
}
