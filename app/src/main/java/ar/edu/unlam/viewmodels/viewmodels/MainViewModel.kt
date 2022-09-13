package ar.edu.unlam.viewmodels.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(initialQuantity: Int) : ViewModel() {
    var clicksAmount: MutableLiveData<Int> = MutableLiveData(initialQuantity)

    class Factory(private val initialQuantity: Int) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(initialQuantity) as T
        }
    }

    fun increaseClicks() {
        viewModelScope.launch {
            val current = clicksAmount.value
            if (current != null) {
                    val next = current + 1
                    delay(3000L)
                    clicksAmount.value = next
            }
        }
    }

}