package com.ma.basloq.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import com.ma.basloq.android.components.material.BasloqSecondrySnackbar
import com.ma.basloq.android.navigation.Navigation
import com.ma.basloq.android.theme.BasloqTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasloqTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                Scaffold(
                    snackbarHost = {
                        BasloqSecondrySnackbar(hostState = snackbarHostState)
                    },
                ) {
                    Navigation(snackbarHostState = snackbarHostState)
                }
            }
        }
    }
}

