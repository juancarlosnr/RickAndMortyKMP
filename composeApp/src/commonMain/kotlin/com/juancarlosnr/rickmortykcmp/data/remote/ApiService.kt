package com.juancarlosnr.rickmortykcmp.data.remote

import com.juancarlosnr.rickmortykcmp.data.remote.response.CharacterResponse
import com.juancarlosnr.rickmortykcmp.data.remote.response.CharactersWrapperResponse
import com.juancarlosnr.rickmortykcmp.data.remote.response.EpisodesWrapperResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.parameters

class ApiService(private val client: HttpClient) {

    suspend fun getSingleCharacter(id: String): CharacterResponse{
        return client.get("/api/character/$id").body()
    }

    suspend fun getAllCharacters(page:Int): CharactersWrapperResponse{
        return client.get("/api/character/"){
            parameter("page",page)
        }.body()
    }

    suspend fun getAllEpisodes(page: Int): EpisodesWrapperResponse {
        return client.get("/api/episode/"){
            parameter("page",page)
        }.body()
    }

}