package com.graphqldemoapp.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.graphqldemoapp.CharactersListQuery

interface CharacterRepository {
    suspend fun queryCharacterList(): ApolloResponse<CharactersListQuery.Data>
}