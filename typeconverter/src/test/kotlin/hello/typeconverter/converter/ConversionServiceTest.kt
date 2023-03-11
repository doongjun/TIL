package hello.typeconverter.converter

import hello.typeconverter.type.IpPort
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.core.convert.support.DefaultConversionService

class ConversionServiceTest {

    @Test
    fun conversionService() {
        val conversionService = DefaultConversionService()
        conversionService.addConverter(StringToIntegerConverter())
        conversionService.addConverter(IntegerToStringConverter())
        conversionService.addConverter(StringToIpPortConverter())
        conversionService.addConverter(IpPortToStringConverter())

        assertThat(conversionService.convert("10", Integer::class.java)).isEqualTo(10)
        assertThat(conversionService.convert(10, String::class.java)).isEqualTo("10")
        assertThat(conversionService.convert("127.0.0.1:8080", IpPort::class.java)).isEqualTo(IpPort("127.0.0.1", 8080))
        assertThat(conversionService.convert(IpPort("127.0.0.1", 8080), String::class.java)).isEqualTo("127.0.0.1:8080")
    }
}