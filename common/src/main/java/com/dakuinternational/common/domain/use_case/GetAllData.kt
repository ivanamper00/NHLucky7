package com.dakuinternational.common.domain.use_case

import com.dakuinternational.common.data.repository.RepoImp
import com.dakuinternational.common.domain.repository.DataRepo
import javax.inject.Inject

class GetAllData(
    private val repoImp: DataRepo
) {
    suspend operator fun invoke(dbName: String) = repoImp.getAllData(dbName)
}