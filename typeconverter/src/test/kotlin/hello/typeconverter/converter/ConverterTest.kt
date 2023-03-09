package hello.typeconverter.converter

import hello.typeconverter.type.IpPort
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

    @Test
    fun ipPortToString() {
        val converter = IpPortToStringConverter()
        val source = IpPort("127.0.0.1", 8080)
        val result = converter.convert(source)
        assertThat(result).isEqualTo("127.0.0.1:8080")
    }

    @Test
    fun stringToIpPort() {
        val converter = StringToIpPortConverter()
        val source = "127.0.0.1:8080"
        val result = converter.convert(source)
        assertThat(result).isEqualTo(IpPort("127.0.0.1", 8080))
    }

}