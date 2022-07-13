package com.graphqldemoapp.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.graphqldemoapp.CharactersListQuery
import com.graphqldemoapp.networking.RickAndMortyApi
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val webService: RickAndMortyApi) :
    CharacterRepository{
    override suspend fun queryCharacterList(): ApolloResponse<CharactersListQuery.Data> {
        return webService.getApolloClient().query(CharactersListQuery()).execute()
    }


}