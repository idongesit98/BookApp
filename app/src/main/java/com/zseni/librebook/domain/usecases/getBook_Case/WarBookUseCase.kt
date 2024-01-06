package com.zseni.librebook.domain.usecases.getBook_Case

import com.zseni.librebook.data.remoteModel.toBookDto
import com.zseni.librebook.domain.model.Books
import com.zseni.librebook.domain.repositories.BookRepository
import com.zseni.librebook.presentation.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WarBookUseCase @Inject constructor(val bookRepository: BookRepository) {
    operator fun invoke():Flow<Resource<Books>> = flow {
        try {
            emit(Resource.Loading())
            val warBooks = bookRepository.getWarBooks().toBookDto()
            emit(Resource.Success(warBooks))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage?:"Couldn't reach server. Please check internet connection"))
        }
    }
}