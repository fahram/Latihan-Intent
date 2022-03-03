package com.fahram.latihanintent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mahasiswa(val nim: Int, val nama:String)
    : Parcelable
