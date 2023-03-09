package hello.typeconverter.config

import hello.typeconverter.converter.IntegerToStringConverter
import hello.typeconverter.converter.IpPortToStringConverter
import hello.typeconverter.converter.StringToIntegerConverter
import hello.typeconverter.converter.StringToIpPortConverter
import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig: WebMvcConfigurer {
    override fun addFormatters(registry: FormatterRegistry) {
        registry.addConverter(StringToIntegerConverter())
        registry.addConverter(IntegerToStringConverter())
        registry.addConverter(StringToIpPortConverter())
        registry.addConverter(IpPortToStringConverter())
    }
}