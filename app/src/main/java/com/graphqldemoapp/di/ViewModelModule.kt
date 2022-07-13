package com.graphqldemoapp.di

import com.graphqldemoapp.repository.CharacterRepository
import com.graphqldemoapp.repository.CharacterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRepository(repository: CharacterRepositoryImpl) : CharacterRepository
}