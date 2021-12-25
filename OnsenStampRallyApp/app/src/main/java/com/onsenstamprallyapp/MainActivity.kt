package com.onsenstamprallyapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.snackbar.Snackbar
import com.onsenstamprallyapp.databinding.ActivityMainBinding
import com.onsenstamprallyapp.ui.widget.ToastHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
internal class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var toastHelper: ToastHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, view.context.getString(R.string.fab_message), Snackbar.LENGTH_LONG)
                .setAction(view.context.getString(R.string.fab_action_message), View.OnClickListener {
                    val ctx = it.context
                    launchExternalMailApp(
                        ctx.getString(R.string.developer_mail_address),
                        ctx.getString(R.string.mail_subject),
                        ctx.getString(R.string.mail_text)
                    )
                }).show()
        }

        navController = findNavController(R.id.nav_host_fragment_content_main)
        observeDestination()
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.OnsenHomeFragment, R.id.OnsenListFragment, R.id.OnsenStampedListFragment
            ), binding.drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

    }


    private fun launchExternalMailApp(address: String, subject: String, text: String) {
        Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf(address))
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, text)
        }.let {
            try {
                startActivity(it)
            } catch (exception: ActivityNotFoundException) {
                toastHelper.showToast(exception.localizedMessage)
            }
        }
    }

    // TODO option menuは蓋とじ-START
    /*
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
     */
    // TODO option menuは蓋とじ-END

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun observeDestination() {
        navController.addOnDestinationChangedListener { n, destination, _ ->
            updateContent(destination.id)
        }
    }

    private fun updateContent(destinationId: Int) {
        when (destinationId) {
            R.id.OnsenHomeFragment, R.id.OnsenStampedListFragment -> {
                supportActionBar?.show()
                binding.appBarMain.fab.show()
            }
            else -> {
                supportActionBar?.show()
                binding.appBarMain.fab.hide()
            }
        }
    }
}