package com.phincon.pokemonapp.novita.domain.use_case

import com.phincon.pokemonapp.novita.di.IoDispatcher
import com.phincon.pokemonapp.novita.domain.model.Pokemon
import com.phincon.pokemonapp.novita.domain.repository.HomeRepository
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetPokemonListUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(): Flow<Result<List<Pokemon>>> {
        return flow {
            val data = homeRepository.getPokemonList()
            emit(Result.success(data))
        }.catch { e ->
            emit(Result.failure(e))
        }.flowOn(ioDispatcher)
    }
}