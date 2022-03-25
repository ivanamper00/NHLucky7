package com.dakuinternational.common.di

import com.dakuinternational.common.data.repository.RepoImp
import com.dakuinternational.common.domain.repository.DataRepo
import com.dakuinternational.common.domain.use_case.GetAllData
import com.dakuinternational.common.domain.use_case.UseCases
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject
import javax.inject.Singleton

@Module
@ExperimentalCoroutinesApi
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDB(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun providesRepo(
        db: FirebaseFirestore
    ): DataRepo = RepoImp(db)

    @Provides
    @Singleton
    fun providesUseCases(repo: DataRepo) = UseCases(
        getAllData = GetAllData(repo)
    )
}