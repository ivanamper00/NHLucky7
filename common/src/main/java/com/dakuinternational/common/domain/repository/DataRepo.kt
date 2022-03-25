package com.dakuinternational.common.domain.repository

import com.dakuinternational.common.domain.model.DataContent
import com.dakuinternational.common.domain.model.Response
import kotlinx.coroutines.flow.Flow

interface DataRepo {
    suspend fun getAllData(dbName: String) : Flow<Response<List<DataContent>>>
}