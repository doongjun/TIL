package hello.typeconverter.converter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ConverterTest {

    @Test
    fun stringToInteger() {
        val converter = StringToIntegerConverter()
        val result = converter.convert("10")
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun integerToString() {
        val converter = StringToIntegerConverter()
        val result = converter.convert("10")
        assertThat(result).isEqualTo(10)
    }

}