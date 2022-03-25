package com.dakuinternational.common.data.repository

import android.os.Handler
import com.dakuinternational.common.domain.model.DataContent
import com.dakuinternational.common.domain.model.Response
import com.dakuinternational.common.domain.repository.DataRepo
import com.dakuinternational.common.ui.utils.writeLog
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@ExperimentalCoroutinesApi
class RepoImp @Inject constructor(
    private val database: FirebaseFirestore
) : DataRepo {

    override suspend fun getAllData(dbName: String): Flow<Response<List<DataContent>>> = callbackFlow {
        val listener = database.collection(dbName).addSnapshotListener { value, error ->
            val response = if(error == null){
                val list = value?.toObjects(DataContent::class.java)!!
                if(list.isEmpty()) Response.Error("Failed to fetch data!")
                else Response.Success(list)
            }else {
                Response.Error(error.localizedMessage)
            }
            trySend(response).isSuccess
        }
        awaitClose {
            listener.remove()
        }
    }


    companion object{
        const val DATABASE_NAME = "black_jack"
    }

}