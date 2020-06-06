package   com.example.movielistapp.main.data.repository


import androidx.lifecycle.MutableLiveData


import com.example.movielistapp.MovieService
import com.example.movielistapp.main.data.model.MovieRequest
import com.example.movielistapp.main.data.model.MovieResponse
import com.example.movielistapp.utils.Network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository constructor(
    private val movieService: MovieService = Network.retrofit.create(MovieService::class.java)
) {
    private lateinit var instance: MovieRepository

    fun getInstance(): MovieRepository {
        if (!::instance.isInitialized) {
            instance = MovieRepository()
        }
        return instance
    }

    fun getMovies(params: MovieRequest): MutableLiveData<MovieResponse> {
        val data = MutableLiveData<MovieResponse>()
        this.movieService.getMovies(params.apiKey, params.page)
            .enqueue(object : Callback<MovieResponse?> {

                override fun onResponse(
                    call: Call<MovieResponse?>,
                    response: Response<MovieResponse?>
                ) {
                    response.body()?.let {
                        data.value = it
                    }
                }

                override fun onFailure(call: Call<MovieResponse?>, t: Throwable) {
                    data.value = null
                }
            })
        return data
    }

}