package com.example.memeshare.utils

import kotlinx.coroutines.flow.*

fun <resultType,requestType> networkBoundResource(
    query:()-> Flow<resultType>,
    fetch:suspend ()->requestType,
    saveFetchResult: suspend (requestType)-> Unit,
    shouldFetch:(resultType)->Boolean ={true}
) = flow{
        val data=query().first()
        val flowResult = if(shouldFetch(data)){
            emit(Resource.Loading(data))
            try {
                saveFetchResult(fetch())
                query().map {
                    Resource.Success(it)
                }
            }catch (throwable:Throwable){
                    query().map {
                        Resource.Error(it,throwable)
                    }
            }
        }else {
            query().map {
                Resource.Success(it)
            }
        }
    emitAll(flowResult)
}