
package org.tensorflow.lite.examples.modelpersonalization

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.TreeMap

class MainViewModel : ViewModel() {
    private val _numThread = MutableLiveData<Int>()
    val numThreads get() = _numThread

    private val _trainingState =
        MutableLiveData(TrainingState.PREPARE)
    val trainingState get() = _trainingState

    private val _captureMode = MutableLiveData(true)
    val captureMode get() = _captureMode

    private val _numberOfSamples = MutableLiveData(TreeMap<String, Int>())
    val numberOfSamples get() = _numberOfSamples

    fun configModel(numThreads: Int) {
        _numThread.value = numThreads
    }

    fun getNumThreads() = numThreads.value

    fun setTrainingState(state: TrainingState) {
        _trainingState.value = state
    }

    fun getTrainingState() = trainingState.value

    fun setCaptureMode(isCapture: Boolean) {
        _captureMode.value = isCapture
    }

    fun getCaptureMode() = captureMode.value

    fun increaseNumberOfSample(className: String) {
        val map: TreeMap<String, Int> = _numberOfSamples.value!!
        val currentNumber: Int = if (map.containsKey(className)) {
            map[className]!!
        } else {
            0
        }
        map[className] = currentNumber + 1
        _numberOfSamples.postValue(map)
    }

    fun getNumberOfSample() = numberOfSamples.value

    enum class TrainingState {
        PREPARE, TRAINING, PAUSE
    }
}
