package com.dakuinternational.common.application

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        try {
            FirebaseApp.initializeApp(applicationContext)
            val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()
            val settings: FirebaseFirestoreSettings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true)
                .setCacheSizeBytes(FirebaseFirestoreSettings.CACHE_SIZE_UNLIMITED).build()
            firebaseFirestore.firestoreSettings = settings
        } catch (e: Exception) {  }
    }

}
