package hello.typeconverter.formatter

import hello.typeconverter.converter.IpPortToStringConverter
import hello.typeconverter.converter.StringToIpPortConverter
import hello.typeconverter.type.IpPort
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.format.support.DefaultFormattingConversionService

class FormattingConversionServiceTest {

    @Test
    fun formattingConversionService() {
        val conversionService = DefaultFormattingConversionService()
        // converter
        conversionService.addConverter(StringToIpPortConverter())
        conversionService.addConverter(IpPortToStringConverter())
        // formatter
        conversionService.addFormatter(MyNumberFormatter())

        // converter
        val ipPort = conversionService.convert("127.0.0.1:8080", IpPort::class.java)
        assertThat(ipPort).isEqualTo(IpPort("127.0.0.1", 8080))
        // formatter
        assertThat(conversionService.convert(1000, String::class.java)).isEqualTo("1,000")
        assertThat(conversionService.convert("1,000", Long::class.java)).isEqualTo(1000L)
    }

}