package com.ch2ps418.travelapp.di

import com.ch2ps418.travelapp.data.remote.retrofit.datasource.CategoryPlacesRemoteDataSource
import com.ch2ps418.travelapp.data.remote.retrofit.datasource.CategoryPlacesRemoteDataSourceImpl
import com.ch2ps418.travelapp.data.remote.retrofit.datasource.NearestPlacesRemoteDataSource
import com.ch2ps418.travelapp.data.remote.retrofit.datasource.NearestPlacesRemoteDataSourceImpl
import com.ch2ps418.travelapp.data.remote.retrofit.datasource.SearchPlacesRemoteDataSource
import com.ch2ps418.travelapp.data.remote.retrofit.datasource.SearchPlacesRemoteDataSourceImpl
import com.ch2ps418.travelapp.data.remote.retrofit.datasource.TopPlacesRemoteDataSource
import com.ch2ps418.travelapp.data.remote.retrofit.datasource.TopPlacesRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

	@Binds
	abstract fun provideNearestPlacesRemoteDataSource(nearestPlacesRemoteDataSource: NearestPlacesRemoteDataSourceImpl): NearestPlacesRemoteDataSource

	@Binds
	abstract fun provideSearchPlacesRemoteDataSource(searchPlacesRemoteDataSource: SearchPlacesRemoteDataSourceImpl): SearchPlacesRemoteDataSource

	@Binds
	abstract fun provideTopPlacesRemoteDataSource(topPlacesRemoteDataSourceImpl: TopPlacesRemoteDataSourceImpl): TopPlacesRemoteDataSource

	@Binds
	abstract fun provideCategoryPlacesRemoteDataSource(categoryPlacesRemoteDataSourceImpl: CategoryPlacesRemoteDataSourceImpl): CategoryPlacesRemoteDataSource

}