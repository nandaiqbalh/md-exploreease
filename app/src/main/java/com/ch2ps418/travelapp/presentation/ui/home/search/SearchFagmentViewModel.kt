package com.ch2ps418.travelapp.presentation.ui.home.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ch2ps418.travelapp.data.local.datastore.DataStoreManager
import com.ch2ps418.travelapp.data.remote.repository.SearchPlacesRepository
import com.ch2ps418.travelapp.data.remote.retrofit.model.BackendResponse
import com.ch2ps418.travelapp.wrapper.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchFagmentViewModel @Inject constructor(
	private val dataStoreManager: DataStoreManager,
	private val repository: SearchPlacesRepository,
) : ViewModel() {

	private val _placesResult = MutableLiveData<Resource<BackendResponse>>()
	fun getDeviceToken(): LiveData<String?> = dataStoreManager.getDeviceToken.asLiveData()

//	fun setDeviceToken(deviceToken: String) = CoroutineScope(Dispatchers.IO).launch {
//		dataStoreManager.setDeviceToken(deviceToken)
//	}


	fun getSearchPlace(deviceToken: String, placename: String) {
		viewModelScope.launch(Dispatchers.IO) {
			_placesResult.postValue(Resource.Loading())
			try {
				val data = repository.getSearchPlace(deviceToken, placename)

//				Log.d("PAYLOAD", data.payload.toString())
				if (data.payload != null) {
					viewModelScope.launch(Dispatchers.Main) {
						_placesResult.postValue(Resource.Success(data.payload))
					}
				} else {
					_placesResult.postValue(Resource.Error(data.exception, null))
				}
			} catch (e: Exception) {
				viewModelScope.launch(Dispatchers.Main) {
					_placesResult.postValue(Resource.Error(e, null))
				}
			}
		}
	}

}