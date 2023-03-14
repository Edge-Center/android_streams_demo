package ru.edgestreams.demo.utils

enum class StreamResolution(val width: Int, val height: Int) {
    FULL_HD(1920, 1080),
    HD(1280, 720),
    SD(720, 480)
}