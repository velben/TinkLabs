package com.ouweibin.interview.features.main.bean

import com.ouweibin.interview.core.extension.empty

class CityGuide(var imgUrl: String = "", 
                var title: String = "", 
                var description: String = ""){

    companion object {
        fun empty() = CityGuide(String.empty(), String.empty(), String.empty())
    }
}