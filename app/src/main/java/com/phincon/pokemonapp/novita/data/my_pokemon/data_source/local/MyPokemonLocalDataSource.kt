package com.phincon.pokemonapp.novita.data.my_pokemon.data_source.local

import com.phincon.pokemonapp.novita.data.detail.data_source.local.entity.MyPokemonEntity
import kotlinx.coroutines.flow.Flow

interface MyPokemonLocalDataSource {
    fun getMyPokemonList(): Flow<List<MyPokemonEntity>>
    fun deletePokemon(name: String)
}