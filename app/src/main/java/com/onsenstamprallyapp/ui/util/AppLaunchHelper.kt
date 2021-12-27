package com.onsenstamprallyapp.ui.util

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri
import android.widget.Toast
import com.onsenstamprallyapp.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

internal class AppLaunchHelper @Inject constructor(@ApplicationContext private val context: Context) {
    fun launchMapApp(latitude: Double, longitude: Double, query: String) {
        launchExternalApp(onAction = {
            val uri = Uri.parse("geo:$latitude,$longitude?q=$query")
            Intent(Intent.ACTION_VIEW, uri).apply {
                addFlags(FLAG_ACTIVITY_NEW_TASK)
            }.let {
                context.startActivity(it)
            }
        }, onErrorAction = {
            showToast(context.getString(R.string.error_message_map_app))
        })
    }

    fun launchTelApp(tel: String) {
        launchExternalApp(onAction = {
            val uri = Uri.parse("tel:$tel")
            Intent(Intent.ACTION_DIAL, uri).apply {
                addFlags(FLAG_ACTIVITY_NEW_TASK)
            }.let {
                context.startActivity(it)
            }
        }, onErrorAction = {
            showToast(context.getString(R.string.error_message_tel_app))
        })
    }

    fun launchMailApp(address: String, subject: String, text: String) {
        launchExternalApp(onAction = {
            Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(address))
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, text)
                addFlags(FLAG_ACTIVITY_NEW_TASK)
            }.let {
                context.startActivity(it)
            }
        }, onErrorAction = {
            showToast(context.getString(R.string.error_message_gmail_app))
        })
    }

    fun launchInstagramApp(url: String) {
        launchExternalApp(onAction = {
            Intent(Intent.ACTION_VIEW).apply {
                addFlags(FLAG_ACTIVITY_NEW_TASK)
            }.also {
                it.setPackage("com.instagram.android")
                it.data = Uri.parse(url)
                context.startActivity(it)
            }
        }, onErrorAction = {
            showToast(context.getString(R.string.error_message_instagram_app))
        })
    }

    fun launchTwitterApp(url: String) {
        launchExternalApp(onAction = {
            Intent(Intent.ACTION_VIEW).apply {
                addFlags(FLAG_ACTIVITY_NEW_TASK)
            }.also {
                it.setPackage("com.twitter.android")
                it.data = Uri.parse(url)
                context.startActivity(it)
            }
        }, onErrorAction = {
            showToast(context.getString(R.string.error_message_twitter_app))
        })
    }

    fun launchFacebookApp(url: String) {
        launchExternalApp(onAction = {
            Intent(Intent.ACTION_VIEW).apply {
                addFlags(FLAG_ACTIVITY_NEW_TASK)
            }.also {
                it.setPackage("com.facebook.katana")
                it.data = Uri.parse("fb://facewebmodal/f?href=$url")
                context.startActivity(it)
            }
        }, onErrorAction = {
            showToast(context.getString(R.string.error_message_facebook_app))
        })
    }

    fun launchBrowserApp(url: String) {
        launchExternalApp(onAction = {
            Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                addFlags(FLAG_ACTIVITY_NEW_TASK)
            }.let {
                context.startActivity(it)
            }
        }, onErrorAction = {
            showToast(context.getString(R.string.error_message_browser_app))
        })
    }

    private fun launchExternalApp(onAction: () -> Unit, onErrorAction: (String) -> Unit) {
        kotlin.runCatching {
            onAction.invoke()
        }.onFailure {
            when (it) {
                is ActivityNotFoundException -> {
                    onErrorAction(it.localizedMessage ?: "launch app error.")
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}