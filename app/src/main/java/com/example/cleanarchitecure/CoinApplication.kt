package com.example.cleanarchitecure

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//basically just to give dagger hilts the information about applications
// so dagger hilt access to the application context if we need that for dependencies.
@HiltAndroidApp
class CoinApplication :Application() {
}